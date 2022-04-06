package com.girish.jdbc.relations.oneToMany;

import com.girish.jdbc.model.Course;
import com.girish.jdbc.model.Instructor;
import com.girish.jdbc.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RetrieveCourse {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate-one-to-one.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();

            Instructor instructor = session.createQuery("from Instructor where id=3", Instructor.class).getSingleResult();

            System.out.printf("Courses of the instructor with id = 3: " + instructor.getCourses());

        }finally {
            sessionFactory.close();
        }
    }
}
