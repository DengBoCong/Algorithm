from flask import Flask, render_template, g

app = Flask(__name__, template_folder="templates", static_folder="static")
app.jinja_env.variable_start_string = "[["
app.jinja_env.variable_end_string = "]]"


@app.errorhandler(404)
def page_not_found(e):
    return render_template("404.html"), 403


with app.app_context():
    g.contextPath = ""


@app.route("/<catalog>/<subject>")
def index(catalog, subject):
    return render_template("main.html", title=catalog)


if __name__ == "__main__":
    app.run(debug=True)
