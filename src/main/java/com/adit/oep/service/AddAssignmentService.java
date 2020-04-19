/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.service;

//import com.adit.oep.model.Assignment1;
import com.adit.oep.model.Assignment;
import com.adit.oep.model.StudentAssignment;
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
public class AddAssignmentService {
    
    public void addAssignment(Assignment as){
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Assignment.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        
        SessionFactory factory=cfg.buildSessionFactory(reg);    

        //creating session object    
        Session session = factory.openSession();

        //creating transaction object    
        Transaction t = session.beginTransaction();
        
//        Assignment1 as = new Assignment1(year, branch, assignment_name, date);
        
        session.save(as);
        t.commit();
//        session.close();
//        factory.close();
        
    }
    
    public void addStudentAssignment(StudentAssignment sa){
        
        Configuration cfg = new Configuration().configure().addAnnotatedClass(StudentAssignment.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        
        SessionFactory factory=cfg.buildSessionFactory(reg);    

        //creating session object    
        Session session = factory.openSession();

        //creating transaction object    
        Transaction t = session.beginTransaction();
        
//        Assignment1 as = new Assignment1(year, branch, assignment_name, date);
        
        session.save(sa);
        t.commit();
        
    }
}
