package oom.github.bingoohuang.designpatterns;

import java.util.Map;

public class AddCommand implements Command {
    private final Map<String, User> registry;
    private String id;
    private String name;

    public AddCommand(Map<String, User> registry, String id, String name) {
        this.registry =  registry;
        this.id = id;
        this.name = name;
    }

    @Override
    public String execute() {
        User user = new User();
        user.setId(id);
        user.setName(name);
        registry.put(id, user);

        return "added " + user;
    }
}
