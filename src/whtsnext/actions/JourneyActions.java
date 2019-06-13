package whtsnext.actions;

import whtsnext.ValidActions;
import whtsnext.user.UserBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class JourneyActions {
    private final Journey journey;
    private final String action;
    private final int priority;
    private List<JourneyActions> next = new ArrayList<>();

    public JourneyActions(Journey journey, String action, int priority) {
        this.journey = journey;
        this.action = action;
        this.priority = priority;
        this.journey.getActions().add(this);
    }

    public Journey getJourney() {
        return journey;
    }

    public String getAction() {
        return action;
    }

    public abstract ValidActions valid(UserBean userBean);

    public abstract JourneyActionPresentation[] journeyActionPresentation(UserBean userBean);

    public List<JourneyActions> getNext() {
        return next;
    }

    public JourneyActions setNext(List<JourneyActions> next) {
        this.next = next;
        return this;
    }

    public int getPriority() {
        return priority;
    }

    public String toString() {
        return action + " : " + priority;
    }

    public class JourneyActionPresentation {
        private final Map<String, String> attributes;
        private String presentation = "Default";

        public JourneyActionPresentation(Map<String, String> attributes) {
            this.attributes = attributes;
        }

        public String getPresentation() {
            return presentation;
        }
    }
}
