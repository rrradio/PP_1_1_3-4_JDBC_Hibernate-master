package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoHibernateImpl extends Util implements UserDao {

    private static SessionFactory connect = getSessionFactory();
    private String CREATEHIB = "CREATE TABLE IF NOT EXISTS users( id int NOT NULL AUTO_INCREMENT, name varchar(25), lastname varchar(25), age tinyint, PRIMARY KEY (id))";
    private String REMOVEHIB = "DROP TABLE IF EXISTS users";
    private String CLEANHIB = "TRUNCATE TABLE users";

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Transaction transaction;
        try (Session session = connect.openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(CREATEHIB).addEntity(User.class);
            query.executeUpdate();
         //   System.out.println("таблица создана");
            transaction.commit();
        }
    }

    @Override
    public void dropUsersTable() {
        Transaction transaction;
        try (Session session = connect.openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(REMOVEHIB).addEntity(User.class);
            query.executeUpdate();
         //   System.out.println("таблица удалена");

            transaction.commit();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        Transaction transaction = null;
        try (Session session = connect.openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
          //  System.out.println("пользователь добавлен");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void removeUserById(long id) {
        User user = new User(id);
        Transaction transaction = null;
        try (Session session = connect.openSession()) {
            transaction = session.beginTransaction();
            session.remove(user);
          //  System.out.println("пользователь удален");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        Transaction transaction = null;
        try (Session session = connect.openSession()) {
            return session.createQuery("from User", User.class).list();
        }
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        try (Session session = connect.openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(CLEANHIB).addEntity(User.class);
            query.executeUpdate();
            transaction.commit();
          //  System.out.println("таблица очищена");
        }

    }
}
