package com.br.bookstore.mysql;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLConnection {
    private static Properties propertiesDatabase = new Properties();
    private static Connection connection;

    public static Connection getSQLConnection(){
        try{
            propertiesDatabase.load(SQLConnection.class.getResourceAsStream("/com/br/bookstore/mysql/properties.properties"));
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }

        String url = propertiesDatabase.getProperty("banco.url");
        String user = propertiesDatabase.getProperty("banco.user");
        String password = propertiesDatabase.getProperty("banco.password");

        try{
            return connection = DriverManager.getConnection(url, user, password);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public static void closeSQLConnection(){
        try{
            connection.close();
        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
