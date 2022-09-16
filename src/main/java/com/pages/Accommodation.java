package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//Step De
public class Accommodation {

    private WebDriver driver;

    //locators
    private By accommodationCheckBox = By.id("mat-checkbox-1-input");


    //Constructor of the Page
    public Accommodation(WebDriver driver) {
        this.driver=driver;
    }

    //page Actions
    public String getPageTitle(){
        return driver.getTitle();
    }

    public boolean isAccommodationCheckBoxExists(){
        return driver.findElement(accommodationCheckBox).isDisplayed();
    }

    public void clickOnAccommodation(){
        driver.findElement(accommodationCheckBox).click();

    }

    public boolean isAccommodationCheckBoxSelected(){
        return driver.findElement(accommodationCheckBox).isSelected();
    }


}
