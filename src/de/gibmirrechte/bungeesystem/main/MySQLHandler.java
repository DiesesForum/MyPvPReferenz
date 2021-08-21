package de.gibmirrechte.bungeesystem.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLHandler {

    private static Connection connection;

    public Connection getConnection(){
        return connection;
    }

    public void connect(){
        try{
            // Die Daten könnt ihr gerne haben (Ist ein free MySQL Hoster zum testen <3)
            connection = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net/sql11431704?autoReconnect=true", "sql11431704", "PYPqcBEzMP");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println("MySQL erfolgreich verbunden!");
    }

    public void disconnect(){
        try{
            connection.close();
        }catch (SQLException ignored){
        }
    }

}
