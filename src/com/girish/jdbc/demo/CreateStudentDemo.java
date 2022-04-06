package com.girish.jdbc.demo;

import com.girish.jdbc.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;


public class CreateStudentDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).
                buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first Name: ");
        String firstName = sc.next();
        System.out.print("Enter the last Name: ");
        String lastName = sc.next();
        System.out.print("Enter the email: ");
        String email = sc.next();

        Student tempStudent = new Student(firstName, lastName, email);

        try{
            session.beginTransaction();
            session.save(tempStudent);
            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }


    }
}
