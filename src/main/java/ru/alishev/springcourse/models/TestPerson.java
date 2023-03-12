package ru.alishev.springcourse.models;

public class TestPerson {
    private String name;
    private int age;

    public TestPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInfo() {
        return name + " " + age;
    }
}
