package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BrandsPage extends BasePage {

    public BrandsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='product-manufacturer']//div[@class='col-sm-3']/a")
    private List<WebElement>  brandLocator;

    public List<String> getBrands() {
        List<String> list = new ArrayList<>();
        List<WebElement> all =  brandLocator;
        for (WebElement element : all) {
            list.add(element.getText());
        }
        return list;
    }

}
