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


@app.template_filter("file2text")
def file2text(file_path):
    if not os.path.exists(file_path):
        return "无内容"

    with open(file_path, "r", encoding="utf-8") as file:
        if file_path.split(".")[-1] != "md":
            return file.read().__str__()

        lines = file.readlines()
        contents = ""
        for index, line in enumerate(lines):
            line = line.strip(" ").strip("\n")
            if line == "" or line.startswith("$="):
                continue
            contents = "".join(lines[index:])
            break

        return contents


# @app.template_filter("md2html")
# def md2html(file_path):
#     with open(file_path, "r", encoding="utf-8") as file:
#         if file_path.split(".")[-1] != "md":
#             return markdown.markdown(file.read().__str__())
#
#         lines = file.readlines()
#         contents = ""
#         for index, line in enumerate(lines):
#             line = line.strip(" ").strip("\n")
#             if line == "" or line.startswith("$="):
#                 continue
#             contents = "".join(lines[index:])
#             break
#         return markdown.markdown(text=contents, extensions=['extra'])


@app.route("/<view>")
@app.route("/")
def home(view=None):
    if not view:
        view = "all"
    with open(settings.config_path, "r", encoding="utf-8") as file:
        data = json.load(file)
        menu = data["class"]
        catalogue = data["catalogue"]
        origin = data["origin"].keys()
    return render_template("home.html", filename=settings.home_page, menu=menu,
                           origin=origin, view=view, catalogue=catalogue, settings=settings)


@app.route("/<view>/<catalog>/<subject>")
def main(view, catalog, subject):
    with open(settings.config_path, "r", encoding="utf-8") as file:
        data = json.load(file)
        menu = dict()
        if view == "all":
            menu = data["class"]
        else:
            if not data["origin"].get(view, None):
                return render_template("404.html")
            menu = data["origin"][view]

        try:
            code_file_dict, solve_dict = dict(), dict()
            for (key, path) in [("C++", menu[catalog][subject]["path"] + ".cpp"),
                                ("Java", menu[catalog][subject]["path"] + ".java"),
                                ("Python", menu[catalog][subject]["path"] + ".py")]:
                if os.path.exists(path):
                    code_file_dict[key] = path

            solve_dict = {"project": menu[catalog][subject]["path"] + ".md",
                          "solve": menu[catalog][subject]["path"] + "_solution.md"}
        except KeyError:
            return render_template("404.html")

        catalogue = data["catalogue"]

    return render_template("main.html", view=view, subject=subject, menu=menu,
                           item=menu[catalog][subject], solve_dict=solve_dict,
                           catalogue=catalogue, catalog=catalog, code_file_dict=code_file_dict, settings=settings)


def preprocess_code_data(file_path, dir_name, global_dict):
    if not os.path.isdir(file_path):
        return

    md_file_path = file_path + "/" + dir_name + ".md"
    if os.path.exists(file_path + "/" + dir_name + ".md"):
        with open(md_file_path, "r", encoding="utf-8") as md_file:
            item = {"title": None, "class": None, "origin": None, "degree": None,
                    "origin_link": None, "path": file_path + "/" + dir_name}
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
                    elif key == "$=degree=$":
                        item["degree"] = value
                    elif key == "$=link=$":
                        item["origin_link"] = value
                except ValueError:
                    continue

            if not (item["class"] and item["title"] and item["origin"] and item["degree"]):
                return

            project_name = "{}-{}-{}".format(item["origin"], item["class"], dir_name)
            # item["link"] = "{}all/{}/{}".format(settings.url, item["class"], project_name)
            item["second_link"] = "/{}/{}".format(item["class"], project_name)

            if not global_dict["class"].get(item["class"], None):
                global_dict["class"][item["class"]] = {project_name: item.copy()}
            elif global_dict["class"].get(item["class"], None):
                if not global_dict["class"][item["class"]].get(project_name, None):
                    assert RuntimeWarning("{} 该命名在当前来源及分类下重名，重名位置 {}".format(project_name, item["path"]))
                global_dict["class"][item["class"]][project_name] = item.copy()

            # item["link"] = "{}{}/{}/{}".format(settings.url, item["origin"], item["class"], project_name)
            if not global_dict["origin"].get(item["origin"], None):
                global_dict["origin"][item["origin"]] = {item["class"]: {project_name: item}}
            elif global_dict["origin"].get(item["origin"], None) \
                    and not global_dict["origin"][item["origin"]].get(item["class"], None):
                global_dict["origin"][item["origin"]][item["class"]] = {project_name: item}
            elif global_dict["origin"].get(item["origin"], None) \
                    and global_dict["origin"][item["origin"]].get(item["class"], None):
                if not global_dict["origin"][item["origin"]][item["class"]].get(project_name, None):
                    assert RuntimeWarning("{} 该命名在当前来源及分类下重名，重名位置 {}".format(project_name, item["path"]))
                global_dict["origin"][item["origin"]][item["class"]][project_name] = item

            if global_dict["catalogue"].get("-".join([item["origin"], item["class"], item["title"]]), None):
                assert RuntimeWarning("{} 该命名在当前来源及分类下重名，重名位置 {}".format(
                    "-".join([item["origin"], item["class"], item["title"]]),
                    global_dict["catalogue"]["-".join([item["origin"], item["class"], item["title"]])]
                ))
            else:
                global_dict["catalogue"]["-".join([item["origin"], item["class"], item["title"]])] = \
                    "{}all/{}/{}".format(settings.url, item["class"], project_name)
    else:
        sub_list = os.listdir(file_path)
        for sub in sub_list:
            preprocess_code_data(file_path + "/" + sub, sub, global_dict)


if __name__ == "__main__":
    pre_dict = {"class": {}, "origin": {}, "catalogue": {}}
    preprocess_code_data("core", "core", pre_dict)
    with open(settings.config_path, "w", encoding="utf-8") as config_file:
        config_file.write(json.dumps(pre_dict, ensure_ascii=True, indent=4))
    app.run(debug=True)
