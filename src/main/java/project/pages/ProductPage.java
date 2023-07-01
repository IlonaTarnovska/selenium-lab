package project.pages;

public class ProductPage extends BasePage {

    public boolean checkPrice(float expected){
        String price = findElementByXpath("//span[@class='price-new']")
                .getText()
                .replaceAll("\\$", "")
                .replaceAll("€", "")
                .replaceAll("£", "");
        return Float.parseFloat(price) == expected;
    }

}
