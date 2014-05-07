package com.github.bingoohuang.designpatterns.storage;

public class UserStorageContext {
    private UserStorage storage;

    public void setStorage(UserStorage storage) {
        this.storage = storage;
    }

    public String save() {
        storage.save();
        return "saved";
    }
}
