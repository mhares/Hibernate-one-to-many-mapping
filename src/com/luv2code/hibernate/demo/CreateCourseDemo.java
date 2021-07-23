package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;

public class CreateCourseDemo {
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
           int id = 1;
           Instructor tempInstructor=session.get(Instructor.class,id);
           Course  course = new Course("Java");
           Course  course1 = new Course("C++");
           tempInstructor.addCourse(course);
           tempInstructor.addCourse(course1);
           session.save(course);
           session.save(course1);

            session.getTransaction().commit();

        }finally {
            session.close();
        }
    }
}
