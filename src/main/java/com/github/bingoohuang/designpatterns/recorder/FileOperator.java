package com.github.bingoohuang.designpatterns.recorder;

public interface FileOperator {

    void appendFile(String history);

    String readFile();
}
