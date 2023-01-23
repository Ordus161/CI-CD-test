package org.example.springMvcApp.dao;

import org.example.springMvcApp.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {

    private static int USERS_COUNT;
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++USERS_COUNT,"Ivan"));
        users.add(new User(++USERS_COUNT,"Vasya"));
        users.add(new User(++USERS_COUNT,"Petya"));
        users.add(new User(++USERS_COUNT,"Annya"));
    }

    public List<User> index(){
        return users;
    }

    public User show (int id){
        return users.stream().filter(users->users.getId() == id).findAny().orElse(null);
    }
}
