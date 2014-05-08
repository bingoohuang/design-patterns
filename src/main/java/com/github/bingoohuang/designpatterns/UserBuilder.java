package com.github.bingoohuang.designpatterns;

public class UserBuilder {
    final String id;
    final String name;
    int age;
    String phone;
    String address;

    public static UserBuilder newUser(String id, String name) {
        return new UserBuilder(id, name);
    }

    public UserBuilder(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserBuilder age(int age) {
        this.age = age;
        return this;
    }

    public UserBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserBuilder address(String address) {
        this.address = address;
        return this;
    }

    public User build() {
        return new User(this);
    }

}
