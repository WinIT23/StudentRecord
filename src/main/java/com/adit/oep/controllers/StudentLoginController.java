/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.controllers;

import com.adit.oep.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author RUDRESH PATEL
 */
@Controller
public class StudentLoginController {
    @RequestMapping(value = "/StudentLogin",method = RequestMethod.POST)
    public ModelAndView loginCheck(@RequestParam long studentID,@RequestParam String studentPassword)
    {
        ModelAndView resultPage = new ModelAndView();
        Student formDetails = new Student(studentID,studentPassword);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student-record-database?autoReconnect=true&amp;useSSL=false");
            Statement stmt = dbConnection.createStatement();
            ResultSet userData = stmt.executeQuery("select * from student_login where student_password="+formDetails.getsPassword());
            userData.next();
            Student dbData = new Student(userData.getString(3),userData.getLong(1),userData.getString(2));
        }
        catch(SQLException SQLE)
        {
            SQLE.printStackTrace();
        }
        catch(ClassNotFoundException CNFE)
        {
            CNFE.printStackTrace();
        }
        catch(Exception E)
        {
            E.printStackTrace();
        }
        if(formDetails.getsEnNumber()==170010107036L&&formDetails.getsPassword().equals("rpatel"))
        {
            resultPage.addObject("Data","test");
            resultPage.setViewName("loginPage");
        }
        else
        {
            resultPage.setViewName("index");
        }
        return resultPage;
    }
}
