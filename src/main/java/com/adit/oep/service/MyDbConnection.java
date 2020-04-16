/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.service;

import com.adit.oep.model.Student;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author KHATRI
 */
public class MyDbConnection {
//    private Student student;
//    private String url;
//    private String dbName;
//    private String dbPass;
    
    
    public Student fetchStudent(long studentId){
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        
        SessionFactory factory=cfg.buildSessionFactory(reg);    

        //creating session object    
        Session session = factory.openSession();

        //creating transaction object    
        Transaction t = session.beginTransaction();
        
        Student s = (Student) session.get(Student.class, studentId);
        
        t.commit();
        return s;
    }
    
    public List fetchAllStudent(){
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        
        SessionFactory factory = cfg.buildSessionFactory(reg);
        
        Session session = factory.openSession();
        
        return session.createCriteria(Student.class).list();
    }
    
//    public MyDbConnection(String url,String dbName,String dbPass,Long sEnNumber,String sPass) {
//       student = new Student(sEnNumber,sPass);
//       this.url = url;
//       this.dbName = dbName;
//       this.dbPass = dbPass;
//   }
//   public Connection makeConnection(String url,String dbName,String dbPass) throws ClassNotFoundException, SQLException{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection myCon = DriverManager.getConnection(this.url,this.dbName,this.dbPass);
//            return myCon;
//    }
//   
//   public Student getInstance(){
//        return this.student;
//    }
//   
//   public ResultSet insertData(){
//       ResultSet userData = null;
//        try {
//            Connection con = makeConnection(url, dbName, dbPass);
//            Statement stmt = con.createStatement();
//            userData = stmt.executeQuery("select * from student_login where student_id="+student.getsEnNumber());
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(MyDbConnection.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(MyDbConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return userData;
//   
//   }
}
