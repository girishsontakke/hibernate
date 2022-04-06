package com.girish.jdbc.relations.oneToOneDemo;

import com.girish.jdbc.model.Instructor;
import com.girish.jdbc.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructor {
    public static void main(String[] args) {
        // creating session factory
        SessionFactory sessionFactory = new Configuration().
                configure("hibernate-one-to-one.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // create objects

            Instructor instructor = new Instructor("Girish", "Sontakke", "girishsontakke7@gmail.com");

            InstructorDetail instructorDetail  = new InstructorDetail("someyoutubechannel", "coding");

            // associate objects
            instructor.setInstructorDetail(instructorDetail);

            // save objects
            // on saving instructor, instructorDetail will be automatically saved due to CascadeType.ALL

            session.save(instructor);

            session.getTransaction().commit();
            session.close();
        }finally {
            // closing session factory
            sessionFactory.close();
        }

    }
}
