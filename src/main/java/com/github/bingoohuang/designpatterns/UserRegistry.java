package com.github.bingoohuang.designpatterns;

import com.github.bingoohuang.designpatterns.argumentsvalidators.AddCommandArgumentsValidator;
import com.github.bingoohuang.designpatterns.commands.AddCommand;
import com.github.bingoohuang.designpatterns.commands.DelCommand;
import com.github.bingoohuang.designpatterns.mediator.UserRegistryMediator;
import com.github.bingoohuang.designpatterns.observers.UserChangedObserver;
import com.github.bingoohuang.designpatterns.recorder.CommandHistory;

import java.util.*;

public class UserRegistry implements UserRegistryMediator {
    private Map<String, User> registry = new LinkedHashMap<>();
    private boolean logined;
    private CommandMemento commandMemento = new CommandMemento();

    private List<UserChangedObserver> userChangedObservers = new ArrayList<>();
    private CommandHistory commandHistory;

    @Override
    public void addUserChangedObserver(UserChangedObserver userChangedObserver) {
        userChangedObservers.add(userChangedObserver);
    }

    private static UserRegistry userRegistry = new UserRegistry();

    public static UserRegistryMediator getInstance() {
        return userRegistry;
    }

    @Override
    public void put(User user) {
        registry.put(user.getId(), user);
        notifyAdd(user);
        commandMemento.setUndoCommand(new DelCommand(user.getId()));
    }

    @Override
    public void undo() {
        commandMemento.undo();
    }

    @Override
    public User get(String id) {
        return registry.get(id);
    }

    @Override
    public void remove(String id) {
        User remove = registry.remove(id);
        notifyDel(remove);
        commandMemento.setUndoCommand(new AddCommand(new AddCommandArgumentsValidator(remove)));
    }

    @Override
    public Collection<User> getUsers() {
        return registry.values();
    }

    @Override
    public boolean isLogined() {
        return logined;
    }

    @Override
    public void login() {
        logined = true;
    }

    @Override
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

    @Override
    public boolean exists(String id) {
        return registry.containsKey(id);
    }

    @Override
    public void saveHistory(String commandLine, String result) {
        if (commandHistory != null)
            commandHistory.saveHistory(commandLine, result);
    }

    @Override
    public void setCommandHistory(CommandHistory commandHistory) {
        this.commandHistory = commandHistory;
    }

    @Override
    public CommandHistory getCommandHistory() {
        return commandHistory;
    }

    @Override
    public String showHistory() {
        return commandHistory == null ? "history disabled" : commandHistory.showHistory();
    }
}
