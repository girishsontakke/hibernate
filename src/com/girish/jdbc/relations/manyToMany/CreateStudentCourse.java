package com.girish.jdbc.relations.manyToMany;

import com.girish.jdbc.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentCourse {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate-one-to-one.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            Student student = new Student("New", "User", "new.user@compony.com");
            Student student1 = new Student("Second", "Student", "second.student@compony.com");


            Course course = session.get(Course.class, 35);
            Course course1 = session.get(Course.class, 13);

            student.addCourse(course);
            student.addCourse(course1);

            course1.addStudent(student1);

            session.save(student);
            session.save(student1);
            
            session.getTransaction().commit();
            session.close();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
