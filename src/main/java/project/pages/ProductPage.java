package project.pages;

public class ProductPage extends BasePage {
    public float price(){
        String price = findElementByXpath("//span[@class='price-new']")
                .getText()
                .replaceAll("\\$", "")
                .replaceAll("€", "")
                .replaceAll("£", "");
        return Float.parseFloat(price);
    }
}
