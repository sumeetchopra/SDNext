package whtsnext.actions;

import whtsnext.ValidActions;
import whtsnext.user.UserBean;

import java.util.List;
import java.util.Map;

import static whtsnext.ValidActions.INVALID;
import static whtsnext.ValidActions.NOT_DONE;

public class PayFinesJourneyAction extends JourneyActions {
    public PayFinesJourneyAction(Journey driveACar) {
        super(driveACar, "Pay Fines", 3);
    }

    @Override
    public ValidActions valid(UserBean userBean) {
        final List<Map<String, String>> fines = userBean.getUserAttributes().getFines();

        return null == fines ? INVALID : NOT_DONE;
    }

    @Override
    public JourneyActionPresentation[] journeyActionPresentation(UserBean userBean) {
        return null;
    }
}
