package com.htec.sandbox.core.ui;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static Driver instance = null;

    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();


    private Driver() {

    }

    public static Driver getInstance() {
        if (instance == null) {
            instance = new Driver();
        }
        return instance;
    }

    public void setDriver() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\13umble13ee\\IdeaProjects\\sandbox\\src\\test\\resources\\webdriver\\windows\\chromedriver.exe");

        webDriver.set(new ChromeDriver());
        getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }

    public WebDriver getDriver() {
        return webDriver.get();
    }

    public void closeDriver() {
        try {
            getDriver().quit();
        } catch (Exception e) {
            System.out.println("Driver could not be closed!");
        }
    }
}
