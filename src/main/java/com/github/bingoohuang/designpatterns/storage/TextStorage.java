package com.github.bingoohuang.designpatterns.storage;

import com.github.bingoohuang.designpatterns.Manager;
import com.github.bingoohuang.designpatterns.Staff;
import com.github.bingoohuang.designpatterns.User;
import com.github.bingoohuang.designpatterns.visitor.Visitor;

import java.io.PrintStream;

public class TextStorage extends BaseStorage {
    TextSaveVisitor visitor;

    public TextStorage() {
        visitor = new TextSaveVisitor();
    }

    @Override
    protected String getExtension() {
        return "txt";
    }

    @Override
    protected void each(PrintStream ps, User user) {
        visitor.setPs(ps);
        user.accept(visitor);
    }

    static class TextSaveVisitor implements Visitor {
        PrintStream ps;

        public void setPs(PrintStream ps) {
            this.ps = ps;
        }

        @Override
        public void visit(Staff user) {
            ps.print(user.getId());
            ps.print(' ');
            ps.print(user.getName());
            ps.print(' ');
            ps.print(user.getAge());
            ps.print(' ');
            ps.print(user.getPhone());
            ps.print(' ');
            ps.print(user.getCity());
            ps.println();
        }

        @Override
        public void visit(Manager manager) {
            // ignore
        }
    }

}
