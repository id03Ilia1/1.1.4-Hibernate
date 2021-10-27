package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static SessionFactory sessionFactory;
    private static Connection connection;

    public Util() {
    }

    public static SessionFactory getSessionFactoryHibernate() {
        try {
            Configuration configuration = new Configuration().configure();
            Properties properties = new Properties();
            properties.put(Environment.DRIVER, DRIVER);
            properties.put(Environment.URL, URL);
            properties.put(Environment.USER, USERNAME);
            properties.put(Environment.PASS, PASSWORD);
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
//            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//            properties.put(Environment.HBM2DDL_AUTO, "create-drop");
            configuration.setProperties(properties);
            configuration.addAnnotatedClass(User.class);
            StandardServiceRegistry builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(builder);
            return sessionFactory;
        }catch (Exception e){
            System.out.println("Исключение при соединении! " + e);
        }
        return sessionFactory;
    }

//    public Connection getConnect() {
////        connection = null;
////        Statement statement = null;
//        try {
//            Driver driver = new com.mysql.cj.jdbc.Driver();
//            DriverManager.registerDriver(driver);
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
////          statement = connection.createStatement();;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
////            try {
////                if (statement != null) {
////                    statement.close();
////                }
////                if (connection != null) {
////                    connection.close();
////                }
////            } catch (SQLException e) {
////                e.printStackTrace();
////            }
//        }
//        return connection;
// реализуйте настройку соединения с БД
}

