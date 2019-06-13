package whtsnext.actions;

import whtsnext.ValidActions;
import whtsnext.user.UserBean;

import java.util.Map;

import static whtsnext.ValidActions.*;

public class RentHomeJourneyAction extends JourneyActions {
    public RentHomeJourneyAction(Journey home) {
        super(home, "Rent Home", 1);
    }

    @Override
    public ValidActions valid(UserBean userBean) {
        final Map<String, String> home = userBean.getUserAttributes().getHome();

        if (null == home || null == home.get("home"))
            return NOT_DONE;
        else if (null != home.get("owned"))
            return INVALID;
        else
            return DONE;
    }

    @Override
    public JourneyActionPresentation[] journeyActionPresentation(UserBean userBean) {
        return null;
    }
}
