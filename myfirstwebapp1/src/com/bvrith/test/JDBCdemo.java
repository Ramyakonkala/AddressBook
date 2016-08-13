package com.bvrith.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo {
    public static void main(String ar[]){
        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "ramya";
        Connection conn = null;
        Statement st=null;
        String query = "insert into users values('tom','jerry')";
       
        try {
            //load driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver loaded");
            //create connection
             conn = DriverManager.getConnection(url,user,password);
            System.out.println(conn);
            //create statement
            st = conn.createStatement();
            System.out.println(st);
            //execute query
            int result = st.executeUpdate(query);
            if(result>=1){
                System.out.println("Record Inserted");
            }else{
                System.out.println("Record not Inserted");
            }
           
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                if(conn != null){
                conn.close();}
                if(st != null){
                st.close();}
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}