package com.github.bingoohuang.designpatterns.recorder;

import com.github.bingoohuang.designpatterns.Command;

public abstract class CommandRecorder {
    final Command command;

    public CommandRecorder(Command command) {
        this.command = command;
    }

    public abstract String exec();
}
