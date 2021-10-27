package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private int id1;
    private String name1;
    private String lastName1;
    private byte age1;
    Util util = new Util();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
//        String s = "CREATE TABLE `users1` (`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,`name` VARCHAR(45) NOT NULL," +
//                "`lastname` VARCHAR(45) NOT NULL,`age` INT NOT NULL,PRIMARY KEY (`id`))";
//        try(Connection connection = util.getConnect();Statement statement = connection.createStatement()) {
////            Statement statement = connection.createStatement();
//            statement.executeUpdate(s);
//            System.out.println("table users1 create");
//        } catch(SQLException e){
//        }
    }

    public void dropUsersTable() {
//        String s = "DROP TABLE IF EXISTS users1";
//        try (Connection connection = util.getConnect();Statement statement = connection.createStatement()){
////            Statement statement = connection.createStatement();
//            statement.executeUpdate(s);
//            System.out.println("table users1 drop");
//        } catch(SQLException e){
//        }
    }

    public void saveUser(String name, String lastName, byte age) {
//        String s = "INSERT INTO users1(name, lastname, age) Values(?,?,?)";
//        try (Connection connection = util.getConnect();PreparedStatement preparedstatement = connection.prepareStatement(s)){
////            PreparedStatement preparedstatement = connection.prepareStatement(s);
//            preparedstatement.setString(1, name);
//            preparedstatement.setString(2, lastName);
//            preparedstatement.setInt(3, age);
//            preparedstatement.executeUpdate();
//            System.out.println("User с именем – "+name+" добавлен в базу данных");
//        } catch(SQLException e){
//            e.printStackTrace();
//        }
    }

    public void removeUserById(long id) {
//        String s = "delete from users1 where id = ?";
//        try (Connection connection = util.getConnect();PreparedStatement preparedstatement = connection.prepareStatement(s)){
////            PreparedStatement preparedstatement = connection.prepareStatement(s);
//            preparedstatement.setInt(1, (int) id);
//            int rows = preparedstatement.executeUpdate();
//            System.out.println(rows +" rows remove.");
//        } catch(SQLException e){
//            e.printStackTrace();
//        }
    }

    public List<User> getAllUsers() {
//        String s ="SELECT * FROM users1";
        List<User> list = new ArrayList<>();
//        try (Connection connection = util.getConnect();PreparedStatement preparedstatement =connection.prepareStatement(s)) {
////            PreparedStatement preparedstatement =connection.prepareStatement(s);
//            ResultSet rows = preparedstatement.executeQuery(s);
//            while (rows.next()){
//                id1 = rows.getInt("id");
//                name1 = rows.getString("name");
//                lastName1 = rows.getString("lastname");
//                age1 = (byte) rows.getInt("age");
//                System.out.println(new User(name1,lastName1, (byte) age1));
//                list.add(new User(name1,lastName1, (byte) age1));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return list;
    }

    public void cleanUsersTable() {
//        String s ="TRUNCATE TABLE users1";
//        try (Connection connection = util.getConnect();Statement statement = connection.createStatement()){
////            Statement statement = connection.createStatement();
//            statement.executeUpdate(s);
//            System.out.println("table users1 clear");
//        } catch(SQLException e){
//            e.printStackTrace();
//        }
    }
}
