package project.tests;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import project.pages.MainPage;

import static org.testng.AssertJUnit.assertTrue;

public class ForgotPassTest extends BaseTest {

    // New Test #1.1
    //1. Click  MyAccount
    //2. Click Login
    //3. Click Forgotten Password
    //4. Fill email
    //5. Click Continue button
    //6. Check Alert message


    @Test
    public void forgotPassTest() {
        String expectedAlert = "Warning: The E-Mail Address was not found in our records!";

        MainPage mainPage = new MainPage();
        String alertText = mainPage.clickAccountButton()
                .clickLoginButton()
                .forgottenPasswordButton()
                .resetPass("tarnovska111@gmail.com")
                .checkAlert();

        Assertions.assertThat(alertText)
                .as("Expected message " + expectedAlert)
                .isEqualTo(expectedAlert);
    }
}