package com.github.bingoohuang.designpatterns.argumentsvalidators;

public class BadArgumentException extends RuntimeException {
    public BadArgumentException(String message) {
        super(message);
    }
}
