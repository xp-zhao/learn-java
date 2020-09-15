package com.xp.pojo;

/**
 * @author
 */
public class User {
    private String name;

    public User(String name){
        this.name = name;
    }

//    public User() {
//        System.out.println("User 无参构造函数");
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("name=" + name);
    }
}
