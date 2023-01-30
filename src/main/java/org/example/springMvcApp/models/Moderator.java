package org.example.springMvcApp.models;

public class Moderator extends User{
    public Moderator() {
        setRole("moderator");
    }

    public Moderator(int id, String name) {
        super(id, name);
        setRole("moderator");
    }
}
