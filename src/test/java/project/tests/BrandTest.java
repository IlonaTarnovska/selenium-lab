package project.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import project.pages.MainPage;

import java.util.Arrays;
import java.util.List;

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
