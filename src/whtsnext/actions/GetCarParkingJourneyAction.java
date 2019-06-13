package whtsnext.actions;

import whtsnext.ValidActions;
import whtsnext.user.UserBean;

public class GetCarParkingJourneyAction extends JourneyActions {
    public GetCarParkingJourneyAction(Journey home) {
        super(home, "Get Car Parking", 3);
    }

    @Override
    public ValidActions valid(UserBean userBean) {
        if (null == userBean.getUserAttributes().getVehicles())
            return ValidActions.INVALID;
        else {
            return userBean.getUserAttributes().getVehicles()
                    .stream()
                    .anyMatch(v -> null == v.get("parking")) ? ValidActions.NOT_DONE : ValidActions.DONE;
        }
    }

    @Override
    public JourneyActionPresentation[] journeyActionPresentation(UserBean userBean) {
        return null;
    }
}
