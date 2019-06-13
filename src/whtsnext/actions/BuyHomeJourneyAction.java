package whtsnext.actions;

import whtsnext.ValidActions;
import whtsnext.user.UserBean;

import java.util.Map;

import static whtsnext.ValidActions.DONE;
import static whtsnext.ValidActions.NOT_DONE;

public class BuyHomeJourneyAction extends JourneyActions {
    public BuyHomeJourneyAction(Journey home) {
        super(home, "Buy Home", 1);
    }

    @Override
    public ValidActions valid(UserBean userBean) {
        final Map<String, String> home = userBean.getUserAttributes().getHome();

        if (null == home || null == home.get("home") || null == home.get("owned"))
            return NOT_DONE;
        else
            return DONE;
    }

    @Override
    public JourneyActionPresentation[] journeyActionPresentation(UserBean userBean) {
        return null;
    }
}
