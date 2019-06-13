package whtsnext;

import whtsnext.actions.Journey;
import whtsnext.actions.JourneyActions;
import whtsnext.user.UserBean;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toMap;
import static whtsnext.JourneySetup.getInstance;

public class WhtsNextDeterminationEngine {

    public List<JourneyActions.JourneyActionPresentation> whtsNextForUser(UserBean userBean) {
        final List<Journey> journeyList = getInstance().getJourneys();

        final Map<JourneyActions, ValidActions> actionsMap = collectValidActions(userBean, journeyList);

        System.out.println(actionsMap);

        return emptyList();
    }

    private Map<JourneyActions, ValidActions> collectValidActions(UserBean userBean, List<Journey> journeyList) {
        return journeyList.stream()
                .map(Journey::getActions)
                .flatMap(Collection::stream)
                .collect(toMap(ja -> ja, ja -> ja.valid(userBean)))
                .entrySet().stream()
                .filter(m -> !m.getValue().equals(ValidActions.INVALID))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
