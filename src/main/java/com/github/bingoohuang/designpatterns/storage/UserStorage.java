package com.github.bingoohuang.designpatterns.storage;

import com.github.bingoohuang.designpatterns.User;

import java.util.Map;

public interface UserStorage {
    void save(Map<String, User> registry);
}
