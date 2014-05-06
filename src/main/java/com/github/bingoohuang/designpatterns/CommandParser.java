package com.github.bingoohuang.designpatterns;

import java.util.Map;

public interface CommandParser {
    Command parseCommand(Map<String, User> registry, String commandBody);
}
