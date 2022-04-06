package com.girish.jdbc.demo;

import com.girish.jdbc.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // getting all students
            List<Student> studentList = session.createQuery("from Student", Student.class).getResultList();
            printStudent(studentList);

            // getting all students with id greater than 3 and lastName starts with kam
            List<Student> studentList1 = session.createQuery("from Student where id>3 and lastName like 'kam%'", Student.class).getResultList();
            printStudent(studentList1);

            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }

    public static void printStudent(List<Student> studentList){
        for(Student student: studentList){
            System.out.println(student);
        }
    }
}
