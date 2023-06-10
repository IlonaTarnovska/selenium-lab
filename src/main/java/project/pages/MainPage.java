package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    public MainPage openMainPage() {
        getDriver().get("https://demo.opencart.com/");
        return this;
    }

    public WebElement handleBrandButton() {
        return findElementByXpath("//*[text()='Brands']");
    }

    public WebElement myAccountButton() {
        return findElementByXpath("//*[text()='My Account']");
    }

    public WebElement registerButton() {
        return findElementByXpath("//*[text()='Register']");
    }
}
