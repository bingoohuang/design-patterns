package com.github.bingoohuang.designpatterns;

import com.github.bingoohuang.designpatterns.flyweight.City;
import com.github.bingoohuang.designpatterns.flyweight.CityFactory;

public class UserBuilder {
    final String id;
    final String name;
    int age;
    String phone;
    City city;
    int salary;

    public static UserBuilder newBuilder(String id, String name) {
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

    public UserBuilder salary(int salary) {
        this.salary = salary;
        return this;
    }

    public UserBuilder city(String cityName) {
        this.city = CityFactory.getCity(cityName);
        return this;
    }

    public Staff buildStaff() {
        return new Staff(this);
    }

    public Manager buildManager() {
        return new Manager(this);
    }
}
