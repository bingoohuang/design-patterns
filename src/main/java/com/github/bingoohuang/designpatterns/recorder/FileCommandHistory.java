package com.github.bingoohuang.designpatterns.recorder;

import java.io.File;

public class FileCommandHistory implements CommandHistory {
    private final FileOperator fileOperator;

    public FileCommandHistory() {
        fileOperator = new PlainFileOperator(new File("history.txt"));
    }

    @Override
    public void saveHistory(String commandLine, String result) {
        History history = new History(commandLine, result);
        fileOperator.appendFile(history.toString());
    }


    @Override
    public String showHistory() {
        return fileOperator.readFile();
    }
}
