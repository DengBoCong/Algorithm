from flask import Flask, render_template, g
from flask_cache import Cache

app = Flask(__name__, template_folder="templates", static_folder="static")
cache = Cache(config={"CACHE_TYPE": "simple"})
cache.init_app(app)


@app.errorhandler(404)
def page_not_found(e):
    return render_template("404.html"), 403


with app.app_context():
    g.contextPath = ""

if __name__ == "__main__":
    app.run()
