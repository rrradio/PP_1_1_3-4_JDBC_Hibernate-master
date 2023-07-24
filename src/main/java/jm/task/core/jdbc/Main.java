package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserServiceImpl t = new UserServiceImpl();

        t.createUsersTable();
        t.saveUser("Anna", "Andreeva", (byte) 22);
        t.saveUser("Annet", "Vasileva", (byte) 25);
        t.saveUser("Lena", "Nekrasova", (byte) 14);
        t.saveUser("Andrei", "Bistrov", (byte) 33);
        System.out.println(t.getAllUsers());
        t.cleanUsersTable();
        t.dropUsersTable();

    }
}
