package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao k = new UserDaoHibernateImpl();

    public void createUsersTable()  {
        k.createUsersTable();

    }

    public void dropUsersTable()  {
        k.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        k.saveUser(name,lastName,age);
        System.out.println("User с именем " +name+ " добавлен в базу данных");

    }

    public void removeUserById(long id)  {
        k.removeUserById(id);
    }

    public List<User> getAllUsers()  {
        return k.getAllUsers();
    }

    public void cleanUsersTable() {
        k.cleanUsersTable();

    }
}
