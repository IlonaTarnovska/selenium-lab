package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DesktopPage extends BasePage {

    public Select dropdownLimit() {
        return new Select(findElementByXpath("//*[@id='input-limit']"));
    }

    public WebElement dropdownLimitValue() {
        return findElementByXpath("//*[@id='input-limit']/option[@selected]");
    }

    public WebElement dropdownSort() {
        return findElementByXpath("//*[@id='input-sort']/option[@selected]");
    }

    public List<WebElement> products() {
        return findElementsByXpath("//div[@id='product-list']/*");
    }

    public WebElement elementWithText(String text) {
        return findElementByXpath("//*[text()='" + text + "']");
    }

}
