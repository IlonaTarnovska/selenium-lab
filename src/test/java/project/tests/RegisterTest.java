package project.tests;

import org.junit.Test;
import project.pages.MainPage;

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

        boolean isWelcome = mainPage.clickAccountButton()
                .clickRegisterButton()
                .register("Ilona", "Tarnovska", "tarnovska@gmail.com", "5387A037h2")
                .checkWelcomePage();

        assertTrue(isWelcome);
    }

}
