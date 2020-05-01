/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author KHATRI, Win_It
 */

@Entity
@Table(name="teacher_login")
public class Teacher implements Serializable {
    @Id
    @Column(name="teacher_name")
    String tName;
    @Column(name="teacher_pass")
    String tPassword;
    @Column(name="teacher_branch")
    int branch;
    @Column(name="teacher_subject")
    int subject;

    public Teacher(String tName, String tPassword, int branch, int subject) {
        this.tName = tName;
        this.tPassword = tPassword;
        this.branch = branch;
        this.subject = subject;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public Teacher() {
    }

    public Teacher(String tName, String tPassword) {
        this.tName = tName;
        this.tPassword = tPassword;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettPassword() {
        return tPassword;
    }

    public void settPassword(String tPassword) {
        this.tPassword = tPassword;
    }
    
    
    
}
