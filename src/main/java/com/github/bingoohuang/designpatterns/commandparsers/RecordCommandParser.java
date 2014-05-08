package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.argumentsvalidators.BadArgumentException;
import com.github.bingoohuang.designpatterns.commands.RecordCommand;
import com.github.bingoohuang.designpatterns.recorder.CommandHistory;
import com.github.bingoohuang.designpatterns.recorder.FileCommandHistory;
import com.github.bingoohuang.designpatterns.recorder.MemoryCommandHistory;

public class RecordCommandParser extends CommandParser {
    @Override
    protected Command createCommand(String[] args) {
        CommandHistory commandHistory;
        if (args.length == 0) {
            commandHistory = new MemoryCommandHistory();
        } else if (args.length == 1 && "file".equals(args[0])) {
            commandHistory = new FileCommandHistory();
        } else if (args.length == 1 && "mem".equals(args[0]) || "on".equals(args[0])) {
            commandHistory = new MemoryCommandHistory();
        } else if (args.length == 1 && "off".equals(args[0])) {
            commandHistory = null;
        } else {
            throw new BadArgumentException("record [on/off]");
        }
        return new RecordCommand(commandHistory);
    }

    @Override
    public String supportCommandType() {
        return "record";
    }
}
