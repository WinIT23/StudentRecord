/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KHATRI
 */
public class MyDbConnection {
    private Student student;
    private String url;
    private String dbName;
    private String dbPass;
    
    public MyDbConnection(String url,String dbName,String dbPass,Long sEnNumber,String sPass) {
       student = new Student(sEnNumber,sPass);
       this.url = url;
       this.dbName = dbName;
       this.dbPass = dbPass;
   }
   public Connection makeConnection(String url,String dbName,String dbPass) throws ClassNotFoundException, SQLException{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myCon = DriverManager.getConnection(this.url,this.dbName,this.dbPass);
            return myCon;
    }
   
   public Student getInstance(){
        return this.student;
    }
   
   public ResultSet insertData(){
       ResultSet userData = null;
        try {
            Connection con = makeConnection(url, dbName, dbPass);
            Statement stmt = con.createStatement();
            userData = stmt.executeQuery("select * from student_login where student_id="+student.getsEnNumber());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyDbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MyDbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userData;
   
   }
}
