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
        mainPage.openMainPage();

        WebElement desktopsButton = mainPage.desktopsButton();
        BasePage.makeClick(desktopsButton);

        WebElement seeAllDesktopsButton = mainPage.seeAllDesktopsButton();
        BasePage.makeClick(seeAllDesktopsButton);

        DesktopPage desktopPage = new DesktopPage();
        desktopPage.dropdownSort()
                .selectByVisibleText("Name (A - Z)");

        List<String> productNames = desktopPage.productsNames();
        List<String> sortedNames = new ArrayList<>(productNames);
        Collections.sort(productNames, Collator.getInstance());
        boolean isNameSorted = areSortEquals(productNames, sortedNames);

        desktopPage.dropdownSort()
                .selectByVisibleText("Price (Low > High)");

        List<Float> productPrices = desktopPage.productsPrice();
        List<Float> sortedPrices = new ArrayList<>(productPrices);
        Collections.sort(sortedPrices);
        boolean isPriceSorted = areSortEquals(productPrices, sortedPrices);

        assertTrue(isNameSorted && isPriceSorted);
    }

    private <T> boolean areSortEquals(List<T> list1, List<T> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        boolean isSortEquals = true;
        for (int i = 0; i < list1.size(); i++) {
            if(!list1.get(i).equals(list2.get(i))) {
                isSortEquals = false;
                break;
            }
        }
        return isSortEquals;
    }

}