package Pages;

import Utils.CommonAssertions;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void chеckRagistration() {
        CommonAssertions.verifySuccessfulRegistration("Congratulations!", "Registration is unsuccessful");
    }

    public String getLoginTitle() {
        return this.driver.getTitle();
    }
}
