package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;


public class DeleteInstructorDemo {
    public static void main(String[] args) throws ParseException {
        SessionFactory factory = new Configuration()
                                      .configure()
                                      .addAnnotatedClass(Instructor.class)
                                      .addAnnotatedClass(InstructorDetail.class)
                                      .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();
            int theId=1;
           Instructor tempInstructor= session.get(Instructor.class,theId);
            System.out.println(tempInstructor);

            if(tempInstructor != null)
                session.delete(tempInstructor);

            session.getTransaction().commit();

        }finally {
          session.close();
        }
    }
}
