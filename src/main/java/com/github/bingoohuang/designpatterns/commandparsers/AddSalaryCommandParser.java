package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.commands.AddSalaryCommand;

public class AddSalaryCommandParser extends CommandParser {
    @Override
    protected Command createCommand(String[] args) {
        String id = args[0];
        int incrementSalary = Integer.parseInt(args[1]);
        return new AddSalaryCommand(id, incrementSalary);
    }

    @Override
    public String supportCommandType() {
        return "addsalary";
    }
}
