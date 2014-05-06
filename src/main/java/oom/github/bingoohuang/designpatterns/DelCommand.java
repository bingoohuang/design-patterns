package oom.github.bingoohuang.designpatterns;

import java.util.Map;

public class DelCommand implements Command {
    private final Map<String, User> registry;
    private final String id;

    public DelCommand(Map<String, User> registry, String id) {
        this.registry = registry;
        this.id = id;
    }

    @Override
    public String execute() {
        User user = registry.get(id);
        if (user != null) {
            registry.remove(id);
            return "deleted " + user;
        } else {
            return "user not found";
        }

    }
}
