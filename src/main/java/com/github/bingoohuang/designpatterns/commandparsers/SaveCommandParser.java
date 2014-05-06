package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.User;
import com.github.bingoohuang.designpatterns.commands.BadCommand;
import com.github.bingoohuang.designpatterns.commands.SaveCommand;
import com.github.bingoohuang.designpatterns.storage.TextStorage;
import com.github.bingoohuang.designpatterns.storage.UserStorageContext;
import com.github.bingoohuang.designpatterns.storage.XmlStorage;

import java.util.Map;

public class SaveCommandParser implements CommandParser {
    @Override
    public Command parseCommand(Map<String, User> registry, String commandBody) {
        String saveType = "".equals(commandBody) ? "txt" : commandBody;
        UserStorageContext userStorageContext = new UserStorageContext();
        if ("txt".equals(saveType)) {
            userStorageContext.setStorage(new TextStorage());
        } else if ("xml".equals(saveType)) {
            userStorageContext.setStorage(new XmlStorage());
        } else {
            return new BadCommand();
        }
        return new SaveCommand(registry, userStorageContext);
    }
}
