package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.annotation.Transactional;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.request.authentication.LoginRequest;
import models.response.Message;
import models.user.User;
import org.apache.commons.lang3.StringUtils;
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
        ObjectMapper mapper = new ObjectMapper();
        JsonNode body = request().body().asJson();
        if (body != null)
            lr = Json.fromJson(body, LoginRequest.class);
        if(lr == null)
            return badRequest(Json.toJson(new Message(400, "Invalid parameters passed!", Message.MessageType.BAD_REQUEST)));
        User u = Ebean.find(User.class).where(
                Expr.and(
                        Expr.eq("email", lr.getUserName()),
                        Expr.eq("password", lr.getPassword())
                )
        ).setMaxRows(1).findUnique();
        if(u == null)
            return notFound(Json.toJson(new Message(400, "No such user found!", Message.MessageType.NOT_FOUND)));
        try {
            session("user", StringUtils.toString(org.apache.commons.codec.binary.Base64.encodeBase64(mapper.writeValueAsString(u).getBytes()), "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            return internalServerError(Json.toJson(new Message(500, "Sorry, Unable to process your request!", Message.MessageType.BAD_REQUEST)));
        }
        return ok(login.render("Login"));
    }
}
