package com.girish.jdbc.relations.oneToMany;

import com.girish.jdbc.model.Course;
import com.girish.jdbc.model.Instructor;
import com.girish.jdbc.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourse {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().
                configure("hibernate-one-to-one.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(Course.class).
                addAnnotatedClass(InstructorDetail.class).
                buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 3);

            Course course = new Course("my first course");
            instructor.addCourse(course);

            session.save(course);

            session.getTransaction().commit();
            session.close();
        }catch (Exception exc){
            exc.printStackTrace();
        }
        finally {
            sessionFactory.close();
        }
    }
}
