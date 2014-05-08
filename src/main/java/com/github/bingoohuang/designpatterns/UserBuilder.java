package com.github.bingoohuang.designpatterns;

import com.github.bingoohuang.designpatterns.flyweight.City;
import com.github.bingoohuang.designpatterns.flyweight.CityFactory;

public class UserBuilder {
    final String id;
    final String name;
    int age;
    String phone;
    City city;
    User manager;
    int salary;

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

    public UserBuilder manager(User manager) {
        this.manager = manager;
        return this;
    }

    public UserBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserBuilder salary(int salary) {
        this.salary = salary;
        return this;
    }

    public UserBuilder city(String cityName) {
        this.city = CityFactory.getCity(cityName);
        return this;
    }

    public User build() {
        return new User(this);
    }

}
