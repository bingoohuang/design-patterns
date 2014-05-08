package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.User;
import com.github.bingoohuang.designpatterns.UserRegistry;
import com.github.bingoohuang.designpatterns.state.LoveState;
import com.github.bingoohuang.designpatterns.state.NormalState;
import com.github.bingoohuang.designpatterns.state.UnhealthyWorkState;

public class StateCommand implements Command {
    private final String id;
    private final String state;

    public StateCommand(String id, String state) {
        this.id = id;
        this.state = state;
    }

    @Override
    public String execute() {
        User user = UserRegistry.getInstance().get(id);
        if (user == null)
            return "user does not exist";

        if ("ill".equals(state)) {
            user.setWorkState(new UnhealthyWorkState());
        } else if ("love".equals(state)) {
            user.setWorkState(new LoveState());
        } else if ("normal".equals(state)) {
            user.setWorkState(new NormalState());
        } else {
            return "state is unknown!";
        }

        return "state changed";
    }

    @Override
    public boolean requireLogin() {
        return false;
    }
}
