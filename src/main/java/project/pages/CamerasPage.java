package project.pages;

import org.openqa.selenium.WebElement;
import project.pages.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class CamerasPage extends BasePage {

    public boolean hasTwoProductsOnPage() {
        return productsPrice().size() == 2;
    }

    public boolean hasCanon5dCorrectOldPrice() {
        boolean has5dCorrectOldPrice = false;

        List<ProductModel> products = productsPrice();
        for (ProductModel product : products) {
            String name = product.getProductName();
            if (name.equals("Canon EOS 5D")) {
                has5dCorrectOldPrice = 122.00f == product.getPriceOld();
            }
        }

        return has5dCorrectOldPrice;
    }

    public boolean hasD300CorrectExRate() {
        //init flag
        boolean hasD300CorrectExRate = false;

        //grab list with products
        List<ProductModel> products = productsPrice();
        //iterate list and find product by name
        for (ProductModel product : products) {
            String name = product.getProductName();
            if (name.equals("Nikon D300")) {
                //check tax
                hasD300CorrectExRate = 80.00f == product.getTax();
            }
        }
        //return result
        return hasD300CorrectExRate;
    }

    //grab all products from page
    private List<ProductModel> productsPrice() {
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
