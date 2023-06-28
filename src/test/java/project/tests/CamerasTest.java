package project.tests;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import project.pages.BasePage;
import project.pages.CamerasPage;
import project.pages.MainPage;
import project.pages.model.ProductModel;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class CamerasTest extends BaseTest {

    //     Test #5
    //
    // Go to the https://demo.opencart.com/
    // Click on the Cameras
    // Check that 2 cameras exist on page
    // Check that Canon EOS 5D has old price 122.00
    // Check that Canon EOS 5D has new price 98.00
    // Check that Nikon D300 has ex.rate 80.00
    //

    @Test
    public void checkCameraPrice() {
        MainPage mainPage = new MainPage();
        mainPage.clickDesktopsButton();

        WebElement cameras = mainPage.camerasButton();
        BasePage.makeClick(cameras);

        CamerasPage camerasPage = new CamerasPage();
        boolean hasTwoProducts = camerasPage.hasTwoProductsOnPage();
        boolean has5dCorrectOldPrice = camerasPage.hasCanon5dCorrectOldPrice();
        boolean hasD300CorrectExRate = camerasPage.hasD300CorrectExRate();

        assertTrue(hasTwoProducts && has5dCorrectOldPrice && hasD300CorrectExRate);
    }
}
