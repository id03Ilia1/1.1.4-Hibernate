package jm.task.core.jdbc;

import com.mysql.cj.log.Log;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    static Logger LOGGER;
    public static void main(String[] args) {
        Logger logger = LogManager.getLogManager().getLogger("");
        logger.setLevel(Level.SEVERE);
        UserServiceImpl userServiceimpl = new UserServiceImpl();
        Session session = Util.getSessionFactoryHibernate().openSession();
        userServiceimpl.createUsersTable();
        userServiceimpl.createUsersTable();
        userServiceimpl.saveUser("Name1", "Lastname1", (byte) 21);
        userServiceimpl.saveUser("Name2", "Lastname2", (byte) 22);
        userServiceimpl.saveUser("Name3", "Lastname3", (byte) 23);
        userServiceimpl.saveUser("Name4", "Lastname4", (byte) 24);
        userServiceimpl.getAllUsers();
        userServiceimpl.removeUserById(2);
        userServiceimpl.getAllUsers();

        userServiceimpl.cleanUsersTable();
        userServiceimpl.getAllUsers();
        userServiceimpl.dropUsersTable();
        userServiceimpl.dropUsersTable();
        session.close();
    }
}
