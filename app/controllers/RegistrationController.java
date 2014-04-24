package controllers;

import com.avaje.ebean.annotation.Transactional;
import com.fasterxml.jackson.databind.JsonNode;
import models.contact.Address;
import models.contact.Phone;
import models.relationship.Relationship;
import models.request.registration.RegistrationRequest;
import models.response.Message;
import models.user.Gender;
import models.user.User;
import models.user.UserType;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.registration;

import java.sql.Timestamp;

public class RegistrationController extends Controller {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("dd/MM/yyyy");
    private static final String URL_SEPARATOR = "/";

    public static Result registration(){
        return ok(registration.render("REGISTRATION"));
    }

    @BodyParser.Of(BodyParser.Json.class)
    @Transactional
    public static Result handleRegistration() {
        RegistrationRequest rr = null;
        User u = null;
        Phone p = null;
        Address a = null;
        JsonNode body = request().body().asJson();
        if (body != null)
            rr = Json.fromJson(body, RegistrationRequest.class);
        if(rr == null)
            return badRequest(Json.toJson(new Message(400, "Invalid parameters passed!", Message.MessageType.BAD_REQUEST)));
        u = new User();
        u.setFullName(rr.getFullName());
        u.setEmail(rr.getEmail());
        u.setPassword(rr.getPassword());
        u.setGender(Gender.valueOf(rr.getGender()));
        int _dd = rr.getDayOfBirth();
        int _mm = rr.getMonthOfBirth();
        int _yyyy = rr.getYearOfBirth();
        String _dobString = _dd + URL_SEPARATOR + _mm + URL_SEPARATOR + _yyyy;
        DateTime dob = DATE_TIME_FORMATTER.parseDateTime(_dobString);
        u.setDateOfBirth(new Timestamp(dob.getMillis()));
        u.setUserType(UserType.USER);
        u.setRelationshipToPrimary(Relationship.SELF);
        u.save();
        p = new Phone(rr.getPhone(), StringUtils.EMPTY, u);
        p.save();
        a = new Address(StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY, rr.getCity(), StringUtils.EMPTY, rr.getCountry(), rr.getPincode(), u);
        a.save();
        return ok(Json.toJson(new Message(200, "Registration successful!", Message.MessageType.SUCCESSFUL)));
    }
}
