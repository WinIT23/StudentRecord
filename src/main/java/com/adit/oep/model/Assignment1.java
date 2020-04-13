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
 * @author KHATRI
 */
@Entity
@Table(name="assignment")
public class Assignment1 implements Serializable {
    @Id
    int year;
    int branch;
    String assignment_name;
    String submit_date;

    public Assignment1(int year, int branch, String assignment_name, String submit_date) {
        this.year = year;
        this.branch = branch;
        this.assignment_name = assignment_name;
        this.submit_date = submit_date;
    }

    public Assignment1() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }

    public String getAssignment_name() {
        return assignment_name;
    }

    public void setAssignment_name(String assignment_name) {
        this.assignment_name = assignment_name;
    }

    public String getSubmit_date() {
        return submit_date;
    }

    public void setSubmit_date(String submit_date) {
        this.submit_date = submit_date;
    }
    
    
}
