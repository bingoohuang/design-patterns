package com.github.bingoohuang.designpatterns.state;

public class UnhealthyWorkState implements WorkState {
    @Override
    public int workLoadPerday() {
        return 0;
    }
}
