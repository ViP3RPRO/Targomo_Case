package com.AppHooks;

import com.qa.factory.DriverFactory;
import com.qa.util.config_reader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {
    private WebDriver driver;
    Properties prop;

    @Before(order=0)
    public void getProperty(){
        config_reader configReader = new config_reader();
        prop = configReader.init_prop();
        System.out.println(prop);

    }

    @Before(order=1)
    public void launchBrowser(){
//        String browserName = prop.getProperty("browser");
        String browserName = "chrome";
        DriverFactory driverFactory = new DriverFactory();
        driver= driverFactory.init_driver(browserName);
    }

    @After(order=0)
    public void quitBrowser(){
        driver.quit();
    }

    @After(order=1)
    public void teardown(Scenario sc){
        if(sc.isFailed()){
            //taking screenshots if Scenario Fails
            String screenshotName = sc.getName().replaceAll(" ","_");
            byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            sc.attach(sourcePath,"image/png", screenshotName);
        }
    }


}
