package whtsnext.actions;

import whtsnext.ValidActions;
import whtsnext.user.UserBean;

import java.util.Map;

import static whtsnext.ValidActions.DONE;
import static whtsnext.ValidActions.NOT_DONE;

public class GetDewaJourneyAction extends JourneyActions {
    public GetDewaJourneyAction(Journey home) {
        super(home, "Get Dewa", 2);
    }

    @Override
    public ValidActions valid(UserBean userBean) {
        final Map<String, String> home = userBean.getUserAttributes().getHome();

        if (null == home || null == home.get("home"))
            return ValidActions.INVALID;
        else
            return null == home.get("dewa") ? NOT_DONE : DONE;
    }

    @Override
    public JourneyActionPresentation[] journeyActionPresentation(UserBean userBean) {
        return new JourneyActionPresentation[0];
    }
}
