package positive;

import Pages.AccountPage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import Pages.ShopHomePage;
import Utils.Browser;
import Utils.CommonAssertions;
import Utils.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class TestRegistrationUser {
    @BeforeMethod
    public void openBrowser() {
        Browser.open("chrome");
    }//options: chrome, firefox, edge

    @AfterMethod
    public void tearDown() {
        Browser.shootDown();
    }

    @Test

    public void loadShopHomePage() {
        ShopHomePage.goToPage("http://shop.pragmatic.bg/");
        CommonAssertions.verifyTitle("Pragmatic Test Store", "The title doesn't match");
    }

    @Test
    public void goToRegPage() {
        ShopHomePage.goToPage("http://shop.pragmatic.bg/");
        ShopHomePage.goToRegistration();
        RegistrationPage.checkPage();
    }

    @Test
    public void registerUser() {
        ShopHomePage.goToPage("http://shop.pragmatic.bg/");
        ShopHomePage.goToRegistration();
        RegistrationPage registrationPage = new RegistrationPage(Browser.driver);
        User user = new User("Kiro"
                , "Peshev"
                , "kiro" + new Random().nextInt(500) + "@peshev.com"
                , "0888888"
                , "parola"
                , "parola"
                , new boolean[]{true, false}
                , new boolean[]{true}
                , Browser.driver);
        registrationPage.fillForm(user);
        CommonAssertions.verifySubscribeIsChecked(true, "Radio button is not checked");
        CommonAssertions.verifyPolicyIsChecked(true, "Privacy policy is not checked");
        registrationPage.getSubmitButton().click();
        AccountPage.chеckRagistration();
    }

    @Test
    public void loginTest() {
        ShopHomePage.goToPage("http://shop.pragmatic.bg/");
        ShopHomePage.goToLogin();
        AccountPage accountPage = new AccountPage(Browser.driver);
        LoginPage loginpage = new LoginPage(Browser.driver);
        CommonAssertions.verifyLoginPageIsLoaded(loginpage);
        loginpage.login("Kiro@peshev.com", "parola");
        CommonAssertions.verifyLogin(accountPage);
    }

}
