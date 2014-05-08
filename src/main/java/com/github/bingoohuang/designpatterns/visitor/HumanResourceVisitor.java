package com.github.bingoohuang.designpatterns.visitor;

import com.github.bingoohuang.designpatterns.Manager;
import com.github.bingoohuang.designpatterns.Staff;

public class HumanResourceVisitor implements Visitor {
    private final StringBuilder info;

    public HumanResourceVisitor(StringBuilder info) {
        this.info = info;
    }

    @Override
    public void visit(Staff user) {
        if (info.length() > 0) info.append(',');
        info.append("staff:" + user.getName());
    }

    @Override
    public void visit(Manager manager) {
        if (info.length() > 0) info.append(',');
        info.append("manager:" + manager.getName());
    }
}
