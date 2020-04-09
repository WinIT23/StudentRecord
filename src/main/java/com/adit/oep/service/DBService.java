/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author RUDRESH PATEL
 */
public class DBService {
    public ResultSet DataFetchService(Connection dbConnection,String query)
            throws SQLException
    {
        Statement stmt = dbConnection.createStatement();
        ResultSet tempData = stmt.executeQuery(query);
        tempData.next();
        return(tempData);
    }
}
