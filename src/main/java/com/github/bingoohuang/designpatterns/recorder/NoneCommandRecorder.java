package com.github.bingoohuang.designpatterns.recorder;

import com.github.bingoohuang.designpatterns.Command;

public class NoneCommandRecorder extends CommandRecorder {
    private final String commandLine;

    public NoneCommandRecorder(Command command, String commandLine) {
        super(command);
        this.commandLine = commandLine;
    }

    @Override
    public String exec() {
        return command.execute();
    }
}
