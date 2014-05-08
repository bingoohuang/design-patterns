package com.github.bingoohuang.designpatterns.argumentsvalidators;

import com.github.bingoohuang.designpatterns.UserRegistry;

public class ManageCommandArgumentsValidator implements CommandArgumentsValidator {
    private String manageId;
    private String staffId;

    @Override
    public void validateArguments(String[] args) {
        if (args.length != 2) throw new BadArgumentException("two arguments are required");

        this.manageId = args[0];
        this.staffId = args[1];

        // decorator
        ArgumentValidator validator = new NumberArgumentValidator(new FixedSizeArgumentValidator(4));
        validator.validate(manageId);
        validator.validate(staffId);

        if (manageId.equals(staffId))
            throw new BadArgumentException("two arguments should not same");

        if (!UserRegistry.getInstance().exists(manageId))
            throw new BadArgumentException(manageId + " does not exist");

        if (!UserRegistry.getInstance().exists(staffId))
            throw new BadArgumentException(staffId + " does not exist");
    }

    public String getManageId() {
        return manageId;
    }

    public String getStaffId() {
        return staffId;
    }
}
