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
        mainPage.openMainPage();

        WebElement cameras = mainPage.camerasButton();
        BasePage.makeClick(cameras);

        CamerasPage camerasPage = new CamerasPage();
        List<ProductModel> products = camerasPage.productsPrice();

        boolean hasTwoProducts = products.size() == 2;

        boolean has5dCorrectOldPrice = false;
        boolean has5dCorrectNewPrice = false;
        boolean hasD300CorrectExtRate = false;

        for (ProductModel product: products) {
            String name = product.getProductName();
            if (name.equals("Canon EOS 5D")) {
                has5dCorrectOldPrice = 122.00f == product.getPriceOld();
                has5dCorrectNewPrice = 98.00f == product.getPriceNew();
            } else if (name.equals("Nikon D300")) {
                hasD300CorrectExtRate = 80f == product.getTax();
            }
        }

        assertTrue(hasTwoProducts && has5dCorrectOldPrice && has5dCorrectNewPrice && hasD300CorrectExtRate);
    }
}
