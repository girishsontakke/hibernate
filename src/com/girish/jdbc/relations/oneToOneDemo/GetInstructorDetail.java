package com.girish.jdbc.relations.oneToOneDemo;

import com.girish.jdbc.model.Instructor;
import com.girish.jdbc.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetail {
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

            // get InstructorDetail object
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 3);

            // print instructorDetail object
            System.out.println("instructorDetail: " + instructorDetail);

            // print instructor object associated with the instructorDetail object
            System.out.println("instructor associated with instructorDetail: " + instructorDetail.getInstructor());

            session.getTransaction().commit();
            session.close();
        }catch (NullPointerException nullPointerException){
            System.out.println("no data found");
            session.close();
        }
        finally {
            // closing session factory
            sessionFactory.close();
        }

    }
}
