/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.service;

import com.adit.oep.model.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RUDRESH PATEL
 */
public class LoginService {
    public boolean studentLoginCheck(Connection dbConnection,Student formDetails)
            throws SQLException
    {
        String query = "select * from student_login where student_id="+formDetails.getsEnNumber();
        ResultSet dbData = new DBService().DataFetchService(dbConnection, query);
        Student userData = new Student(dbData.getString(3),dbData.getLong(1),dbData.getString(2));
        return(formDetails.getsEnNumber()==userData.getsEnNumber()&&formDetails.getsPassword().equals(userData.getsPassword()));
    }
}
