package com.green.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnectionTest {
    public static void main(String[] args) throws Exception{
        String DB_URL ="jdbc:mysql://@localhost:3306/jspboard";
        String DB_USER = "root";
        String DB_PASSWORD = "green502";

        Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        Statement stmt = conn.createStatement();

        String query = "SELECT now()";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()){
            String curDate = rs.getString(1);
            System.out.println(curDate);
        }
    }
}
