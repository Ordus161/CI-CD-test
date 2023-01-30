package org.example.springMvcApp.dao;

import org.example.springMvcApp.models.User;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {

    private static int USERS_COUNT = 1;
    private static Connection connection;

    private static final String URL = "jdbc:postgresql://localhost:5432/pg-homework";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    static {
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> index(){
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM public.user";
            ResultSet resultSet = statement.executeQuery(SQL);

            User user = null;
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setRole(resultSet.getString("role"));

                users.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public User show(int id) {
        User user = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM public.user WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setRole(resultSet.getString("role"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void save(User user) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO public.user VALUES(?, ?, ?)");
            preparedStatement.setInt(1, USERS_COUNT++);
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getRole());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
