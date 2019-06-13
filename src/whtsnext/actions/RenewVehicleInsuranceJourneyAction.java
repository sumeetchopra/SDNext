package whtsnext.actions;

import whtsnext.ValidActions;
import whtsnext.user.UserBean;

import static whtsnext.ValidActions.DONE;
import static whtsnext.ValidActions.NOT_DONE;

public class RenewVehicleInsuranceJourneyAction extends JourneyActions {
    public RenewVehicleInsuranceJourneyAction(Journey insurance) {
        super(insurance, "Renew Vehicle Insurance", 1);
    }

    @Override
    public ValidActions valid(UserBean userBean) {
        if (null == userBean.getUserAttributes().getVehicles())
            return ValidActions.INVALID;
        else {
            return userBean.getUserAttributes().getVehicles()
                    .stream()
                    .anyMatch(v -> null == v.get("expired")) ? DONE: NOT_DONE;
        }
    }

    @Override
    public JourneyActionPresentation[] journeyActionPresentation(UserBean userBean) {
        return new JourneyActionPresentation[0];
    }
}
