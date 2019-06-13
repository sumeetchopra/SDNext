package whtsnext.actions;

import whtsnext.ValidActions;
import whtsnext.user.UserBean;

import java.util.Map;

import static whtsnext.ValidActions.DONE;
import static whtsnext.ValidActions.NOT_DONE;

public class BuyHomeInsuranceJourneyAction extends JourneyActions {
    public BuyHomeInsuranceJourneyAction(Journey insurance) {
        super(insurance, "Buy Home Insurance", 1);
    }

    @Override
    public ValidActions valid(UserBean userBean) {
        final Map<String, String> home = userBean.getUserAttributes().getHome();

        if (null == home || null == home.get("home") || null == home.get("owned"))
            return ValidActions.INVALID;
        else
            return null == home.get("insurance") ? NOT_DONE : DONE;
    }

    @Override
    public JourneyActionPresentation[] journeyActionPresentation(UserBean userBean) {
        return null;
    }
}
