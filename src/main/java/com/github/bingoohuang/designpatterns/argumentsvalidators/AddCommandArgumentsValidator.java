package com.github.bingoohuang.designpatterns.argumentsvalidators;

import com.github.bingoohuang.designpatterns.User;

public class AddCommandArgumentsValidator implements CommandArgumentsValidator {
    private String id;
    private String name;
    private int age; // optional
    private String phone; // optional
    private String city; // optional

    public AddCommandArgumentsValidator() {
    }

    public AddCommandArgumentsValidator(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
        this.phone = user.getPhone();
        this.city = user.getCity().toString();
    }


    @Override
    public void validateArguments(String[] args) {
        if (args.length < 2) throw new BadArgumentException("two arguments are required");

        this.id = args[0];
        this.name = args[1];
        if (args.length > 2) age = Integer.parseInt(args[2]);
        if (args.length > 3) phone = args[3];
        if (args.length > 4) city = args[4];

        // decorator
        ArgumentValidator validator = new NumberArgumentValidator(new FixedSizeArgumentValidator(4));
        validator.validate(id);
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
