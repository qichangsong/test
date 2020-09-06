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

public class Test {
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
        String regex = "^((http)?:\\/\\/www\\.zuowen\\.com/e\\/)(.*)";
        String regex1 = "^((http)?:\\/\\/www\\.zuowen\\.com\\/)[a-z](.*)";
        BootChome bootChome = new BootChome();
        WebDriver webDriver = bootChome.bootChrome();
        List<WebElement> list = new ArrayList<WebElement>();
        //获取第三层连接,并将文本内容插入到数据库中
        pst = con.prepareStatement("select url from url_save where typecode=2");
        res = pst.executeQuery();
        //  list.clear();
        while (res.next()) {
            try{
                url = res.getString("url");
                if (url != null && url.matches(regex1)) ;
                webDriver.get(url);
                System.out.println(url);
                list.addAll(webDriver.findElements(By.xpath("//a")));
                for (WebElement w : list) {
                    try {
                        s = w.getAttribute("href");
                        //  System.out.println(s);
                        if (s != null && s.matches(regex)) {
//                        pst = con.prepareStatement("insert into url_save values (?,?)");
//                        pst.setString(1, s);
//                        pst.setInt(2, 3);
//                        pst.execute();
                            //      System.out.println(s);

                            webDriver.get(s);
                            webElement = webDriver.findElement(By.className("h_title"));
                            title = webElement.getText();
                            //需要获取div的子元素，还没有处理
                            list = webDriver.findElement(By.className("con_content")).findElements(By.tagName("p"));
                            for (WebElement webElement1 : list) {
                                buffer.append(webElement1.getText() + "\n");
                            }
                            content = buffer.toString();
                            content = content.replace("中小学写作指导、写作素材、优秀作文以及有奖活动", "");
                            content = content.replace("尽在“作文网”微信公众号", "");
                            pst = con.prepareStatement("insert into content_save values (?,?,?)");
                            pst.setString(1, s);
                            pst.setString(2, title);
                            pst.setString(3, content);
                            pst.execute();
                        }

                        //  }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    buffer.setLength(0);

                }
                list.clear();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        connect.close();
        webDriver.close();

    }
}
