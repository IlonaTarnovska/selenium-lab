package project.pages;

import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {


    public void register(
            String firstName,
            String lastName,
            String email,
            String password
    ) {
        WebElement fNameElement = findElementByXpath("//input[@id='input-firstname']");
        setAttribute(fNameElement, "value", firstName);

        WebElement lNameElement = findElementByXpath("//input[@id='input-lastname']");
        setAttribute(lNameElement, "value", lastName);

        WebElement emailElement = findElementByXpath("//input[@id='input-email']");
        setAttribute(emailElement, "value", email);

        WebElement passwordElement = findElementByXpath("//input[@id='input-password']");
        setAttribute(passwordElement, "value", password);

        WebElement checkBoxElement = findElementByXpath("//input[@name='agree']");
        setAttribute(checkBoxElement, "value", "1");

        WebElement continueButtonElement = findElementByXpath("//button[@type='submit']");

        makeClick(continueButtonElement);

    }

}
