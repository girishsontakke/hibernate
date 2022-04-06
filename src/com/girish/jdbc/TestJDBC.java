package com.girish.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String password = "hbstudent";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("connecting to " + jdbcUrl);
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("connection successful");
        }catch (Exception exc){
            exc.printStackTrace();
        }
    }
}
