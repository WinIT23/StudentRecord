/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.controllers;

import java.sql.SQLException;

import com.adit.oep.service.MyDbConnection;
import com.adit.oep.model.Student;
import com.adit.oep.model.Teacher;
import com.adit.oep.service.TeacherLoginService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author KHATRI
 */
@Controller
public class StudentLoginController {

    @RequestMapping(value = "/StudentLogin", method = RequestMethod.POST)
    public ModelAndView loginCheck(@RequestParam("studentID") long studentID, @RequestParam("studentPassword") String studentPassword)
            throws ClassNotFoundException, SQLException {
        ModelAndView resultPage = new ModelAndView();
//        boolean loginFlag = false;
        Student formDetails = new Student(studentID, studentPassword);
//        String dbUrl = "jdbc:mysql://localhost:3306/student_record?autoReconnect=true&useSSL=false";
//        String dbName = "root";
//        String dbPass = "root";

        MyDbConnection con = new MyDbConnection();

        Student tempObject = con.fetchStudent(studentID);

        if (formDetails.getsPassword().equals(tempObject.getsPassword())) {
            resultPage.addObject("Data", tempObject.getsName());

            resultPage.setViewName("loginPage");
        } else {
            resultPage.setViewName("index");
        }

//        MyDbConnection con = new MyDbConnection(dbUrl, dbName, dbPass, studentID, studentPassword);
//        try
//        {
//           Connection dbConnection = con.makeConnection(dbUrl, dbName, dbPass);
//           ResultSet userData = con.insertData();
//           userData.next();
//           Student dbData = new Student(userData.getString(3),userData.getLong(1),userData.getString(2));
//           if(formDetails.getsEnNumber()==dbData.getsEnNumber()&&formDetails.getsPassword().equals(dbData.getsPassword()))
//            {
//                loginFlag = true;
//                tempObject = dbData;
//            }
//            else
//            {
//                loginFlag = false;
//            }
//        }
//        catch(SQLException SQLE)
//        {
//            SQLE.printStackTrace();
//        }
//        catch(ClassNotFoundException CNFE)
//        {
//            CNFE.printStackTrace();
//        }
//        catch(Exception E)
//        {
//            E.printStackTrace();
//        }
//        if(loginFlag)
//        {
//            resultPage.addObject("Data",tempObject.getsName());
//            resultPage.setViewName("loginPage");   
//        }
//        else
//        {
//            resultPage.setViewName("index");
//        }
        return resultPage;
    }
    
    @RequestMapping(value = "/TeacherLogin",method = RequestMethod.POST)
    public ModelAndView teacherLoginCheck(@RequestParam ("teacherName") String teacherName,@RequestParam ("teacherPass") String teacherPass){
        
        ModelAndView resultPage = new ModelAndView();
        
        Teacher tempObject ;
        
        Teacher formDetails = new Teacher(teacherName, teacherPass);
        
        TeacherLoginService tls = new TeacherLoginService();
        
        tempObject = tls.fetchTeacher(teacherName);
        
        if(formDetails.gettPassword().equals(tempObject.gettPassword())){
            resultPage.addObject("Data",tempObject.gettName());
        
            resultPage.setViewName("loginPage");   
        }
        else
        {
            resultPage.setViewName("index");
        }
        return resultPage;
    }
}
