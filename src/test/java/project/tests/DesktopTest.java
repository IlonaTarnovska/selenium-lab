package project.tests;

import org.junit.Test;
import project.pages.DesktopPage;
import project.pages.MainPage;

import static org.junit.Assert.assertTrue;

public class DesktopTest extends BaseTest {

    //     Test #2
    //
    // Go to the https://demo.opencart.com/
    // Hower over Desktops from top menu
    // Click on Show All Desktops
    // Check that value in Show dropdown is 10
    // Check that value in Sort By is Default
    // Check that 10 products display on page
    // Select 25 from Show dropdown
    // Check that 12 products now dispayed
    // Check that text 'Showing 1 to 12 of 12 (1 Pages)' displays on the bottom of the page
    //

    @Test()
    public void checkDesktopsPage() {
        MainPage mainPage = new MainPage();
        DesktopPage desktopPage = mainPage.clickDesktopsButton()
                .clickAllDesktopsButton();

        boolean isLimit10 = desktopPage.checkDropdownLimitValue("10");
        boolean isSortDefault = desktopPage.checkDropdownSortValue("Default");
        boolean isProducts10 = desktopPage.productsCountEquals(10);

        boolean isProducts12 = desktopPage.selectDropdownLimit("25")
                .productsCountEquals(12);

        boolean hasElementWithText = desktopPage.hasElementWithText("Showing 1 to 12 of 12 (1 Pages)");

        assertTrue(isLimit10 && isSortDefault && isProducts10 && isProducts12 && hasElementWithText);
    }
}