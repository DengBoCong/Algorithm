import os
import json
import settings
import markdown
from flask import Flask, render_template, g

app = Flask(__name__, template_folder="templates", static_folder="static")
app.jinja_env.variable_start_string = "[["
app.jinja_env.variable_end_string = "]]"


@app.errorhandler(404)
def page_not_found(e):
    return render_template("404.html"), 403


with app.app_context():
    g.contextPath = ""


def preprocess_code_data(file_path):
    os.listdir(file_path)


@app.template_filter("md2html")
def md2html(file_path):
    with open(file_path, "r", encoding="utf-8") as file:
        return markdown.markdown(file.read().__str__())


@app.route("/<view>/<catalog>/<subject>")
def index(view, catalog, subject):
    with open(settings.config_path, "r", encoding="utf-8") as file:
        data = json.load(file)
        menu = dict()
        if view == "all":
            menu = data["class"]
        else:
            if not data["origin"].get(view, None):
                return render_template("404.html")
            menu = data["origin"][view]

        code_file_dict = dict()
        for (key, path) in [("C++", subject + ".cpp"), ("Java", subject + ".java"), ("Python", subject + ".py")]:
            if os.path.exists(path):
                code_file_dict[key] = path

        catalogue = data["catalogue"]
        te1 = dict()
        te1.items()

    return render_template("main.html", view=view, subject=subject, menu=menu, title="哈哈",
                           catalogue=catalogue, catalog=catalog, code_file_dict=code_file_dict)


def preprocess_code_data(file_path, dir_name, global_dict):
    if not os.path.isdir(file_path):
        return

    md_file_path = file_path + "/" + dir_name + ".md"
    if os.path.exists(file_path + "/" + dir_name + ".md"):
        with open(md_file_path, "r", encoding="utf-8") as md_file:
            item = {"title": None, "class": None, "origin": None, "path": file_path + "/" + dir_name}
            for line in md_file:
                line = line.strip(" ").strip("\n")
                if line == "":
                    continue
                if not line.startswith("$="):
                    break

                try:
                    key, value = line.split(":")
                    key, value = key.strip(" ").strip("\n"), value.strip(" ").strip("\n")
                    if key == "$=title=$":
                        item["title"] = value
                    elif key == "$=class=$":
                        item["class"] = value
                    elif key == "$=origin=$":
                        item["origin"] = value
                except ValueError:
                    continue

            if not (item["class"] and item["title"] and item["origin"]):
                return

            item["name"] = "{}-{}-{}".format(item["origin"], item["class"], dir_name)
            item["link"] = "all/{}/{}".format(item["class"], item["name"])

            if not global_dict["class"].get(item["class"], None):
                global_dict["class"][item["class"]] = [item.copy()]
            elif global_dict["class"].get(item["class"], None):
                global_dict["class"][item["class"]].append(item.copy())

            item["link"] = "{}/{}/{}".format(item["origin"], item["class"], item["name"])
            if not global_dict["origin"].get(item["origin"], None):
                global_dict["origin"][item["origin"]] = {item["class"]: [item]}
            elif global_dict["origin"].get(item["origin"], None) \
                    and not global_dict["origin"][item["origin"]].get(item["class"], None):
                global_dict["origin"][item["origin"]][item["class"]] = [item]
            elif global_dict["origin"].get(item["origin"], None) \
                    and global_dict["origin"][item["origin"]].get(item["class"], None):
                global_dict["origin"][item["origin"]][item["class"]].append(item)

            if global_dict["catalogue"].get("-".join([item["origin"], item["class"], item["title"]]), None):
                print("{} 该命名在当前来源及分类下重名，重名位置 {}".format(
                    "-".join([item["origin"], item["class"], item["title"]]),
                    global_dict["catalogue"]["-".join([item["origin"], item["class"], item["title"]])]
                ))
                exit(0)
            else:
                global_dict["catalogue"]["-".join([item["origin"], item["class"], item["title"]])] = "/{}/{}".format(item["class"], item["name"])
    else:
        sub_list = os.listdir(file_path)
        for sub in sub_list:
            preprocess_code_data(file_path + "/" + sub, sub, global_dict)


if __name__ == "__main__":
    global_dict = {"class": {}, "origin": {}, "catalogue": {}}
    preprocess_code_data("src", "src", global_dict)
    print(global_dict)
    with open(settings.config_path, "w", encoding="utf-8") as config_file:
        config_file.write(json.dumps(global_dict, ensure_ascii=True, indent=4))
    app.run(debug=True)
