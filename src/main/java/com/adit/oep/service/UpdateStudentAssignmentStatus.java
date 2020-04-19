/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.service;

import com.adit.oep.model.StudentAssignment;
import org.hibernate.Query;
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
public class UpdateStudentAssignmentStatus {
    
    public void updateStatus(String assignmentName, Long studentEn){
         Configuration cfg = new Configuration().configure().addAnnotatedClass(StudentAssignment.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        
        SessionFactory factory = cfg.buildSessionFactory(reg);
        
        Session session = factory.openSession();
        
        Transaction ts = session.beginTransaction();
        
        Query query = session.createQuery("UPDATE StudentAssignment sa SET sa.submited = :submited WHERE sa.assignment_name = :assignment_name and sa.student_id = :student_id");
        query.setParameter("submited", true);
        query.setParameter("assignment_name", assignmentName);
        query.setParameter("student_id", studentEn);
        query.executeUpdate();
        ts.commit();
    }
}
