package actions;


import com.fasterxml.jackson.databind.ObjectMapper;
import models.response.user.UserResponse;
import models.user.User;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.SimpleResult;

public class Authenticated extends Action.Simple {

    @Override
    public F.Promise<SimpleResult> call(Http.Context ctx) throws Throwable {
        String _userResponse = ctx.session().get("ur");
        if(!StringUtils.isEmpty(_userResponse)) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                UserResponse ur = mapper.readValue(StringUtils.toString(Base64.decodeBase64(_userResponse.getBytes()), "UTF-8"), UserResponse.class);
                ctx.args.put("ur", ur);
                return delegate.call(ctx);
            } catch(Exception e) {
                e.printStackTrace();
                Logger.error(e.getMessage(), e);
                return F.Promise.pure(redirect(controllers.authentication.routes.AuthenticationController.login()));
            }
        } else {
            return F.Promise.pure(redirect(controllers.authentication.routes.AuthenticationController.login()));
        }
    }
}
