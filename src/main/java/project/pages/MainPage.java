package project.pages;

import org.openqa.selenium.WebElement;
import project.pages.model.Currency;

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

    public WebElement desktopsButton() {
        return findElementByXpath("//*[text()='Desktops']");
    }

    public WebElement seeAllDesktopsButton() {
        return findElementByXpath("//*[text()='Show All Desktops']");
    }

    public WebElement currencySelector() {
        return findElementByXpath("//div[@class='dropdown']/a");
    }

    public String currentCurrency() {
        return findElementByXpath("//div[@class='dropdown']/a/strong").getText();
    }

    public WebElement findCurrencyBy(Currency currency) {
        return findElementByXpath("//a[@href='" + currency.name() + "']");
    }

    public WebElement findProductByName(String name) {
        return findElementByXpath("//*[text()='" + name + "']");
    }

    public WebElement camerasButton() {
        return findElementByXpath("//*[text()='Cameras']");
    }

}
