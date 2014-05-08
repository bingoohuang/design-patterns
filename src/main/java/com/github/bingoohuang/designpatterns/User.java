package com.github.bingoohuang.designpatterns;


import com.github.bingoohuang.designpatterns.flyweight.City;

import java.util.ArrayList;
import java.util.List;

public class User implements Cloneable{
    // composite pattern
    private User manager;
    private List<User> staffs = new ArrayList<User>();

    private String id; // required
    private String name; // required
    private int age; // optional
    private String phone; // optional
    private City city; // optional
    private int salary; // optional

    User(UserBuilder builder) {
        this.manager = builder.manager;
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.phone = builder.phone;
        this.city = builder.city;
        this.salary = builder.salary;
    }

    // add salary for all staffs under current manager recursively.
    public void addSalary(int incrementSalary) {
        salary += incrementSalary;
        for (User user : staffs) {
            user.addSalary(incrementSalary);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public User getManager() {
        return manager;
    }

    public void addStaff(User staff) {
        staffs.add(staff);
    }
}
