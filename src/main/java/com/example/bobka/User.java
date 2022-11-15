package com.example.bobka;

public class User {
    private int age;
    private String name;

    public User(int age) {
        this.age = age;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {
        age = 0; name = null;
    }
    public User(int age, String name){
        this.age = age;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
