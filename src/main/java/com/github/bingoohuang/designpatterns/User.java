package com.github.bingoohuang.designpatterns;


import com.github.bingoohuang.designpatterns.flyweight.City;
import com.github.bingoohuang.designpatterns.state.NormalState;
import com.github.bingoohuang.designpatterns.state.WorkState;
import com.github.bingoohuang.designpatterns.visitor.Visitor;

public abstract class User implements Cloneable {
    private String id; // required
    private String name; // required
    private int age; // optional
    private String phone; // optional
    private City city; // optional
    private int salary; // optional
    private WorkState workState = new NormalState();

    User(UserBuilder builder) {
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

    public void setWorkState(WorkState workState) {
        this.workState = workState;
    }

    public int workLoadPerday() {
        return workState.workLoadPerday();
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void accept(Visitor visitor);

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

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public City getCity() {
        return city;
    }
}
