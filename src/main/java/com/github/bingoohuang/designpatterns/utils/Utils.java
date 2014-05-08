package com.github.bingoohuang.designpatterns.utils;

import java.util.Collection;

public class Utils {
    public static <T, U> T foldLeft(Collection<U> users, T initial, Function<T, U> function) {
        T result = initial;
        for (U u : users) {
            result = function.apply(result, u);
        }

        return result;
    }
}
