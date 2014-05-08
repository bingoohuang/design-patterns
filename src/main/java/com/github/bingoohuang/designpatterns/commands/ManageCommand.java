package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.User;
import com.github.bingoohuang.designpatterns.UserRegistry;
import com.github.bingoohuang.designpatterns.argumentsvalidators.ManageCommandArgumentsValidator;

public class ManageCommand implements Command {
    private final ManageCommandArgumentsValidator validator;

    public ManageCommand(ManageCommandArgumentsValidator validator) {
        this.validator = validator;
    }

    @Override
    public String execute() {
        User manager = UserRegistry.getInstance().get(validator.getManageId());
        User staff = UserRegistry.getInstance().get(validator.getStaffId());
        staff.setManager(manager);
        manager.addStaff(staff);
        return manager.getId()  + " began to manage " + staff.getId();
    }

    @Override
    public boolean requireLogin() {
        return false;
    }
}
