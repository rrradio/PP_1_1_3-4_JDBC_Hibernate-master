package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl  implements UserDao {

    private String CREATE = "CREATE TABLE IF NOT EXISTS users( id int NOT NULL AUTO_INCREMENT, name varchar(25), lastname varchar(25), age tinyint, PRIMARY KEY (id))";
    private String DROP = "DROP TABLE IF EXISTS users";
    private String SAVE = "insert into users (name, lastname, age) values (?, ?, ?)";
    private String DELETE = "delete from users where id = ?";
    private String GETALLUSERS = "select * from users";
    private String CLEAN = "TRUNCATE TABLE users";

    private Connection connection = Util.getConnection();


    public void createUsersTable() {
        try(PreparedStatement preparedStatement = connection.prepareStatement(CREATE))  {
            preparedStatement.executeUpdate();
        } catch (SQLException | RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DROP)) {
            preparedStatement.executeUpdate();
        } catch (SQLException | RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(SAVE)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            preparedStatement.executeUpdate();
        } catch (SQLException | RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE))  {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | RuntimeException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GETALLUSERS);
             ResultSet resultSet = preparedStatement.executeQuery(GETALLUSERS)) {

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
                userList.add(user);
            }

        } catch (SQLException | RuntimeException e) {
            e.printStackTrace();
        }

        return userList;

    }

    public void cleanUsersTable() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(CLEAN)) {
            preparedStatement.executeUpdate();
        } catch (SQLException | RuntimeException e) {
            e.printStackTrace();
        }

    }

}
