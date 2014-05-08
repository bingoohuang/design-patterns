package com.github.bingoohuang.designpatterns.visitor;

import com.github.bingoohuang.designpatterns.Manager;
import com.github.bingoohuang.designpatterns.Staff;

public interface Visitor {
    void visit(Staff user);

    void visit(Manager manager);
}
