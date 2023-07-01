package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPassPage extends BasePage {

    public ForgotPassPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    public static WebElement emailElement;

    @FindBy(xpath = "//button[@type='submit']")
    public static WebElement continueButtonElement;

    public ForgotPassPage resetPass(String email) {
        setAttribute(emailElement, "value", email);

        makeClick(continueButtonElement);
        return this;
    }

    public String checkAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 15L);
        By xpath = By.xpath("//*[@class='alert alert-danger alert-dismissible']");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));

        return element.getText();
    }
}
