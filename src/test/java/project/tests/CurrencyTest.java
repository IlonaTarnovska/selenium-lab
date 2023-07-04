package project.tests;

import org.testng.annotations.Test;
import project.pages.MainPage;
import project.pages.ProductPage;
import project.pages.model.Currency;

import static org.junit.Assert.assertTrue;

public class CurrencyTest extends BaseTest {

    //     Test #4
    //
    // Go to the https://demo.opencart.com/
    // On the main page check that current currency is $ (change to $ if not)
    // Click on the Iphone
    // Check that price 123.20
    // Change currency to euro
    // Check that price 106.04
    // Change currency to Pound Sterling
    // Check that price 95.32

    @Test()
    public void checkCurrency() {
        MainPage mainPage = new MainPage();
        mainPage.currencySelector();

        boolean isUsd = mainPage.isCurrentCurrencyEquals(Currency.USD);
        //site has bug, currency shows as $ but selected is eur//
        if (!isUsd) {
            mainPage.changeCurrency(Currency.USD);
        }
        mainPage.changeCurrency(Currency.USD);

        ProductPage productPage = mainPage.openProductByName("iPhone");

        boolean isCorrectUsdPrice = productPage.checkPrice(123.20f);

        mainPage.changeCurrency(Currency.EUR);
        boolean isCorrectEuroPrice = productPage.checkPrice( 106.04f);

        mainPage.changeCurrency(Currency.GBP);
        boolean isCorrectPoundPrice = productPage.checkPrice( 95.32f);

       assertTrue(isCorrectUsdPrice && isCorrectEuroPrice && isCorrectPoundPrice);
    }
}

