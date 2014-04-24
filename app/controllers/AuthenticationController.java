package controllers;

import com.avaje.ebean.annotation.Transactional;
import com.fasterxml.jackson.databind.JsonNode;
import models.request.authentication.LoginRequest;
import models.response.Message;
import play.libs.Json;
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

        LoginRequest lr = null;
        JsonNode body = request().body().asJson();
        if (body != null)
            lr = Json.fromJson(body, LoginRequest.class);
        if(lr == null)
            return badRequest(Json.toJson(new Message(400, "Invalid parameters passed!", Message.MessageType.BAD_REQUEST)));

        return ok(login.render("Login"));
    }
}
