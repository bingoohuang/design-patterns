package com.github.bingoohuang.designpatterns.storage;

import com.github.bingoohuang.designpatterns.User;

import java.io.PrintStream;

public class TextStorage extends BaseStorage {
    @Override
    protected String getExtension() {
        return "txt";
    }

    @Override
    protected void each(PrintStream ps, User user) {
        ps.print(user.getId());
        ps.print(' ');
        ps.print(user.getName());
        ps.println();
    }

}
