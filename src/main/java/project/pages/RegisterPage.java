package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {

    public RegisterPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    public static WebElement fNameElement;

    @FindBy(xpath = "//input[@id='input-lastname']")
    public static WebElement lNameElement;

    @FindBy(xpath = "//input[@id='input-email']")
    public static WebElement emailElement;

    @FindBy(xpath = "//input[@id='input-password']")
    public static WebElement passwordElement;

    @FindBy(xpath = "//input[@name='agree']")
    public static WebElement checkBoxElement;

    @FindBy(xpath = "//button[@type='submit']")
    public static WebElement continueButtonElement;


    public WelcomePage register(
            String firstName,
            String lastName,
            String email,
            String password
    ) {
        setAttribute(fNameElement, "value", firstName);
        setAttribute(lNameElement, "value", lastName);
        setAttribute(emailElement, "value", email);
        setAttribute(passwordElement, "value", password);
        setAttribute(checkBoxElement, "value", "1");

        makeClick(continueButtonElement);
        return new WelcomePage();
    }
}
