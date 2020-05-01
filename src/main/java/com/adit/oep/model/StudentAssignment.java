/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author KHATRI, Win_It
 */
@Entity
@Table(name="student_assignment")
public class StudentAssignment implements Serializable {
   long student_id;
    @Id
    String assignment_name;
    boolean submited;

    public StudentAssignment(long student_id, String assignment_name, boolean submited) {
        this.student_id = student_id;
        this.assignment_name = assignment_name;
        this.submited = submited;
    }

    public StudentAssignment() {
    }
    
    

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public String getAssignment_name() {
        return assignment_name;
    }

    public void setAssignment_name(String assignment_name) {
        this.assignment_name = assignment_name;
    }

    public boolean isSubmited() {
        return submited;
    }

    public void setSubmited(boolean submited) {
        this.submited = submited;
    }
    
}
