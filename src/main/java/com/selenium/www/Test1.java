package com.selenium.www;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        BootChome bootChome = new BootChome();
        WebDriver webDriver = bootChome.bootChrome();
        WebElement webElement;
        String title;
        String content;
        List<WebElement> list;
        StringBuffer buffer=new StringBuffer();
        webElement = webDriver.findElement(By.className("h_title"));
        title = webElement.getText();
        //需要获取div的子元素，还没有处理
        list= webDriver.findElement(By.className("con_content")).findElements(By.tagName("p"));
        System.out.println(list.size());
         for(WebElement webEle:list){
             buffer.append(webEle.getText()+"\n");
         }
        content = buffer.toString();
        System.out.println(title);
        content=content.replace("中小学写作指导、写作素材、优秀作文以及有奖活动","");
        content=content.replace("尽在“作文网”微信公众号","");
        System.out.println(content);

       webDriver.close();
    }
}
