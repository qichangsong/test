package com.selenium.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

    public class MysqlConnect {
        Connection conn;

        public Connection createConnection() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 创建连接
            conn = DriverManager.getConnection("jdbc:mysql://47.93.202.197:3306/purchase_system?useUnicode=true&characterEncoding=utf8", "root", "123456000");
            return conn;
        }

        public void close() throws SQLException {
            conn.close();
        }
    }

