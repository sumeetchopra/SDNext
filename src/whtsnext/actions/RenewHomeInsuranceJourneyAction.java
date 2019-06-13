package whtsnext.actions;

import whtsnext.ValidActions;
import whtsnext.user.UserBean;

import java.util.Map;

import static whtsnext.ValidActions.*;

public class RenewHomeInsuranceJourneyAction extends JourneyActions {
    public RenewHomeInsuranceJourneyAction(Journey insurance) {
        super(insurance, "Renew Home Insurance", 1);
    }

    @Override
    public ValidActions valid(UserBean userBean) {
        final Map<String, String> home = userBean.getUserAttributes().getHome();

        if (null == home || null == home.get("home") || null == home.get("owned") || null == home.get("insurance"))
            return INVALID;
        else
            return null == home.get("insurancexpired") ?  DONE: NOT_DONE;
    }

    @Override
    public JourneyActionPresentation[] journeyActionPresentation(UserBean userBean) {
        return null;
    }
}
