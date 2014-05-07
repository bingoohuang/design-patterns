package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.User;
import com.github.bingoohuang.designpatterns.UserRegistry;

public class AddCommand implements Command {
    private String id;
    private String name;

    public AddCommand(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String execute() {
        User user = new User();
        user.setId(id);
        user.setName(name);
        UserRegistry.getInstance().put(id, user);

        return "added " + user;
    }

    @Override
    public String getCommandType() {
        return "add";
    }

    @Override
    public boolean requireLogin() {
        return false;
    }
}
