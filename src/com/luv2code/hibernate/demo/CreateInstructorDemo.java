package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;


public class CreateInstructorDemo {
    public static void main(String[] args) throws ParseException {
        SessionFactory factory = new Configuration()
                                      .configure()
                                      .addAnnotatedClass(Instructor.class)
                                      .addAnnotatedClass(InstructorDetail.class)
                                      .addAnnotatedClass(Course.class)
                                      .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();
            InstructorDetail instructorDetail = new InstructorDetail("yoyo@youtube.com","Swimming");
            Instructor instructor = new Instructor("Yara","Shaban","yoyoShaban@yahoo.com",instructorDetail);
            session.save(instructor);
            session.getTransaction().commit();

        }finally {
          session.close();
        }
    }
}
