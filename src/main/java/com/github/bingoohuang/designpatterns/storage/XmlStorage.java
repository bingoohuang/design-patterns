package com.github.bingoohuang.designpatterns.storage;

import com.github.bingoohuang.designpatterns.User;

import java.io.PrintStream;

public class XmlStorage extends BaseStorage {
    @Override
    protected String getExtension() {
        return "xml";
    }

    @Override
    protected void start(PrintStream ps) {
        ps.println("<users>");
    }

    @Override
    protected void each(PrintStream ps, User user) {
        ps.print("  <user><id>");
        ps.print(user.getId());
        ps.print("</id><name>");
        ps.print(user.getName());
        ps.print("</name>");
        ps.println("</user>");
    }

    @Override
    protected void end(PrintStream ps) {
        ps.println("</users>");
    }
}
