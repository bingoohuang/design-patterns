package com.github.bingoohuang.designpatterns;

public abstract class CommandParser {
    protected String[] args;

    public void setArgs(String[] args) {
        this.args = args;
    }

    public abstract Command parseCommand();
}
