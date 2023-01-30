package org.example.springMvcApp.models;

public class User {

    private int id;
    private String name;

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User() {
        System.out.println("ussssver");
        role = "user";
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        role = "user";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
