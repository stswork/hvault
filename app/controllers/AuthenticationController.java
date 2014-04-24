package controllers;

import com.avaje.ebean.annotation.Transactional;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.login;

/**
 * Created by Sagar Gopale on 4/20/14.
 */
public class AuthenticationController extends Controller {

    public static Result login() {
        return ok(login.render("Login"));
    }

    @BodyParser.Of(BodyParser.Json.class)
    @Transactional
    public static Result handleLogin() {

        return ok(login.render("Login"));
    }
}
