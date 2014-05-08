package com.github.bingoohuang.designpatterns.mediator;

import com.github.bingoohuang.designpatterns.User;
import com.github.bingoohuang.designpatterns.observers.UserChangedObserver;
import com.github.bingoohuang.designpatterns.recorder.CommandHistory;

import java.util.Collection;

public interface UserRegistryMediator {
    void addUserChangedObserver(UserChangedObserver userChangedObserver);

    void put(User user);

    void undo();

    User get(String id);

    void remove(String id);

    Collection<User> getUsers();

    boolean isLogined();

    void login();

    void logout();

    boolean exists(String id);

    void saveHistory(String commandLine, String result);

    void setCommandHistory(CommandHistory commandHistory);

    CommandHistory getCommandHistory();

    String showHistory();
}
