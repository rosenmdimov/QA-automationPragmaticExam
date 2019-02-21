package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoginTitle() {
        return this.driver.getTitle();
    }

    public WebElement getUserName() {
        return driver.findElement(By.id("input-email"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("input-password"));
    }

    public WebElement getSubmit() {
        return driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
    }

    public void login(String username, String password) {
        getUserName().sendKeys(username);
        getPassword().sendKeys(password);
        getSubmit().click();
    }
}
