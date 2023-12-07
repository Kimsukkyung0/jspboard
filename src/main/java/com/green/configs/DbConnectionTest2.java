package com.green.configs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

public class DbConnectionTest2 {
    public static void main(String[] args) throws Exception{
//        String DB_URL ="jdbc:mysql://@localhost:3306/jspboard";
//        String DB_USER = "root";
//        String DB_PASSWORD = "green502";
//        String DB_DRIVER = "com.mysql.jdbc.Driver";
//
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName(DB_DRIVER);
//        ds.setUrl(DB_URL);
//        ds.setUsername(DB_USER);
//        ds.setPassword(DB_PASSWORD);

//        Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
//        Statement stmt = conn.createStatement();
//
//        String query = "SELECT now()";
//        ResultSet rs = stmt.executeQuery(query);
//
//        while (rs.next()){
//            String curDate = rs.getString(1);
//            System.out.println(curDate);
//        }

        ApplicationContext ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
        DataSource ds = ac.getBean(DataSource.class);

        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
