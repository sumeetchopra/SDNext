package whtsnext.actions;

import whtsnext.ValidActions;
import whtsnext.user.UserBean;

import java.util.Map;

import static whtsnext.ValidActions.*;

public class RenewLicenseJourneyAction extends JourneyActions {
    public RenewLicenseJourneyAction(Journey driveACar) {
        super(driveACar, "Renew License", 1);
    }

    @Override
    public ValidActions valid(UserBean userBean) {
        final Map<String, String> license = userBean.getUserAttributes().getLicense();

        return null == license ? INVALID : null == license.get("expired") ? DONE: NOT_DONE;
    }

    @Override
    public JourneyActionPresentation[] journeyActionPresentation(UserBean userBean) {
        return null;
    }
}
