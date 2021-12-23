package com.example.demo;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

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
    public void signUpUser (User user) throws SQLException, ClassNotFoundException {
        // insert - это получается SQL запрос который сообщает, что в такие то поля,
        // мы их как раз перечисляем ниже, нужно будет в таблицу USER_TABLE
        // вставить данные, которые будут находится внутри "VALUES(?, ?, ?, ?, ?, ?)"
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + "," +
                Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + "," +
                Const.USERS_LOCATION + "," + Const.USER_GENDER + ")" +
                "VALUES(?, ?, ?, ?, ?, ?)";
        // теперь "подготавливаем" данные для вставки
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        //перечисляем нужные нам данные
        prSt.setString(1, user.getFirstName());
        prSt.setString(2, user.getLastName());
        prSt.setString(3, user.getUserName());
        prSt.setString(4, user.getPassword());
        prSt.setString(5, user.getLocation());
        prSt.setString(6, user.getGender());

        prSt.executeUpdate();

    }
    // метод для внесения в базу данных, данных из таблицы Products
    public void enterProducts (Products products) throws SQLException, ClassNotFoundException {
        // insert - это получается SQL запрос который сообщает, что в такие то поля,
        // мы их как раз перечисляем ниже, нужно будет в таблицу USER_TABLE
        // вставить данные, которые будут находится внутри "VALUES(?, ?, ?, ?, ?, ?)"
        String insert = "INSERT INTO " + Const.PRODUCTS_TABLE + "(" +
                Const.PRODUCTS_NAME + "," + Const.PRODUCTS_AMOUNT + "," +
                Const.PRODUCTS_PRICE + "," + Const.PRODUCTS_SUPPLIER  + ")" +
                "VALUES(?, ?, ?, ?)";
        // теперь "подготавливаем" данные для вставки
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        //перечисляем нужные нам данные

        prSt.setString(1, products.getName());
        prSt.setDouble(2, products.getAmount());
        prSt.setDouble(3, products.getPrice());
        prSt.setString(4, products.getSupplier());


        prSt.executeUpdate();

    }

    // ResultSet - это массив данных из нужной нам строки таблицы
    // получаем вроде как по id
    public ResultSet getUser (User user) {
        ResultSet resSet = null;
        //формируем  строку select - SQL запрос
        //SELECT - выбрать, * - все, FROM - из (таблицы USER_TABLE)
        // WHERE - где, поле USERS_USERNAME равно чему либо =?, AND - и
        // поле USERS_PASSWORD равно чему либо "=?", чему мы укажем ниже
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USERS_USERNAME + "=? AND " + Const.USERS_PASSWORD + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            //перечисляем нужные нам данные

            prSt.setString(1, user.getUserName());
            prSt.setString(2, user.getPassword());


            resSet = prSt.executeQuery(); //команда выборки данных...
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }
}
