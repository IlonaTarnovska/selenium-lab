package project.tests;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import project.pages.BasePage;
import project.pages.MainPage;
import project.pages.RegisterPage;
import project.pages.WelcomePage;

import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest {

    //     Test #1
    //
    // Go to the https://demo.opencart.com/
    // Click on 'My account' icon
    // Click on 'Register' button
    // Fill form with valid values
    // Check that you was redirected to new page with title 'Welcome'

    @Test
    public void registrationTest() {
        MainPage mainPage = new MainPage();
        mainPage.openMainPage();

        WebElement myAccountButton = mainPage.myAccountButton();
        BasePage.makeClick(myAccountButton);

        WebElement registerButton = mainPage.registerButton();
        BasePage.makeClick(registerButton);

        RegisterPage registerPage = new RegisterPage();
        registerPage.register(
                "Ilona",
                "Tarnovska",
                "tarnovska@gmail.com",
                "5387A037h2"
        );

        WelcomePage welcomePage = new WelcomePage();
        boolean isWelcome = welcomePage.checkWelcomePage();
        assertTrue(isWelcome);
    }

}
