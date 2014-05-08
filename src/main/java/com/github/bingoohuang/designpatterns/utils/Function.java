package com.github.bingoohuang.designpatterns.utils;

public interface Function<T, U> {
    T apply(T fold, U u);
}
