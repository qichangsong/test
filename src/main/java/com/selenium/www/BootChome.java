package com.selenium.www;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootChome {
    public WebDriver bootChrome(){
        //  BootA boot= new BootA();
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://managersystest.clim.cn/purchase/");
        webDriver.manage().window().maximize();
        return webDriver;
    }
}
