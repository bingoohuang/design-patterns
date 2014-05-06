package com.github.bingoohuang.designpatterns.storage;

import com.github.bingoohuang.designpatterns.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

public abstract class BaseStorage implements UserStorage {
    private FileOutputStream fis;
    private PrintStream ps;

    @Override
    public void save(Map<String, User> registry) {
        openFile();
        start(ps);
        for (Map.Entry<String, User> entry : registry.entrySet()) {
            each(ps, entry.getValue());
        }
        end(ps);
        closeFile();
    }


    protected abstract String getExtension();
    protected void start(PrintStream ps) {
    }

    protected abstract void each(PrintStream ps, User user);

    protected void end(PrintStream ps) {
    }

    private void openFile() {
        try {
            fis = new FileOutputStream("users." + getExtension());
            ps = new PrintStream(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private void closeFile() {
        try {
            fis.close();
            ps.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
