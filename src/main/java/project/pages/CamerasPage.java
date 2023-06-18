package project.pages;

import org.openqa.selenium.WebElement;
import project.pages.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class CamerasPage extends BasePage {

    public List<ProductModel> productsPrice() {
        int productsCount = findElementsByXpath("//div[@id='product-list']/div").size();

        List<ProductModel> products = new ArrayList<>();
        for (int i = 1; i <= productsCount; i++) {
            products.add(new ProductModel(
                    price(i, "price-new"),
                    price(i, "price-old"),
                    price(i, "price-tax"),
                    productElement(i).getText()
            ));
        }

        return products;
    }

    private WebElement productElement(int position) {
        return findElementByXpath("//div[@class='col']["+ position +"]/form/div/div[@class='content']/div[@class='description']/h4/a");
    }

    private Float price(int position, String spanClass) {
        WebElement element;
        try {
            element = findElementByXpath("//div[@class='col']["+ position +"]/form/div/div[@class='content']/div[@class='description']/div[@class='price']/span[@class='"+ spanClass +"']");
        } catch (Exception e) {
            return 0f;
        }
        return Float.parseFloat(
                element.getText()
                .replaceAll("\\$", "")
                .replaceAll("€", "")
                .replaceAll("£", "")
                .replaceAll("Ex Tax: ", "")
        );
    }

}
