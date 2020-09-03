package com.selenium.www;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Start {
    public static void main(String[] args) {
        String s;
        BootChome bootChome=new BootChome();
        WebDriver webDriver=bootChome.bootChrome();
      List<WebElement> list= webDriver.findElements(By.xpath("//a"));
      for(WebElement w:list){
         s= w.getAttribute("href");
          System.out.println(s);
      }
      webDriver.close();
    }
}
