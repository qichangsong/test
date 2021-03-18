package com.selenium.www;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Test1 {
    public static void main(String[] args) {
     BootChome bootChome=new BootChome();
     WebDriver webDriver=bootChome.bootChrome();
     webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/ul/li[1]/div")).click();
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/ul/li[1]/ul/li[1]/a")).click();

    }
}
