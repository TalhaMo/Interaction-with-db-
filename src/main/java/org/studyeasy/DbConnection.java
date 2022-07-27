package org.studyeasy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection con = null;
    
    public static Connection getConnexion() {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(
                		"jdbc:mysql://localhost:3306/studyeasy_db",
    	                "root", "BonjouR#2023!");
            } catch (SQLException sqlex) {
                sqlex.printStackTrace();
            } catch(ClassNotFoundException cnfex) {
                cnfex.printStackTrace();
            }
            return con;
        }
        else {
            return con;
        }
    }
    }

