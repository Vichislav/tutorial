package com.example.demo;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        //строка подкл. к бд со всеми нужными данными
        //"jdbc:mysql//" - специальный плагин связи java с бд
        //String connectionString = "cj.jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        String connectionString = "jdbc:mysql://localhost:3306/demo_schema";
        //Class.forName("com.mysql.cj.jdbc.Drive");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }
    //в метод были добавлен проброс исключений (throws SQLException, ClassNotFoundException) т.е. IDEA ругалась строку с PreparedStatement
    public void signUpUser (String firstName, String lastName, String userName, String password, String location, String gender) throws SQLException, ClassNotFoundException {
        // insert - это получается SQL запрос который сообщает что в такие то поля
        // мы их как раз перечисляем ниже нужно будет в таблицу USER_TABLE
        // вставить данные которые будут внаходится внутри "VALUES(?, ?, ?, ?, ?, ?)"
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + "," +
                Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + "," +
                Const.USERS_LOCATION + "," + Const.USER_GENDER + ")" +
                "VALUES(?, ?, ?, ?, ?, ?)";
        // теперь "подготавливаем" данные для вставки
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        //перечисляем нужные нам данные
        prSt.setString(1, firstName);
        prSt.setString(2, lastName);
        prSt.setString(3, userName);
        prSt.setString(4, password);
        prSt.setString(5, location);
        prSt.setString(6, gender);

        prSt.executeUpdate();

    }
}
