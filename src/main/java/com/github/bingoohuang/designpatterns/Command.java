package com.github.bingoohuang.designpatterns;

public interface Command {
    String execute();
    String getCommandType();
    boolean requireLogin();
}
