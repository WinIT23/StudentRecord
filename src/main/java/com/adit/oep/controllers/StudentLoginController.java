/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.controllers;


import com.adit.oep.model.Assignment1;
import com.adit.oep.model.Assignment2;
import java.sql.SQLException;

import com.adit.oep.service.MyDbConnection;
import com.adit.oep.model.Student;
import com.adit.oep.model.StudentAssignment;
import com.adit.oep.model.Teacher;
import com.adit.oep.service.FetchAssginmentService;

import com.adit.oep.service.TeacherLoginService;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


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

        int stBranchCode = formDetails.getBranchCode(studentID);
        int stYear = formDetails.getYear(studentID);
        
        FetchAssginmentService fas = new FetchAssginmentService();
        
        List l = fas.fetchAllAssignment();
        List AllAssignmentList = fas.FetchAllStudentAssignment();
        
        List s = new ArrayList();
        List studentAssignmentList = new ArrayList();
        List teacherBranch = new ArrayList();
        List assignmentSubject = new ArrayList();
        List teacherName = new ArrayList();
        Teacher tempTeacher = null;
        
        
        
        for (Iterator it = l.iterator(); it.hasNext();) {
            Assignment2 object = (Assignment2) it.next();
            
            if(object.getAssignment_year() == stYear){
                s.add(object);
                tempTeacher = new TeacherLoginService().fetchTeacher(object.getTeacher_name());
                teacherBranch.add(tempTeacher.getBranch());
                assignmentSubject.add(tempTeacher.getSubject());
                teacherName.add(tempTeacher.gettName());
            }
        for(Iterator it2 = AllAssignmentList.iterator(); it2.hasNext();)
        {
            StudentAssignment tempObject = (StudentAssignment) it2.next();
            if(tempObject.getStudent_id()==formDetails.getsEnNumber())
            {
                studentAssignmentList.add(tempObject);
            }
        }
        }
      
        MyDbConnection con = new MyDbConnection();

        Student tempObject = con.fetchStudent(studentID);

        if (teacherBranch!=null&&formDetails!=null&&formDetails.getsPassword().equals(tempObject.getsPassword())) {
            resultPage.addObject("Data", tempObject.getsName());
            resultPage.addObject("assignments",s);
            
//            resultPage.addObject("Date",);
            resultPage.addObject("Date", java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd MM yyyy")));
            resultPage.addObject("Year",tempObject.getYear(formDetails.getsEnNumber()));
            resultPage.addObject("Branches", teacherBranch);
            resultPage.addObject("Subjects", assignmentSubject);
            resultPage.addObject("TeacherName", teacherName);
            resultPage.addObject("AssignmentStatus", studentAssignmentList);
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
        
        FetchAssginmentService fas = new FetchAssginmentService();
        
        List l = fas.fetchAllAssignment();
//        
       
        
        if(formDetails.gettPassword().equals(tempObject.gettPassword())){
            resultPage.addObject("assignments",l);
            resultPage.addObject("Data",tempObject.gettName());
            resultPage.addObject("year",tempObject.getBranch());
            resultPage.setViewName("teacherLoginPage");   
        }
        else
        {
            resultPage.setViewName("index");
        }
        return resultPage;
    }
}
