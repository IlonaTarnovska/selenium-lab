package project.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.pages.BasePage;

public class BaseTest {

    @Before
    public void setUp() {
        //creating new instance of wed driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //set driver into base page
        BasePage.setDriver(driver);
        //get driver from base page and maximize window
        BasePage.getDriver().manage().window().maximize();
    }

    @After
    public void closeDriver() {
        //get driver from base page and quite it
        BasePage.getDriver().quit();
    }

}
