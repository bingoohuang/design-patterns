package com.github.bingoohuang.designpatterns.visitor;

import com.github.bingoohuang.designpatterns.Staff;

public class BossVisitor extends HumanResourceVisitor {
    public BossVisitor(StringBuilder info) {
        super(info);
    }

    @Override
    public void visit(Staff user) {
        // don't care normal user
    }
}
