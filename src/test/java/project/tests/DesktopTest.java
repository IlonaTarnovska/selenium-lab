package project.tests;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import project.pages.BasePage;
import project.pages.DesktopPage;
import project.pages.MainPage;

import java.util.List;

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
        mainPage.openMainPage();

        WebElement desktopsButton =  mainPage.desktopsButton();
        BasePage.makeClick(desktopsButton);

        WebElement seeAllDesktopsButton =  mainPage.seeAllDesktopsButton();
        BasePage.makeClick(seeAllDesktopsButton);

        DesktopPage desktopPage = new DesktopPage();

        WebElement dropdownLimitSelected = desktopPage.dropdownLimitValue();
        String limitValue = dropdownLimitSelected.getText();
        boolean isLimit10 = limitValue.equals("10");

        WebElement dropdownSort = desktopPage.dropdownSortValue();
        String sortValue = dropdownSort.getText();
        boolean isSortDefault = sortValue.equals("Default");

        List<WebElement> products = desktopPage.products();
        boolean isProducts10 = products.size() == 10;

        Select dropdownLimit = desktopPage.dropdownLimit();
        dropdownLimit.selectByVisibleText("25");

        products = desktopPage.products();
        boolean isProducts12 = products.size() == 12;

        boolean hasElementWithText = false;
        try {
            desktopPage.elementWithText("Showing 1 to 12 of 12 (1 Pages)");
            hasElementWithText = true;
        } catch (Exception e) {}


        assertTrue(isLimit10 && isSortDefault && isProducts10 && isProducts12 && hasElementWithText);
    }

}
