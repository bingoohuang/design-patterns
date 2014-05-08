package com.github.bingoohuang.designpatterns.recorder;

public interface CommandHistory {

    void saveHistory(String commandLine, String result);

    String showHistory();
}
