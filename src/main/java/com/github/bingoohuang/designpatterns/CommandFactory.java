package com.github.bingoohuang.designpatterns;

import com.github.bingoohuang.designpatterns.commandinterpreter.SimpleCommandInterpreter;
import com.github.bingoohuang.designpatterns.commandparsers.*;
import com.github.bingoohuang.designpatterns.commands.ProxyCommand;

class CommandFactory {
    static CommandParser commandParser;

    static {
        // construct the responsibility chain
        AddCommandParser addCommandParser = new AddCommandParser();
        GetCommandParser getCommandParser = new GetCommandParser();
        DelCommandParser delCommandParser = new DelCommandParser();
        SaveCommandParser saveCommandParser = new SaveCommandParser();
        LoginCommandParser loginCommandParser = new LoginCommandParser();
        LogoutCommandParser logoutCommandParser = new LogoutCommandParser();
        CloneCommandParser cloneCommandParser = new CloneCommandParser();
        ListCommandParser listCommandParser = new ListCommandParser();
        RecordCommandParser recordCommandParser = new RecordCommandParser();
        HistoryCommandParser historyCommandParser = new HistoryCommandParser();
        ManageCommandParser manageCommandParser = new ManageCommandParser();
        AddSalaryCommandParser addSalaryCommandParser = new AddSalaryCommandParser();
        manageCommandParser.setNext(addSalaryCommandParser);
        historyCommandParser.setNext(manageCommandParser);
        recordCommandParser.setNext(historyCommandParser);
        listCommandParser.setNext(recordCommandParser);
        cloneCommandParser.setNext(listCommandParser);
        logoutCommandParser.setNext(cloneCommandParser);
        loginCommandParser.setNext(logoutCommandParser);
        saveCommandParser.setNext(loginCommandParser);
        delCommandParser.setNext(saveCommandParser);
        getCommandParser.setNext(delCommandParser);
        addCommandParser.setNext(getCommandParser);

        commandParser = addCommandParser;
    }

    public static Command createCommand(SimpleCommandInterpreter simpleCommandInterpreter) {
        Command command = commandParser.parseCommand(simpleCommandInterpreter);
        return new ProxyCommand(command);
    }
}
