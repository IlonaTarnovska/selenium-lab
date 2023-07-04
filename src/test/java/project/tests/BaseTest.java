package project.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import project.pages.BasePage;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        //creating new instance of wed driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("https://demo.opencart.com/");


        //set driver into base page
        BasePage.setDriver(driver);
        //get driver from base page and maximize window
        BasePage.getDriver().manage().window().maximize();
    }

    @AfterClass
    public void closeDriver() {
        //get driver from base page and quite it
        BasePage.getDriver().quit();
    }

}
