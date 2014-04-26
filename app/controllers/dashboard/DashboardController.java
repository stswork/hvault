package controllers.dashboard;

import actions.Authenticated;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import models.measurements.Weight;
import models.response.user.UserResponse;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagar Gopale on 4/24/14.
 */
public class DashboardController extends Controller {

    private static DateTimeFormatter MONTH_FORMAT = DateTimeFormat.forPattern("MMM");

    @With(Authenticated.class)
    public static Result dashboard() {
        return ok(views.html.dashboard.dashboard.render("Dashboard"));
    }

    @With(Authenticated.class)
    public static Result getWeights() {
        UserResponse ur = (UserResponse) ctx().args.get("ur");
        List<models.response.dashboard.Weight> weightList = new ArrayList<models.response.dashboard.Weight>();
        List<Weight> weights = new ArrayList<Weight>();
        weights = Ebean.find(Weight.class).fetch("user").where(
                Expr.eq("user.id", ur.getId())
        ).orderBy("created desc").setMaxRows(7).findList();
        for(Weight w: weights) {
            models.response.dashboard.Weight weight = new models.response.dashboard.Weight(w.getId(), w.getUser() == null ? 0L : w.getUser().getId(), w.getPounds() == null ? 0 : w.getPounds(), w.getOunce() == null ? 0 : w.getOunce(), StringUtils.isEmpty(w.getNote()) ? StringUtils.EMPTY : w.getNote(), MONTH_FORMAT.print(w.getCreated().getTime()));
            weightList.add(weight);
        }
        Logger.info("WEIGHTS : " + Json.toJson(weightList));
        return ok(Json.toJson(weightList));
    }
}
