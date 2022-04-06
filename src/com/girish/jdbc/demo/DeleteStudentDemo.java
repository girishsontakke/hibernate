package com.girish.jdbc.demo;

import com.girish.jdbc.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Enter a ID of student to delete : ");
            int id = new Scanner(System.in).nextInt();

            session.createQuery("delete from Student where id=" + id).executeUpdate();
//            session.delete(student);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
