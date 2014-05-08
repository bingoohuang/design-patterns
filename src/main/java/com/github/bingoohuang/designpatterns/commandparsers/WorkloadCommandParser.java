package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.commands.WorkloadCommand;

public class WorkloadCommandParser extends CommandParser {
    @Override
    protected Command createCommand(String[] args) {
        return new WorkloadCommand(args[0]);
    }

    @Override
    public String supportCommandType() {
        return "workload";
    }
}
