package com.selenium.www;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageDowload {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        MysqlConnect connect = new MysqlConnect();
        Connection con = connect.createConnection();
        PreparedStatement pst;
        ResultSet res;
        //根据旺店通商家编码去查询图片的路径，每一个商家编码对应多张图片
        pst=con.prepareStatement("select * from image where wdtcode='939000001'");
        res=pst.executeQuery();
        String s;
        String s1;
        String s2;
        File file;
        int i=1;
        while (res.next()) {
            s=res.getString("imageUrl");
            s1=res.getString("wdtcode");
            s2=res.getString("imagetype");
            URL url1 = new URL(s);
          //  System.out.println(s);
            URLConnection uc = url1.openConnection();
            InputStream inputStream = uc.getInputStream();
            file=new File("D:\\image\\"+s1);
            if(!file.exists()) {
                file.mkdir();
            }
            FileOutputStream out = new FileOutputStream("D:\\image\\"+s1+"\\"+s1+"_"+s2+".jpeg");
            i++;
            int j = 0;
            while ((j = inputStream.read()) != -1) {
                out.write(j);
            }
            inputStream.close();

        }

    }
}
