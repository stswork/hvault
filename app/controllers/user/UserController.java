package controllers.user;

import com.avaje.ebean.annotation.Transactional;
import models.response.user.UserResponse;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Sagar Gopale on 4/24/14.
 */
public class UserController extends Controller {

    @Transactional
    public static Result profile(){
        UserResponse ur = (UserResponse) ctx().args.get("ur");

        //HAVE TO CREATE A PROFILE RESPONSE OBJECT AND SEND TO PROFILE PAGE AND NOT USER
        return ok(views.html.profile.profile.render("Profile", ur));
    }
}
