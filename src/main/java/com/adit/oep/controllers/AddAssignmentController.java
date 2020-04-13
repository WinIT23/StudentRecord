/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.controllers;

import com.adit.oep.model.Assignment1;
import com.adit.oep.service.AddAssignmentService;
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
    
    @RequestMapping(value = "/AddAssign",method = RequestMethod.POST)
    public ModelAndView addAs(@RequestParam("assignmentYear") int year,@RequestParam("assignmentBranch") int branch,@RequestParam("assginmentTitle") String assignment_name,@RequestParam("assginmentSubmitDate") String submit_date){
        
        ModelAndView resultPage = new ModelAndView();
        
        AddAssignmentService aas = new AddAssignmentService();
        
        Assignment1 as = new Assignment1(year,branch,assignment_name,submit_date);
        
//        aac.addAs(year, branch, assignment_name, submit_date);
        
        aas.addAssignment(as);
        
        resultPage.addObject("result","added successfully");
        
        resultPage.setViewName("teacherLoginPage");   
        
        return resultPage;
    }
}
