package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Util util = new Util();
        util.getConnection();
        UserServiceImpl t = new UserServiceImpl();

        t.createUsersTable();
        t.saveUser("kolya", "umnov", (byte) 22);
        t.saveUser("lesha", "smirnov", (byte) 24);
        t.saveUser("petya", "ivanov", (byte) 32);
        t.saveUser("alla", "bekova", (byte) 74);
        System.out.println(t.getAllUsers());
        t.cleanUsersTable();
        t.dropUsersTable();

    }
}
