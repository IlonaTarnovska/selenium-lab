package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Forgotten Password']")
    public static WebElement forgottenPasswordButton;

    public ForgotPassPage forgottenPasswordButton() {
        makeClick(forgottenPasswordButton);
        return new ForgotPassPage();
    }

}
