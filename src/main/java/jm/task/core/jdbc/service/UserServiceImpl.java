package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao k = new UserDaoJDBCImpl();

    public void createUsersTable() throws SQLException {
        k.createUsersTable();

    }

    public void dropUsersTable() throws SQLException {
        k.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        k.saveUser(name,lastName,age);
        System.out.println("User с именем " +name+ " добавлен в базу данных");

    }

    public void removeUserById(long id) throws SQLException {
        k.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return k.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
        k.cleanUsersTable();

    }
}
