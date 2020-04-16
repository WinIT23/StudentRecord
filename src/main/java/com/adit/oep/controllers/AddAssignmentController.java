/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.controllers;

import com.adit.oep.model.Assignment1;
import com.adit.oep.model.Assignment2;
import com.adit.oep.model.Student;
import com.adit.oep.model.StudentAssignment;
import com.adit.oep.model.Teacher;
import com.adit.oep.service.AddAssignmentService;
import com.adit.oep.service.FetchAssginmentService;
import com.adit.oep.service.MyDbConnection;
import com.adit.oep.service.TeacherLoginService;
import java.util.ArrayList;
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
public class AddAssignmentController {

    @RequestMapping(value = "/AddAssign", method = RequestMethod.POST)
    public ModelAndView addAs(@RequestParam("tName") String teacherName, @RequestParam("assignmentYear") int year, @RequestParam("assginmentTitle") String assignment_name, @RequestParam("assginmentSubmitDate") String submit_date) {

        ModelAndView resultPage = new ModelAndView();

        AddAssignmentService aas = new AddAssignmentService();

//        Teacher t = new Teacher();
          boolean isAdded = false;
          

        TeacherLoginService tls = new TeacherLoginService();

        int branch = tls.fetchTeacher(teacherName).getBranch();

        MyDbConnection myCon = new MyDbConnection();

        List allStudent = myCon.fetchAllStudent();

        for (Object object : allStudent) {
            Student s = (Student) object;

            if (s.getYear(s.getsEnNumber()) == year && s.getBranchCode(s.getsEnNumber()) == branch) {
                StudentAssignment sa = new StudentAssignment(s.getsEnNumber(), assignment_name, false);
                aas.addStudentAssignment(sa);
                isAdded = true;
                
            }
        }

        Assignment2 as = new Assignment2(assignment_name, submit_date, year, teacherName);
        if (isAdded) {
            aas.addAssignment(as);
            resultPage.addObject("As", as);
         } else {
            resultPage.addObject("nostudenterror", "No Student Found!");
        }

        FetchAssginmentService fas = new FetchAssginmentService();

        List l = fas.fetchAllAssignment();

//        Assignment1 as = new Assignment1(year,t.getBranch(),assignment_name,submit_date);
//        
//        
//        
////        aac.addAs(year, branch, assignment_name, submit_date);
//        
//        aas.addAssignment(as);
//        
        resultPage.addObject("result", "added successfully");
        resultPage.addObject("assignments", l);
        
        resultPage.addObject("Data", teacherName);

        resultPage.setViewName("teacherLoginPage");

        return resultPage;
    }
}
