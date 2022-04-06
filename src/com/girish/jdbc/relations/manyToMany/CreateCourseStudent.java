package com.girish.jdbc.relations.manyToMany;

import com.girish.jdbc.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseStudent {
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

            Course course1 = new Course("Get better at chess");
            Course course2 = new Course("Get better at cricket");
            Course course3 = new Course("Get better at football");

            session.save(course1);
            session.save(course2);
            session.save(course3);

            Student student1 = new Student("Girish", "Sontakke", "girish.sontakke@compony.com");
            Student student2 = new Student("John", "Doe", "john.doe@compony.com");
            Student student3 = new Student("mahesh", "Aggarwal", "mahesh.aggarwal");

            course1.addStudent(student1);
            course2.addStudent(student2);
            course2.addStudent(student3);
            course3.addStudent(student1);
            course3.addStudent(student2);
            course3.addStudent(student3);

            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();
            session.close();
        }finally {
            sessionFactory.close();
        }
    }
}
