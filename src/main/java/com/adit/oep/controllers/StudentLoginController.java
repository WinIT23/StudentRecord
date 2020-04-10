/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.controllers;

import com.adit.oep.model.Student;
import com.adit.oep.service.ConnectionService;
import com.adit.oep.service.LoginService;

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
            throws ClassNotFoundException,SQLException
    {
        ModelAndView resultPage = new ModelAndView();
        boolean loginFlag = false;
        Student formDetails = new Student(studentID,studentPassword);
        try
        {
            Connection dbConnection = new ConnectionService().getConnection();
            loginFlag = new LoginService().studentLoginCheck(dbConnection,formDetails);
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
        if(loginFlag)
        {
            resultPage.addObject("Data",formDetails.getsEnNumber());
            resultPage.setViewName("loginPage");   
        }
        else
        {
            resultPage.setViewName("index");
        }
        return resultPage;
    }
}
