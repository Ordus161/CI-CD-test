package org.example.springMvcApp.models;

public class Admin extends User{
    public Admin() {
        System.out.println("SSsasdasdasda");
        setRole("admin");
    }

    public Admin(int id, String name) {
        super(id, name);
        setRole("admin");
    }
}
