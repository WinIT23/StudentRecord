/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author KHATRI
 */
@Entity
@Table(name="assignment")
public class Assignment2 implements Serializable {
    @Id
    @Column
    String assignment_name;
    @Column
    String assignment_submit_date;
    @Column
    int assignment_year;
    @Column
    String teacher_name;

    public Assignment2() {
    }
    
    public Assignment2(String assignment_name, String assignment_submit_date, int assignment_year, String teacher_name) {
        this.assignment_name = assignment_name;
        this.assignment_submit_date = assignment_submit_date;
        this.assignment_year = assignment_year;
        this.teacher_name = teacher_name;
    }

    public Assignment2(String assignment_name, String assignment_submit_date) {
        this.assignment_name = assignment_name;
        this.assignment_submit_date = assignment_submit_date;
    }

    public String getAssignment_name() {
        return assignment_name;
    }

    public void setAssignment_name(String assignment_name) {
        this.assignment_name = assignment_name;
    }

    public String getSubmission_date() {
        return assignment_submit_date;
    }

    public void setSubmission_date(String submission_date) {
        this.assignment_submit_date = submission_date;
    }

    public int getAssignment_year() {
        return assignment_year;
    }

    public void setAssignment_year(int assignment_year) {
        this.assignment_year = assignment_year;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

       
}
