package com.qlkara.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trung98
 */
public class DBConnect {

    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://127.0.0.1:802/quanlykaraoke";
    public static String user = "lugd";
    public static String password = "myname";

    public static Connection getConnection() {
        try {
            Connection cons = null;
            Class.forName("com.mysql.jdbc.Driver");
            cons = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/quanlykaraoke?useUnicode=true&characterEncoding=UTF-8","lugd", "trung1998");
            return cons;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
     
        Connection c = getConnection();    
        System.out.println(c.toString());
        c.close();

    }

}
