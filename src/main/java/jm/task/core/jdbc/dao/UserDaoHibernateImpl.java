package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        String s = "CREATE TABLE IF NOT EXISTS users (id INT UNSIGNED NOT NULL AUTO_INCREMENT,name VARCHAR(45) NOT NULL," +
                "lastname VARCHAR(45) NOT NULL,age TINYINT NOT NULL,PRIMARY KEY (id))";
        Transaction transaction =null;
        try(Session session = Util.getSessionFactoryHibernate().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(s);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
        }
    }

    @Override
    public void dropUsersTable() {
        String s = "DROP TABLE IF EXISTS users";
        Transaction transaction =null;
        try(Session session = Util.getSessionFactoryHibernate().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(s);
            query.executeUpdate();
            transaction.commit();
            System.out.println("Drop Table users");
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = null;
        try{
            session = Util.getSessionFactoryHibernate().openSession();
            session.beginTransaction();
            User user = new User(name,lastName,age);
            session.save(user);
            session.getTransaction().commit();
            System.out.println("User с именем – "+name+" добавлен в базу данных");;
        } catch (HibernateException e) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        Session session = null;
        try{
            session = Util.getSessionFactoryHibernate().openSession();
            session.beginTransaction();
            User user = session.get(User.class,id);
            session.delete(user);
            session.getTransaction().commit();
            System.out.println("1 rows remove");
        } catch (HibernateException e) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        Session session = null;
        try{
            session = Util.getSessionFactoryHibernate().openSession();
            list = session.createQuery("FROM User").list();
            System.out.println(list);
        } catch (HibernateException e) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        Session session = null;
        try{
            session = Util.getSessionFactoryHibernate().openSession();
            session.beginTransaction();
            String s = "DELETE FROM User";
            Query query = session.createQuery(s);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
