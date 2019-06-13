package whtsnext.actions;

import java.util.ArrayList;
import java.util.List;

public class Journey {
    private final int id;
    private final String name;

    private List<JourneyActions> actions = new ArrayList<>();

    public Journey(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<JourneyActions> getActions() {
        return actions;
    }

    public Journey setActions(List<JourneyActions> actions) {
        this.actions = actions;
        return this;
    }
}
