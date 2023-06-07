package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    //protected WebDriver variable (only classes in same folder (pages) will get driver)
    protected static WebDriver driver;

    //set driver for base page
    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    //method for get driver from any page
    public static WebDriver getDriver() {
        return driver;
    }

    public static JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) driver;
    }

    public WebElement findElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public static void makeClick(WebElement element) {
        getJavascriptExecutor().executeScript("arguments[0].click();", element);
    }
}
