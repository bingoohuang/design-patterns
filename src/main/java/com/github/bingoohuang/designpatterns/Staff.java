package com.github.bingoohuang.designpatterns;

import com.github.bingoohuang.designpatterns.visitor.Visitor;

public class Staff extends User {
    Staff(UserBuilder builder) {
        super(builder);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
