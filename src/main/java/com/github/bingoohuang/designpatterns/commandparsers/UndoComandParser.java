package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.commands.UndoCommand;

public class UndoComandParser extends CommandParser {
    @Override
    protected Command createCommand(String[] args) {
        return new UndoCommand();
    }

    @Override
    public String supportCommandType() {
        return "undo";
    }
}
