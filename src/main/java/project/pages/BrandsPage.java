package project.pages;

import java.util.List;

public class BrandsPage extends BasePage {

    public boolean areBrandsPresent(List<String> brands) {
        for (String brand : brands) {
            try {
                findElementByXpath("//*[text()='" + brand + "']");
            } catch (Exception e) {
                System.out.println("Brand " + brand + " not found");
                return false;
            }
        }
        return true;
    }
}
