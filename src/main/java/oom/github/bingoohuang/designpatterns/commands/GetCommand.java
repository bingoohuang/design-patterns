package oom.github.bingoohuang.designpatterns.commands;

import oom.github.bingoohuang.designpatterns.Command;
import oom.github.bingoohuang.designpatterns.User;

import java.util.Map;

public class GetCommand implements Command {
    private final Map<String, User> registry;
    private final String id;

    public GetCommand(Map<String, User> registry, String id) {
        this.registry = registry;
        this.id = id;
    }

    @Override
    public String execute() {
        User user = registry.get(id);
        if (user != null) {
            return "got " + user;
        } else {
            return "user not found";
        }
    }
}
