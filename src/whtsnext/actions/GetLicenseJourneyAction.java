package whtsnext.actions;

import whtsnext.ValidActions;
import whtsnext.user.UserBean;

import java.util.Map;

import static whtsnext.ValidActions.DONE;
import static whtsnext.ValidActions.NOT_DONE;

public class GetLicenseJourneyAction extends JourneyActions {
    public GetLicenseJourneyAction(Journey driveACar) {
        super(driveACar, "Get License", 1);
    }

    @Override
    public ValidActions valid(UserBean userBean) {
        final Map<String, String> license = userBean.getUserAttributes().getLicense();

        return null == license ? NOT_DONE : DONE;
    }

    @Override
    public JourneyActionPresentation[] journeyActionPresentation(UserBean userBean) {
        return null;
    }
}
