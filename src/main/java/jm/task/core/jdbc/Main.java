package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserServiceImpl;



public class Main {
    public static void main(String[] args) {

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
