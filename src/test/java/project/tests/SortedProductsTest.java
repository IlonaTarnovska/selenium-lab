package project.tests;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import project.pages.BasePage;
import project.pages.DesktopPage;
import project.pages.MainPage;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class SortedProductsTest extends BaseTest {

    //Test #3
    //
    // Go to the https://demo.opencart.com/
    // Hower over Desktops from top menu
    // Click on Show All Desktops
    // Select 'Name (A - Z)' from Sort by dropdown
    // Check that products were sorted correctly
    // Select 'Price (Low > High)' from Sort by dropdown
    // Check that products were sorted correctly
    //

    @Test()
    public void checkDesktopsPage() {
        MainPage mainPage = new MainPage();
        DesktopPage desktopPage = mainPage.clickDesktopsButton()
                .clickAllDesktopsButton();

        boolean isNameSorted = desktopPage.selectDropdownSort("Name (A - Z)")
                .checkProductNameSort();
        boolean isPriceSorted = desktopPage.selectDropdownSort("Price (Low > High)")
                .checkProductPriceSort();

        assertTrue(isNameSorted && isPriceSorted);
    }



}