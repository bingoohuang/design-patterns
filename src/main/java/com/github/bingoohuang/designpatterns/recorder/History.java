package com.github.bingoohuang.designpatterns.recorder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class History {
    private final String commandLine;
    private final String result;
    private Date time = new Date();
    public History(String commandLine, String result) {
        this.commandLine = commandLine;
        this.result = result;
    }

    @Override
    public String toString() {
        String timeStr = new SimpleDateFormat("HH:mm:ss").format(time);
        return timeStr + "$ " + commandLine + "\r\n" + result + ".\r\n";
    }
}
