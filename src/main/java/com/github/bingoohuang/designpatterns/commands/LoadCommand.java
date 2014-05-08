package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.Staff;
import com.github.bingoohuang.designpatterns.UserRegistry;
import com.github.bingoohuang.designpatterns.iterator.StaffIterator;

public class LoadCommand implements Command {
    @Override
    public String execute() {
        StaffIterator iterator = new StaffIterator();
        int number = 0;
        while (iterator.hasNext()) {
            Staff staff = iterator.next();
            number++;
            UserRegistry.getInstance().put(staff);
        }
        return "loaded " + number + " staffs";
    }

    @Override
    public boolean requireLogin() {
        return false;
    }
}
