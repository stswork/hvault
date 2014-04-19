package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    public static Result login() {
        return ok(login.render("Login"));
    }
    public static Result dashboard() {
        return ok(dashboard.render("Dashboard"));
    }

    public static Result profile() {
        return ok(profile.render("Profile"));
    }

    public static Result form() {
        return ok(form.render("Form"));
    }
}
