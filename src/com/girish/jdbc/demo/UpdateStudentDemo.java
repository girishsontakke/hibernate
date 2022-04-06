package com.girish.jdbc.demo;

import com.girish.jdbc.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Student student =  session.get(Student.class, 5);
            if (student != null) {
                System.out.printf("Enter new Email for %s : ", student.getFirstName());
                String newEmail = new Scanner(System.in).next();
                student.setEmail(newEmail);
            }

//            session.createQuery("update Student set email='girish.sontakke@cars24.com' where firstName='girish'").executeUpdate();

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
