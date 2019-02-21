package Pages;

import Utils.Browser;
import Utils.CommonAssertions;
import Utils.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationPage {


    WebDriver driver;

    //public WebElement firstName;
    public RegistrationPage(WebDriver driver) {
        this.driver = Browser.driver;
    }

    private void clickElement(List<WebElement> elements, boolean[] conditions) {
        for (int i = 0; i <= conditions.length - 1; i++) {
            if (conditions[i]) {
                elements.get(i).click();
            }
        }
    }


    public static void checkPage() {
        CommonAssertions.verifyRegistrationPage("Register", "Registration page not loaded");
    }

    public void fillForm(User user) {
        type(getFirstName(), user.getFirstName());
        type(getLastName(), user.getLastName());
        type(getEmail(), user.getEmail());
        type(getTelephone(), user.getTelephone());
        type(getPassword(), user.getPassword());
        type(getConfirm(), user.getConfirmPassword());
        clickElement(getSubscribe(), user.getNewsletter());
        clickElement(getPrivacyPolicy(), user.getPrivacyPolicy());

    }

    public static boolean confirmRadioIsChecked() {
        boolean checked = Browser.driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).isSelected();
        return checked;
    }

    public static boolean confirmPrivacy() {
        boolean checked = Browser.driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).isSelected();
        return checked;
    }

    public WebElement getFirstName() {
        return this.driver.findElement(By.id("input-firstname"));
    }

    public WebElement getLastName() {
        return this.driver.findElement(By.id("input-lastname"));
    }

    public WebElement getEmail() {
        return this.driver.findElement((By.id("input-email")));
    }

    public WebElement getTelephone() {
        return this.driver.findElement(By.id("input-telephone"));
    }

    public WebElement getPassword() {
        return this.driver.findElement(By.id("input-password"));
    }

    public WebElement getConfirm() {
        return this.driver.findElement(By.id("input-confirm"));
    }

    public List<WebElement> getSubscribe() {
        return this.driver.findElements(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]"));
    }

    public List<WebElement> getPrivacyPolicy() {
        return this.driver.findElements(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
    }

    public WebElement getSubmitButton() {
        return this.driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
    }

    public WebElement getFirstNameWarning() {
        return this.driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div" +
                "/div"));
    }

    public WebElement getLastNameWarning() {
        return this.driver.findElement(By.xpath("//*[@id=\"account\"]/div" +
                "[3]/div/div"));
    }

    public WebElement getEmailWarning() {
        return this.driver.findElement(By.cssSelector("#account > div:nth-child(5) >" +
                " div > div"));
    }

    public WebElement getTelephoneWarning() {
        return this.driver.findElement(By.cssSelector("#account > div:nth-child" +
                "(6) > div > div"));
    }

    public WebElement getPasswordWarning() {
        return this.driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2" +
                "]/div[1]/div/div"));
    }

    public void type(WebElement element, String text) {
        element.sendKeys(text);
    }


}
