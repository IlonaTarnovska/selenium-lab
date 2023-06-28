package project.tests;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.pages.BasePage;
import project.pages.BrandsPage;
import project.pages.MainPage;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BrandTest extends BaseTest {


    //     Test #0
    //
    // Go to the https://demo.opencart.com/
    // Click on 'Brands' at the bottom of the page
    // Check that following brands exists on page [Apple,Canon,Hewlett-Packard,HTC,Palm,Sony]

    @Test
    public void findBrands() {
        MainPage mainPage = new MainPage();
        List <String> actualBrandsList = mainPage
                .clickHandleBrandsButton()
                .getBrands();

        //Brands page
        List<String> expectedBrandsList = Arrays.asList("Apple", "Canon", "Hewlett-Packard", "HTC", "Palm", "Sony");

        Assertions.assertThat(actualBrandsList)
                .as("wrong name")
                .containsExactlyElementsOf(expectedBrandsList);
    }

}
