package com.github.bingoohuang.designpatterns.state;

public class LoveState implements WorkState {
    @Override
    public int workLoadPerday() {
        return 5;
    }
}
