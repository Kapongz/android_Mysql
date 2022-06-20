package com.example.myapp;
import java.sql.*;

public class DBConnect {
    public static Connection getConnect() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String user ="pongkst";
            String pwd="96316032";
            String url="jdbc:mysql://172.20.10.3:4306/cw2";//ip wifi
            Connection c = DriverManager.getConnection(url,user,pwd);
            return c;

        }catch (Exception ex){
            return null;
        }
    }


}
