package com.github.bingoohuang.designpatterns;

import com.github.bingoohuang.designpatterns.commandinterpreter.SimpleCommandInterpreter;
import com.github.bingoohuang.designpatterns.observers.UserChangedObserver;
import com.github.bingoohuang.designpatterns.recorder.CommandRecorder;
import com.github.bingoohuang.designpatterns.recorder.MemoryCommandRecorder;
import com.github.bingoohuang.designpatterns.recorder.NoneCommandRecorder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserManagerFacade {
    public String doCommand(String commandLine) {
        SimpleCommandInterpreter commandInterpreter = new SimpleCommandInterpreter(commandLine);

        String result;
        try {
            Command command = CommandFactory.createCommand(commandInterpreter);
            // bridge command and recorder
            CommandRecorder commandRecorder =
                    UserRegistry.getInstance().getCommandHistory() == null
                            ? new NoneCommandRecorder(command, commandLine)
                            : new MemoryCommandRecorder(command, commandLine);
            result = commandRecorder.exec();
        } catch (Exception e) {
            result = "error:" + e.getMessage();
        }

        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String displayedResult = time + "$ " + commandLine + "\r\n" + result + ".\r\n";

        return displayedResult;
    }

    public void registerUserChangedObserver(UserChangedObserver userChangedObserver) {
        UserRegistry.getInstance().addUserChangedObserver(userChangedObserver);
    }
}
