package whtsnext.actions;

import whtsnext.ValidActions;
import whtsnext.user.UserBean;

import static whtsnext.ValidActions.DONE;
import static whtsnext.ValidActions.NOT_DONE;

public class RentCarJourneyAction extends JourneyActions {
    public RentCarJourneyAction(Journey driveACar) {
        super(driveACar, "Rent Car", 2);
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
