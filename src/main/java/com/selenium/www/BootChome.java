package com.selenium.www;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 启动浏览器并输入地址，返回WebDriver实例
 */
public class BootChome {
    public WebDriver bootChrome(){
        //  BootA boot= new BootA();
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://managersystest.clim.cn/purchase/");
       // webDriver.get("http://www.zuowen.com/e/20200309/5e65ce10b5586.shtml");
        webDriver.manage().window().maximize();
        return webDriver;
    }
}


