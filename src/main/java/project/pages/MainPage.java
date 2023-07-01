package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import project.pages.model.Currency;

public class MainPage extends BasePage {

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Brands']")
    public static WebElement handleBrandButton;

    @FindBy(xpath = "//*[text()='Desktops']")
    public static WebElement desktopsButton;

    @FindBy(xpath = "//div[@class='dropdown']/a")
    public static WebElement CurrencySelector;

    @FindBy(xpath = "//*[text()='Show All Desktops']")
    public static WebElement clickDesktopsButton;

    @FindBy(xpath = "//*[text()='My Account']")
    public static WebElement myAccountButton;

    @FindBy(xpath = "//*[text()='Register']")
    public static WebElement registerButton;

    @FindBy(xpath = "//div[@class='dropdown']/a/strong")
    public static WebElement currentCurrency;

    @FindBy(xpath = "//div[@class='dropdown']/a")
    public WebElement currencySelector;

    public BrandsPage clickHandleBrandsButton() {
        makeClick(handleBrandButton);
        return new BrandsPage();
    }

    public MainPage clickDesktopsButton() {
        desktopsButton.click();
        return this;
    }

    public DesktopPage clickAllDesktopsButton() {
        clickDesktopsButton.click();
        return new DesktopPage();
    }

    public MainPage currencySelector() {
        makeClick(currencySelector);
        return this;
    }

    public boolean isCurrentCurrencyEquals(Currency currency) {
        return currentCurrency.getText().equals(currency.sign());
    }

    public String currentCurrency() {
        return findElementByXpath("//div[@class='dropdown']/a/strong").getText();
    }

    public WebElement findCurrencyBy(Currency currency) {
        return findElementByXpath("//a[@href='" + currency.name() + "']");
    }

    public ProductPage openProductByName(String name) {
        WebElement product = findElementByXpath("//*[text()='" + name + "']");
        makeClick(product);
        return new ProductPage();
    }

    public WebElement camerasButton() {
        return findElementByXpath("//*[text()='Cameras']");
    }

    public MainPage clickAccountButton() {
        myAccountButton.click();
        return this;
    }

    public RegisterPage clickRegisterButton() {
        makeClick(registerButton);
        return new RegisterPage();
    }

    public void changeCurrency(Currency currency) {
        BasePage.makeClick(currencySelector);
        WebElement newCurrency = findCurrencyBy(currency);
        BasePage.makeClick(newCurrency);
    }
}
