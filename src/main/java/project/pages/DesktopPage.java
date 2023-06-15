package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DesktopPage extends BasePage {

    public Select dropdownLimit() {
        return new Select(findElementByXpath("//*[@id='input-limit']"));
    }

    public WebElement dropdownLimitValue() {
        return findElementByXpath("//*[@id='input-limit']/option[@selected]");
    }

    public Select dropdownSort() {
        return new Select(findElementByXpath("//*[@id='input-sort']"));}

    public WebElement dropdownSortValue() {
        return findElementByXpath("//*[@id='input-sort']/option[@selected]");
    }

    public List<WebElement> products() {
        return findElementsByXpath("//div[@id='product-list']/div");
    }

    public WebElement elementWithText(String text) {
        return findElementByXpath("//*[text()='" + text + "']");
    }

    public List<String> productsNames() {
        List<WebElement> products = findElementsByXpath("//div[contains(@class, 'description')]/h4/a");
        List<String> productNames = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            productNames.add(products.get(i).getText());
        }
        return productNames;
    }

    public List<Float> productsPrice() {
        List<WebElement> priceElements = findElementsByXpath("//div[contains(@class, 'description')]/div/span[@class='price-new']");
        List<Float> productPrices = new ArrayList<>();
        for (int i = 0; i < priceElements.size(); i++) {
            String price = priceElements.get(i).getText()
                    .substring(1)
                    .replaceAll(",", "");
            productPrices.add(Float.parseFloat(price));
        }
        return productPrices;
    }
}
