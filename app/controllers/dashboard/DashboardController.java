package controllers.dashboard;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.dashboard;

/**
 * Created by Sagar Gopale on 4/24/14.
 */
public class DashboardController extends Controller {

    public static Result dashboard() {
        return ok(dashboard.render("Dashboard"));
    }
}
