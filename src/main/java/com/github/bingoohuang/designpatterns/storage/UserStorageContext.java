package com.github.bingoohuang.designpatterns.storage;

import com.github.bingoohuang.designpatterns.User;

import java.util.Map;

public class UserStorageContext {
    private UserStorage storage;

    public void setStorage(UserStorage storage) {
        this.storage = storage;
    }

    public String save(Map<String, User> registry) {
        storage.save(registry);
        return "saved";
    }
}
