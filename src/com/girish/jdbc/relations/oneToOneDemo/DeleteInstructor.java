package com.girish.jdbc.relations.oneToOneDemo;

import com.girish.jdbc.model.Instructor;
import com.girish.jdbc.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructor {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate-one-to-one.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 2);

            if (instructor != null) {
                // Associated instructorDetail object also will be deleted
                session.delete(instructor);
            }

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
