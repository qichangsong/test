package com.selenium.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

    public class MysqlConnect {
        Connection conn;
        PreparedStatement pst;


        public Connection createConnection() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            // 创建连接
            conn = DriverManager.getConnection("jdbc:mysql://106.54.88.89/test1?useUnicode=true&characterEncoding=utf8", "root", "MIN@lan3102");
            return conn;
        }

        public void close() throws SQLException {
            conn.close();
        }
    }

