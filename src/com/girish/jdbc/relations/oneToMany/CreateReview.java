package com.girish.jdbc.relations.oneToMany;

import com.girish.jdbc.model.Course;
import com.girish.jdbc.model.Instructor;
import com.girish.jdbc.model.InstructorDetail;
import com.girish.jdbc.model.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateReview {
    public static void main(String[] args) {
        SessionFactory  sessionFactory = new Configuration().configure("hibernate-one-to-one.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Course course = session.get(Course.class, 13);
            System.out.println(course);

            course.addReview(new Review("nice course"));

            session.save(course);
            session.getTransaction().commit();
            session.close();
        }finally {
            sessionFactory.close();
        }
    }
}
