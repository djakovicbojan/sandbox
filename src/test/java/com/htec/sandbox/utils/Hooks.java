package com.htec.sandbox.utils;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    @Before("@browser")
    public void startBrowser() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\13umble13ee\\IdeaProjects\\sandbox\\src\\test\\resources\\webdriver\\windows\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();    }
}
