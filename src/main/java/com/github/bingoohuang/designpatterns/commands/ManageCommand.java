package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.Manager;
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
        Manager manager = (Manager) UserRegistry.getInstance().get(validator.getManageId());
        User staff = UserRegistry.getInstance().get(validator.getStaffId());
        manager.addStaff(staff);
        return manager.getId() + " began to manage " + staff.getId();
    }

    @Override
    public boolean requireLogin() {
        return false;
    }
}
