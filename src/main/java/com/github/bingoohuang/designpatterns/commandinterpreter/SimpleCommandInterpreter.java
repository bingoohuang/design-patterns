package com.github.bingoohuang.designpatterns.commandinterpreter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleCommandInterpreter {
    static Pattern blankPattern = Pattern.compile("\\s");
    private final String commandType;
    private final String[] args;

    public SimpleCommandInterpreter(String commandLine) {
        Matcher matcher = blankPattern.matcher(commandLine);
        boolean foundBlank = matcher.find();
        this.commandType = foundBlank ? commandLine.substring(0, matcher.start()) : commandLine;
        String commandBody = foundBlank ? commandLine.substring(matcher.start()).trim() : "";
        this.args = commandBody.split("\\s+");
    }


    public String getCommandType() {
        return commandType;
    }

    public String[] getArgs() {
        return args;
    }
}
