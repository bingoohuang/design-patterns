package com.github.bingoohuang.designpatterns.observers;

import com.github.bingoohuang.designpatterns.User;

public interface UserChangedObserver {
    void onAdd(User user);
    void onDel(User user);
}
