/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.model;

import java.util.List;

/**
 *
 * @author Win_It
 */
public class Student {

    private String sName;
    private long sEnNumber;
    private String sPassword;
    private int sBranchCode;
    private int sEntryYear;

    private List<Assignment> assignmentDone;
    private List<Assignment> assignmentRemain;

    public Student()
    {
        this.sEnNumber = 0L;
    }
    public Student(long sEnNumber,String sPassword)
    {
        this.sEnNumber = sEnNumber;
        this.sPassword = sPassword;
    }
    public Student(String sName, long sEnNumber, String sPassword) {
        this.sName = sName;
        this.sEnNumber = sEnNumber;
        this.sPassword = sPassword;

        processEnrollmentNumber();
    }

    private void processEnrollmentNumber() {
        long temp = this.sEnNumber;
        temp /= 1000;
        this.sBranchCode = (int) (temp % 100);
        temp /= 10000000;

        this.sEntryYear = 2000 + (int) temp;
    }
    
    public String getsPassword()
    {
        return sPassword;
    }
    
    public long getsEnNumber()
    {
        return sEnNumber;
    }
    
    public String getsName()
    {
        return sName;
    }
    
    public void setsPassword(String sPassword)
    {
        this.sPassword = sPassword;
    }
    
    public void setsName(String sName)
    {
        this.sName = sName;
    }
    
    public void setsEnNumber(long sEnNumber)
    {
        this.sEnNumber = sEnNumber;
    }
}