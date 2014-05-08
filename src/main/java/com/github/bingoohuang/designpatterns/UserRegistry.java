package com.github.bingoohuang.designpatterns;

import com.github.bingoohuang.designpatterns.argumentsvalidators.AddCommandArgumentsValidator;
import com.github.bingoohuang.designpatterns.commands.AddCommand;
import com.github.bingoohuang.designpatterns.commands.DelCommand;
import com.github.bingoohuang.designpatterns.observers.UserChangedObserver;
import com.github.bingoohuang.designpatterns.recorder.CommandHistory;

import java.util.*;

public class UserRegistry {
    private Map<String, User> registry = new LinkedHashMap<>();
    private static UserRegistry userRegistry = new UserRegistry();
    private boolean logined;
    private CommandMemento commandMemento = new CommandMemento();

    private List<UserChangedObserver> userChangedObservers = new ArrayList<>();
    private CommandHistory commandHistory;

    public void addUserChangedObserver(UserChangedObserver userChangedObserver) {
        userChangedObservers.add(userChangedObserver);
    }

    public static UserRegistry getInstance() {
        return userRegistry;
    }

    public void put(User user) {
        registry.put(user.getId(), user);
        notifyAdd(user);
        commandMemento.setUndoCommand(new DelCommand(user.getId()));
    }

    public void undo() {
        commandMemento.undo();
    }

    public User get(String id) {
        return registry.get(id);
    }

    public void remove(String id) {
        User remove = registry.remove(id);
        notifyDel(remove);
        commandMemento.setUndoCommand(new AddCommand(new AddCommandArgumentsValidator(remove)));
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

    public void saveHistory(String commandLine, String result) {
        if (commandHistory != null)
            commandHistory.saveHistory(commandLine, result);
    }

    public void setCommandHistory(CommandHistory commandHistory) {
        this.commandHistory = commandHistory;
    }

    public CommandHistory getCommandHistory() {
        return commandHistory;
    }

    public String showHistory() {
        return commandHistory == null ? "history disabled" : commandHistory.showHistory();
    }
}
