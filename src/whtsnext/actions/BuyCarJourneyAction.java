package whtsnext.actions;

import whtsnext.ValidActions;
import whtsnext.user.UserBean;

import static whtsnext.ValidActions.DONE;
import static whtsnext.ValidActions.NOT_DONE;

public class BuyCarJourneyAction extends JourneyActions {
    public BuyCarJourneyAction(Journey driveACar) {
        super(driveACar, "Buy Car", 2);
    }

    @Override
    public ValidActions valid(UserBean userBean) {
        return null == userBean.getUserAttributes().getVehicles() ? NOT_DONE : DONE;
    }

    @Override
    public JourneyActionPresentation[] journeyActionPresentation(UserBean userBean) {
        return null;
    }
}
