/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author RUDRESH PATEL
 */

public class ConnectionService {
    private final String db_driver = "com.mysql.jdbc.Driver";
    private final String db_url = "jdbc:mysql://localhost:3306/student-record-database?autoReconnect=true&useSSL=false";
    private final String db_username = "root";
    private final String db_password = "1234@rudresh";
    public Connection getConnection()
            throws ClassNotFoundException,SQLException
    {
        Class.forName(db_driver);
        return(DriverManager.getConnection(db_url,db_username,db_password));
    }
}
