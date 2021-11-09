package com.example.assignment;

public class information {
    private String  name;
    private String email;
    private String pass;
    private String width;
    private String hight;
    private char gender;

    public information(){

    }

    public information(String name, String email, String pass, String width, String hight, char gender) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.width = width;
        this.hight = hight;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHight() {
        return hight;
    }

    public void setHight(String hight) {
        this.hight = hight;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
