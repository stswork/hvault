package controllers.dashboard;

import actions.Authenticated;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;
import views.html.dashboard;

/**
 * Created by Sagar Gopale on 4/24/14.
 */
public class DashboardController extends Controller {

    @With(Authenticated.class)
    public static Result dashboard() {
        return ok(dashboard.render("Dashboard"));
    }
}
