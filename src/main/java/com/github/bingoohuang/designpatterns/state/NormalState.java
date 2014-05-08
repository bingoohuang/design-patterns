package com.github.bingoohuang.designpatterns.state;

public class NormalState implements WorkState {
    @Override
    public int workLoadPerday() {
        return 10;
    }
}
