package com.github.bingoohuang.designpatterns;

import com.github.bingoohuang.designpatterns.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Manager extends User {
    private List<User> staffs = new ArrayList<User>();

    public Manager(UserBuilder builder) {
        super(builder);
    }

    // add salary for all staffs under current manager recursively.
    public void addSalary(int incrementSalary) {
        super.addSalary(incrementSalary);
        for (User user : staffs) {
            user.addSalary(incrementSalary);
        }
    }

    public void addStaff(User staff) {
        staffs.add(staff);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Manager" + super.toString();
    }
}
