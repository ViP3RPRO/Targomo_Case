package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver init_driver(String browser) {
        System.out.println("Browser value is: " + browser);
        if(browser.contentEquals("chrome")){
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
            System.out.println("Chrome is selected");
        }
        else if(browser.contentEquals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());

        }
        else if (browser.contentEquals("edge")){
            WebDriverManager.edgedriver().setup();
            tlDriver.set(new EdgeDriver());
        }
        else {
            System.out.println("Please provide correct browser value");
        }

//        getDriver().manage().deleteAllCookies();
//        getDriver().manage().window().maximize();
        return getDriver();

    }

    //This is used to get the driver with ThreadLocal
    public static synchronized WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        tlDriver.set(new ChromeDriver());
        return tlDriver.get();
    }

}
