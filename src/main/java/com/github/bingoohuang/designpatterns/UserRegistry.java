package com.github.bingoohuang.designpatterns;

import com.github.bingoohuang.designpatterns.observers.UserChangedObserver;

import java.util.*;

public class UserRegistry {
    private Map<String, User> registry = new LinkedHashMap<>();
    private static UserRegistry userRegistry = new UserRegistry();
    private boolean logined;

    private List<UserChangedObserver> userChangedObservers = new ArrayList<>();

    public void addUserChangedObserver(UserChangedObserver userChangedObserver) {
        userChangedObservers.add(userChangedObserver);
    }

    public static UserRegistry getInstance() {
        return userRegistry;
    }

    public void put(User user) {
        registry.put(user.getId(), user);
        notifyAdd(user);
    }

    public User get(String id) {
        return registry.get(id);
    }

    public void remove(String id) {
        User remove = registry.remove(id);
        notifyDel(remove);
    }

    public Collection<User> getUsers() {
        return registry.values();
    }

    public boolean isLogined() {
        return logined;
    }

    public void login() {
        logined = true;
    }

    public void logout() {
        logined = false;
    }


    private void notifyAdd(User user) {
        for (UserChangedObserver userChangedObserver : userChangedObservers) {
            userChangedObserver.onAdd(user);
        }
    }

    private void notifyDel(User user) {
        for (UserChangedObserver userChangedObserver : userChangedObservers) {
            userChangedObserver.onDel(user);
        }
    }

    public boolean exists(String id) {
        return registry.containsKey(id);
    }
}
