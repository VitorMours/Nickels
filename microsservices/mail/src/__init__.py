from flask import Flask
from flask_admin import Admin
from flask_admin.theme import Bootstrap4Theme


def create_app():
    app = Flask(__name__, template_folder="templates")
    admin = Admin(
        app, name="Email Microsservice Admin", theme=Bootstrap4Theme(swatch="flatly")
    )
    return app
