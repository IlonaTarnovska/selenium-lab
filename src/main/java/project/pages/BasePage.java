package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

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

    public List<WebElement> findElementsByXpath(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    public static void makeClick(WebElement element) {
        getJavascriptExecutor().executeScript("arguments[0].click();", element);
    }

    public void setAttribute(WebElement element, String attName, String attValue) {
        getJavascriptExecutor().executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                element, attName, attValue);
    }

}
