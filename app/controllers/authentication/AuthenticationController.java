package controllers.authentication;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.annotation.Transactional;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.contact.Email;
import models.contact.Phone;
import models.request.authentication.LoginRequest;
import models.response.Message;
import models.response.user.UserResponse;
import models.user.User;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.login;

/**
 * Created by Sagar Gopale on 4/20/14.
 */
public class AuthenticationController extends Controller {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("dd/MM/yyyy");

    public static Result login() {
        return ok(login.render("Login"));
    }

    @BodyParser.Of(BodyParser.Json.class)
    @Transactional
    public static Result handleLogin() {
        UserResponse ur = null;
        LoginRequest lr = null;
        Email em = null;
        Phone p = null;
        User u = null;
        ObjectMapper mapper = new ObjectMapper();
        JsonNode body = request().body().asJson();
        if (body != null)
            lr = Json.fromJson(body, LoginRequest.class);
        if(lr == null)
            return badRequest(Json.toJson(new Message(400, "Invalid parameters passed!", Message.MessageType.BAD_REQUEST)));
        em = Ebean.find(Email.class).fetch("user").where(
                Expr.eq("name", lr.getUserName())
        ).setMaxRows(1).findUnique();
        if(em == null || em.getUser() == null || !em.getUser().getPassword().equalsIgnoreCase(lr.getPassword()))
            return notFound(Json.toJson(new Message(404, "No such user found!", Message.MessageType.NOT_FOUND)));
        p = Ebean.find(Phone.class).fetch("user").where(
                Expr.and(
                        Expr.eq("user.id", em.getUser().getId()),
                        Expr.eq("phoneType", Phone.PhoneType.PRIMARY)
                )
        ).setMaxRows(1).findUnique();
        ur = new UserResponse(em.getUser().getFullName(), em.getName(), p == null ? StringUtils.EMPTY : p.getName(), DATE_TIME_FORMATTER.print(em.getUser().getDateOfBirth().getTime()), em.getUser().getGender().name(), em.getUser().getUserType().name());
        try {
            session("ur", StringUtils.toString(org.apache.commons.codec.binary.Base64.encodeBase64(mapper.writeValueAsString(ur).getBytes()), "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            return internalServerError(Json.toJson(new Message(500, "Sorry, Unable to process your request!", Message.MessageType.BAD_REQUEST)));
        }
        return ok(Json.toJson(new Message(200, "Login successful!", Message.MessageType.SUCCESSFUL)));
    }

    public static Result logout() {
        session().clear();
        return ok(login.render("Login"));
    }
}
