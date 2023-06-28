package project.tests;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import project.pages.BasePage;
import project.pages.model.Currency;
import project.pages.MainPage;
import project.pages.ProductPage;

import static org.junit.Assert.assertTrue;

public class CurrencyTest extends BaseTest {

    //     Test #4
    //
    // Go to the https://demo.opencart.com/
    // On the main page check that current currency is $ (change to $ id not)
    // Click on the Iphone
    // Check that price 123.20
    // Change currency to euro
    // Check that price 106.04
    // Change currency to Pound Sterling
    // Check that price 95.32

    @Test()
    public void checkCurrency() {
        MainPage mainPage = new MainPage();
        mainPage.CurrencySelector();

        String currentCurrency = mainPage.currentCurrency();
        //site has bug, currency shows as $ but selected is eur//
        if (!currentCurrency.equals("$")) {
            changeCurrency(mainPage, Currency.USD);
        }
        changeCurrency(mainPage, Currency.USD);

        WebElement iPhone = mainPage.findProductByName("iPhone");
        BasePage.makeClick(iPhone);

        ProductPage productPage = new ProductPage();

        //check usd price
        boolean isCorrectUsdPrice = 123.20f == productPage.price();

        //check eur price
        changeCurrency(mainPage, Currency.EUR);
        boolean isCorrectEuroPrice = 106.04f == productPage.price();

        //check pound price
        changeCurrency(mainPage, Currency.GBP);
        boolean isCorrectPoundPrice = 95.32f == productPage.price();

        assertTrue(isCorrectUsdPrice && isCorrectEuroPrice && isCorrectPoundPrice);
    }

    private void changeCurrency(MainPage mainPage, Currency currency) {
        WebElement currencySelector = mainPage.currencySelector;
        BasePage.makeClick(currencySelector);
        WebElement newCurrency = mainPage.findCurrencyBy(currency);
        BasePage.makeClick(newCurrency);
    }

}

