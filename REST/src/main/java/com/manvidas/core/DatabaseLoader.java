package com.manvidas.core;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Component
public class DatabaseLoader  {

    public static String Connect()
    {
        Connection c = null;
        try {


            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432",
                            "postgres", "password");
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id FROM accounts");
            rs.next();
            return rs.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        return "Not found";
    }
}
