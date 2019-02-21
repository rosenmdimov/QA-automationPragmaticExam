package negative;

import Pages.RegistrationPage;
import Pages.ShopHomePage;
import Utils.Browser;
import Utils.CommonAssertions;
import Utils.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNegariveRegistration {
    @BeforeMethod
    public void openBrowser() {
        Browser.open("chrome");
    }//options: chrome, firefox, edge

    @AfterMethod
    public void tearDown() {
        Browser.shootDown();
    }

    @Test
    public void testPrivacyWarning() {
        ShopHomePage.goToPage("http://shop.pragmatic.bg/");
        ShopHomePage.goToRegistration();
        RegistrationPage registrationPage = new RegistrationPage(Browser.driver);
        User user = new User(""
                , ""
                , ""
                , ""
                , ""
                , ""
                , new boolean[]{true, false}
                , new boolean[]{false}
                , Browser.driver);
        registrationPage.fillForm(user);
        registrationPage.getSubmitButton().click();
        CommonAssertions.verifyPolicyWarning("You must agree", "Privacy policy is not egreed!");
    }

    @Test
    public void verifyFieldWarnings() {
        ShopHomePage.goToPage("http://shop.pragmatic.bg/");
        ShopHomePage.goToRegistration();
        RegistrationPage registrationPage = new RegistrationPage(Browser.driver);
        User user = new User(""
                , ""
                , ""
                , ""
                , ""
                , ""
                , new boolean[]{true, false}
                , new boolean[]{true}
                , Browser.driver);
        registrationPage.fillForm(user);
        registrationPage.getSubmitButton().click();
        CommonAssertions.verifyWarnings(registrationPage);

    }
}
