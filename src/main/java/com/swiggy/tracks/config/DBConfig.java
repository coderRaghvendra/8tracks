package com.swiggy.tracks.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by raghvendra.mishra on 11/03/20.
 */
public class DBConfig {

    private static final Logger logger = LogManager.getLogger(DBConfig.class);
    private static Connection conn = null;
    
    public static void initialize() {
        if (conn == null) {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/tracks", "root", "root");
            } catch(SQLException e) {
                logger.info("SQLException while connecting to DB : ", e);
            } catch(Exception e) {
                logger.info("Exception while connecting to DB: ", e);
            }
        }
    }

    public static void closeDB() {
        try {
            conn.close();
        } catch (Exception e) {
            logger.info("Exception while closing connection to DB : ", e);
        }
    }

    public static Connection getConn() {
        return conn;
    }
}
