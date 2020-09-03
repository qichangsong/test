package com.selenium.www;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootChome {
    public WebDriver bootChrome(){
        //  BootA boot= new BootA();
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://www.zuowen.com/e/20200523/5ec9394f1007f.shtml");
        webDriver.manage().window().maximize();
        return webDriver;
    }
}
