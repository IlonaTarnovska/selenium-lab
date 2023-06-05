package project.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.pages.BasePage;
import project.pages.MainPage;

import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import java.util.List;

public class BrandTest extends BaseTest {

    private MainPage mainPage;

    @Test
    public void findBrands() {
        mainPage = new MainPage();
        mainPage.openMainPage();

        WebDriver driver = BasePage.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By brandsBy = By.xpath("//*[text()='Brands']");


        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement button = driver.findElement(brandsBy);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(); window.scrollBy(0, 200);", button);

        WebElement brandsButton = wait.until(ExpectedConditions.visibilityOf(button));
        brandsButton.click();

//        List<String> brands = Arrays.asList("Apple", "Canon", "Hewlett-Packard", "HTC", "Palm", "Sony");
//        for (String brand : brands) {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + brand + "']")));
//        }

    }

}
