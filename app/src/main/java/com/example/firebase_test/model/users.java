package com.example.firebase_test.model;

public class users {
    String name;
    String number;
    String gmail;
    String age;
    String gerder;

    public users() {
    }

    public users(String name, String number, String gmail, String age, String gerder) {
        this.name = name;
        this.number = number;
        this.gmail = gmail;
        this.age = age;
        this.gerder = gerder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGerder() {
        return gerder;
    }

    public void setGerder(String gerder) {
        this.gerder = gerder;
    }
}
