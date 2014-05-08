package com.github.bingoohuang.designpatterns.recorder;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.UserRegistry;

public class MemoryCommandRecorder extends CommandRecorder {
    private final String commandLine;

    public MemoryCommandRecorder(Command command, String commandLine) {
        super(command);
        this.commandLine = commandLine;
    }

    @Override
    public String exec() {
        String result = command.execute();
        UserRegistry.getInstance().saveHistory(commandLine, result);
        return result;
    }
}
