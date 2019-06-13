package whtsnext.actions;

import whtsnext.ValidActions;
import whtsnext.user.UserBean;

public class BuyVehicleInsuranceJourneyAction extends JourneyActions {
    public BuyVehicleInsuranceJourneyAction(Journey insurance) {
        super(insurance, "Buy Vehicle Insurance", 1);
    }

    @Override
    public ValidActions valid(UserBean userBean) {
        if (null == userBean.getUserAttributes().getVehicles())
            return ValidActions.INVALID;
        else {
            return userBean.getUserAttributes().getVehicles()
                    .stream()
                    .anyMatch(v -> null == v.get("insurance")) ? ValidActions.NOT_DONE : ValidActions.DONE;
        }
    }

    @Override
    public JourneyActionPresentation[] journeyActionPresentation(UserBean userBean) {
        return null;
    }
}
