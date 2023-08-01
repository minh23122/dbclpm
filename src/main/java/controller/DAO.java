/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AD
 */
public class DAO {

    String dbUrl = "jdbc:mysql://localhost:3306/quanlytour";
    String dbClass = "com.mysql.cj.jdbc.Driver";
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String urlsString="jdbc:mysql://localhost:3306/quanlytour";
        return DriverManager.getConnection(urlsString,"root","1234");
    }
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        System.out.println(new DAO().getConnection());
//    }
}

