/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.model;

import java.util.HashMap;

/**
 *
 * @author Win_It
 */
public class Subject {

    private static final HashMap<Integer, String> SUBJECT_MAP = new HashMap<Integer, String>();

    private final String subName;
    private final int subCode;
    private final String faculty;

    public Subject(int subCode, String faculty) {
        this.subName = SUBJECT_MAP.get(subCode) != null ? SUBJECT_MAP.get(subCode) : "";
        this.subCode = subCode;
        this.faculty = faculty;
    }

    public String getSubName() {
        return this.subName;
    }

    public int getSubCode() {
        return this.subCode;
    }

    public String getFaculty() {
        return this.faculty;
    }
}
