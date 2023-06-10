package project.pages;

public class WelcomePage extends BasePage {
    public boolean checkWelcomePage() {
        try {
            findElementByXpath("//*[text()='Welcome']");
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
