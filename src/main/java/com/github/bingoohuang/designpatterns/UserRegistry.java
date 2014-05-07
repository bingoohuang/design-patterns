package com.github.bingoohuang.designpatterns;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserRegistry {
    private Map<String, User> registry = new LinkedHashMap<>();
    private static UserRegistry userRegistry = new UserRegistry();

    public static UserRegistry getInstance() {
        return userRegistry;
    }

    public void put(String id, User user) {
        registry.put(id, user);
    }

    public User get(String id) {
        return registry.get(id);
    }

    public void remove(String id) {
        registry.remove(id);
    }

    public Collection<User> getUsers() {
        return registry.values();
    }
}
