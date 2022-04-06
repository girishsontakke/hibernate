package com.girish.jdbc.demo;

import com.girish.jdbc.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        try {
            // create session and start transaction
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("getting student with id 2");
            Student student = session.get(Student.class, 2);
            System.out.println(student.getFirstName() + " " + student.getLastName());
            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }
}
