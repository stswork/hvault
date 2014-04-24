package controllers.user;

import actions.Authenticated;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.annotation.Transactional;
import models.contact.Address;
import models.contact.ContactType;
import models.relationship.Follow;
import models.response.user.Profile;
import models.response.user.UserResponse;
import org.apache.commons.lang3.StringUtils;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;

/**
 * Created by Sagar Gopale on 4/24/14.
 */
public class UserController extends Controller {

    @Transactional
    @With(Authenticated.class)
    public static Result profile(){

        UserResponse ur = (UserResponse) ctx().args.get("ur");
        Profile p = new Profile();
        Address a = null;
        int followingCount = 0;
        int followerCount = 0;
        //FINDING COUNT OF PEOPLE USER IS FOLLOWING
        followingCount = Ebean.find(Follow.class).fetch("source").where(
                Expr.eq("source.id", ur.getId())
        ).findRowCount();
        //FINDING COUNT OF PEOPLE FOLLOWING THE USER
        followerCount = Ebean.find(Follow.class).fetch("destination").where(
                Expr.eq("destination.id", ur.getId())
        ).findRowCount();
        //FINDING THE PRIMARY ADDRESS OF THE USER
        a = Ebean.find(Address.class).fetch("user").where(
                Expr.and(
                        Expr.eq("user.id", ur.getId()),
                        Expr.eq("addressType", ContactType.PRIMARY)
                )
        ).orderBy("created desc").setMaxRows(1).findUnique();
        if(a == null)
            a = new Address();
        //CREATING THE ADDRESS STRING OF THE USER
        String _city = StringUtils.isEmpty(a.getCity()) ? StringUtils.EMPTY : a.getCity();
        String _state = StringUtils.isEmpty(a.getState()) ? StringUtils.EMPTY : a.getState();
        String _country = StringUtils.isEmpty(a.getCountry()) ? StringUtils.EMPTY : a.getCountry();
        String _pincode = StringUtils.isEmpty(a.getPincode()) ? StringUtils.EMPTY : a.getPincode();
        String address = _city + " " + _pincode + ", " + _state + ", " + _country;
        //ASSIGNING THE VALUES TO PROFILE OBJECT
        p.setUserResponse(ur);
        p.setAddress(address);
        p.setFollowerCount(followerCount);
        p.setFollowingCount(followingCount);
        return ok(views.html.profile.profile.render("Profile", p));
    }
}
