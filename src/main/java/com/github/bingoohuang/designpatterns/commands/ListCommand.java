package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.User;
import com.github.bingoohuang.designpatterns.UserRegistry;
import com.github.bingoohuang.designpatterns.utils.Function;
import com.github.bingoohuang.designpatterns.utils.Utils;

import java.util.Collection;

public class ListCommand implements Command {
    @Override
    public String execute() {
        Collection<User> users = UserRegistry.getInstance().getUsers();

        int size = users.size();
        if (size == 0) {
            return "zero users found";
        }

        return size + " users found:" + Utils.foldLeft(users, "", new Function<String, User>() {
            @Override
            public String apply(String fold, User user) {
                return fold + "\r\n" + user;
            }
        });
    }

    @Override
    public boolean requireLogin() {
        return false;
    }
}
