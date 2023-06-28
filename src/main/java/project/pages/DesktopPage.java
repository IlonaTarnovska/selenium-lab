package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends BasePage {

    public DesktopPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//select[@id='input-limit']")
    public static WebElement dropdownLimit;

    @FindBy(xpath = "//*[@id='input-limit']/option[@selected]")
    public static WebElement dropdownLimitValue;

    @FindBy(xpath = "//select[@id='input-sort']")
    public static WebElement dropdownSort;

    @FindBy(xpath = "//*[@id='input-sort']/option[@selected]")
    public static WebElement dropdownSortValue;

    @FindBy(xpath = "//div[@id='product-list']/div")
    public static List<WebElement> products;


    public boolean checkDropdownLimitValue(String expected) {
        return dropdownLimitValue.getText().equals(expected);
    }

    public DesktopPage selectDropdownLimit(String value){
        Select select = new Select(dropdownLimit);
        select.selectByVisibleText(value);
        return this;
    }

    public boolean checkDropdownSortValue(String expected) {
        return dropdownSortValue.getText().equals(expected);
    }

    public DesktopPage selectDropdownSort(String value){
        Select select = new Select(dropdownSort);
        select.selectByVisibleText(value);
        return this;
    }

    public boolean productsCountEquals(int expected) {
        return products.size() == expected;
    }

    public boolean hasElementWithText(String text) {
        boolean hasElementWithText = false;
        try {
            findElementByXpath("//*[text()='" + text + "']");
            hasElementWithText = true;
        } catch (Exception e) {
        }
        return hasElementWithText;
    }

    public boolean checkProductNameSort() {
        List<String> productNames = productsNames();
        List<String> sortedNames = new ArrayList<>(productNames);
        Collections.sort(productNames, Collator.getInstance());
        return areSortEquals(productNames, sortedNames);
    }

    public boolean checkProductPriceSort() {
        List<Float> productPrices = productsPrice();
        List<Float> sortedPrices = new ArrayList<>(productPrices);
        Collections.sort(sortedPrices);
        return areSortEquals(productPrices, sortedPrices);
    }

    private List<String> productsNames() {
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
