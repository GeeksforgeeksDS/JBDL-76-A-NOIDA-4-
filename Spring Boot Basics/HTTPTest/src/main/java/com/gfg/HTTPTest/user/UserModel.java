package com.gfg.HTTPTest.user;

public class UserModel {

    private int id;

    private String userName;

    private String email;

    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserModel(int id, String userName, String email, int age) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.age = age;
    }
}
