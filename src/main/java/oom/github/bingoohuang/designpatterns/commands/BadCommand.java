package oom.github.bingoohuang.designpatterns.commands;

import oom.github.bingoohuang.designpatterns.Command;

public class BadCommand implements Command {
    @Override
    public String execute() {
        return "command unknown";
    }
}
