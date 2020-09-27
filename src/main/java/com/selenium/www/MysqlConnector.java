package com.selenium.www;

import java.sql.*;

public class MysqlConnector {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String sku="123231243100000001";
        String skuMerchant="13210023";
        String skc="1022357";
        String name="名字";
        String barcode="条形码";
        String specification="规格名称";
        String category="1";
        String s="ada";
        ResultSet res;
        String sql="select * from `purchase_system`.`base_product_sku` where sku_code=? and skc_code=?";
        Connection conn;
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //创建连接
        conn = DriverManager.getConnection("jdbc:mysql://47.93.202.197:3306/purchase_system?useUnicode=true&characterEncoding=utf8", "root", "123456000");
        PreparedStatement pst=conn.prepareStatement(sql);
        //执行SQL语句
        pst.setString(1,sku);
        pst.setString(2,skc);
  //      System.out.println(sql);
        //关闭

        res=pst.executeQuery();
        while (res.next())
        {
           String s1=res.getString("sku_merchant");
           String s2=res.getString("specifications");
            System.out.println(s1+","+s2);
        }
            pst.close();
            conn.close();
    }
}
