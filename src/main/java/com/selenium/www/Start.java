package com.selenium.www;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Pattern;

public class Start {
    public static void main(String[] args) {
        String s;
       String regex="^((http)?:\\/\\/www\\.zuowen\\.com/e)(.*)";
       String regex1="^((http)?:\\/\\/www\\.zuowen\\.com)(.*)";
        BootChome bootChome=new BootChome();
        WebDriver webDriver=bootChome.bootChrome();
      List<WebElement> list= webDriver.findElements(By.xpath("//a"));
      for(WebElement w:list){
         s= w.getAttribute("href");
        if(s.matches(regex1)){
             System.out.println(s);
        }
      }
      webDriver.close();
    }
}
