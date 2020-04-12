/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author KHATRI
 */

@Entity
@Table(name="teacher_login")
public class Teacher {
    @Id
    @Column(name="teacher_name")
    String tName;
    @Column(name="teacher_pass")
    String tPassword;

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
