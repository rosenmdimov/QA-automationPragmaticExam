package Utils;

import Pages.AccountPage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CommonAssertions {
    public static void verifyTitle(java.lang.String expected, java.lang.String errorMessage) {
        String actualTitle = Browser.driver.getTitle();
        Assert.assertEquals(actualTitle, expected, errorMessage);
    }

    public static void verifyRegistrationPage(String register, String registration_page_not_loaded) {
    }

    public static void verifySuccessfulRegistration(String expectedMessage, String errorMessage) {
        String actualMessage = Browser.driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    public static void verifySubscribeIsChecked(boolean expected, String radio_button_is_not_checked) {
        boolean actual = RegistrationPage.confirmRadioIsChecked();
        Assert.assertTrue(actual);
    }

    public static void verifyPolicyIsChecked(boolean checked, String errorMessage) {
        boolean actual = RegistrationPage.confirmPrivacy();
        Assert.assertTrue(actual);
    }

    public static void verifyPolicyWarning(String expected, String errorMessage) {
        String actualMessage = Browser.driver.findElement(By.cssSelector("#account-register > div.alert.alert-danger" +
                ".alert-dismissible")).getText();
        Assert.assertTrue(actualMessage.contains(expected));
    }

    public static void verifyWarnings(RegistrationPage registrationPage) {
        Assert.assertEquals(registrationPage.getFirstNameWarning().getText(), "First Name must be between 1 and 32 " +
                "characters!", "First name warning is not proper");
        Assert.assertEquals(registrationPage.getLastNameWarning().getText(), "Last Name must be between 1 and 32 " +
                "characters!", "Last name warning is not proper");
        Assert.assertEquals(registrationPage.getEmailWarning().getText(), "E-Mail Address does not appear to be " +
                "valid!", "E-mail warning is not proper");
        Assert.assertEquals(registrationPage.getTelephoneWarning().getText(), "Telephone must be between 3 and 32 " +
                "characters!", "Telephone warning is not proper");
        Assert.assertEquals(registrationPage.getPasswordWarning().getText(), "Password must be between 4 and 20 " +
                "characters!", "Password warning is not proper");

    }


    public static void verifyLoginPageIsLoaded(LoginPage loginpage) {
        Assert.assertEquals(loginpage.getLoginTitle(), "Account Login", "Login page is not loaded");
    }

    public static void verifyLogin(AccountPage accountPage) {
        Assert.assertEquals(accountPage.getLoginTitle(), "My Account", "Unsuccessful login");
    }
}
