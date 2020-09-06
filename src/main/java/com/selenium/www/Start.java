package com.selenium.www;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MysqlConnect connect = new MysqlConnect();
        Connection con = connect.createConnection();
     //   Connection con1 = connect.createConnection();
        PreparedStatement pst;
    //    PreparedStatement pst1;
        ResultSet res;
        String s;
        String url;
        String title;
        String content;
        WebElement webElement;
        StringBuffer buffer = new StringBuffer();
        String regex = "^((http)?:\\/\\/www\\.zuowen\\.com/e)(.*)";
        String regex1 = "^((http)?:\\/\\/www\\.zuowen\\.com\\/)[a-z](.*)";
        BootChome bootChome = new BootChome();
        WebDriver webDriver = bootChome.bootChrome();
        List<WebElement> list = webDriver.findElements(By.xpath("//a"));
        //获取第一层url
        for (WebElement w : list) {
            s = w.getAttribute("href");
            if (s.matches(regex1)) {
                pst = con.prepareStatement("insert into url_save values (?,?)");
                pst.setString(1, s);
                pst.setInt(2, 1);
                pst.execute();
                //    System.out.println(s);
            }
        }
        list.clear();
        //获取二层连接
        pst = con.prepareStatement("select url from url_save where typecode=1;");
        res = pst.executeQuery();
        while (res.next()) {
            try {
                url = res.getString("url");
                System.out.println(url);
                if (url != null && url.matches(regex1)) {
                    webDriver.get(url);
                }
                //  list=webDriver.findElements(By.xpath("//a"));
                list.addAll(webDriver.findElements(By.xpath("//a")));
                //  pst.close();
                for (WebElement w : list) {

                    s = w.getAttribute("href");
                    //   System.out.println(s + " " + 2);

                    if (s != null && s.matches(regex1)) {
                        pst = con.prepareStatement("insert into url_save values (?,?)");
                        pst.setString(1, s);
                        pst.setInt(2, 2);
                        pst.execute();
                        //   System.out.println(s);
                    }

                }
                list.clear();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
/*
        //获取第三层连接,并将文本内容插入到数据库中
        pst = con.prepareStatement("select url from url_save where typecode=2");
        res = pst.executeQuery();
        //  list.clear();
        while (res.next()) {
            url = res.getString("url");
            webDriver.get(url);
            list.addAll(webDriver.findElements(By.xpath("//a")));
            for (WebElement w : list) {
                s = w.getAttribute("href");
                System.out.println(s);
                if (s.matches(regex)) {
                    pst = con.prepareStatement("insert into url_save values (?,?)");
                    pst.setString(1, s);
                    pst.setInt(2, 3);
                    pst.execute();
                    // System.out.println(s);
                    webDriver.get(s);
                    webElement = webDriver.findElement(By.className("h_title"));
                    title = webElement.getText();
                    //需要获取div的子元素，还没有处理
                    list = webDriver.findElement(By.className("con_content")).findElements(By.tagName("<p>"));
                    for (WebElement webElement1 : list) {
                        buffer.append(webElement1.getText());
                    }
                    content = buffer.toString();
                    pst = con.prepareStatement("insert into content_save values (?,?,?)");
                    pst.setString(1, s);
                    pst.setString(2, title);
                    pst.setString(3, content);
                    pst.execute();
                }
                list.clear();
            }


        }

 */
        connect.close();
        webDriver.close();
    }
}
