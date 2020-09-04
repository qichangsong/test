package com.selenium.www;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Start {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MysqlConnect connect=new MysqlConnect();
        Connection con=connect.createConnection();
        PreparedStatement pst;
        String s;
       String regex="^((http)?:\\/\\/www\\.zuowen\\.com/e)(.*)";
       String regex1="^((http)?:\\/\\/www\\.zuowen\\.com)(.*)";
        BootChome bootChome=new BootChome();
        WebDriver webDriver=bootChome.bootChrome();
      List<WebElement> list= webDriver.findElements(By.xpath("//a"));
      for(WebElement w:list){
         s= w.getAttribute("href");
        if(s.matches(regex1)){
             pst=con.prepareStatement("insert into url_save values (?,?)");
             pst.setString(1,s);
             pst.setInt(2,1);
             pst.execute();
             System.out.println(s);
        }
      }
      connect.close();
      webDriver.close();
    }
}
