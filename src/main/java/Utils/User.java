package Utils;

import org.openqa.selenium.WebDriver;

public class User {
    public String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String password;
    private String confirmPassword;
    private boolean[] newsletter;
    private boolean[] privacyPolicy;
    private WebDriver driver;

    public WebDriver getSubmitButton() {
        return submitButton;
    }

    private WebDriver submitButton;


    public User(String firstName, String lastName, String email, String telephone, String password,
                String confirmPassword, boolean[] newsletter, boolean[] privacyPolicy, WebDriver driver) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.newsletter = newsletter;
        this.privacyPolicy = privacyPolicy;
        this.driver = driver;

    }

    //public User(String firstName, String lastName, String email, String telephone, String password,
    //String confirmPassword,
    //            boolean newsletter,
    //            boolean privacyPolicy) {
    //}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean[] getNewsletter() {
        return this.newsletter = newsletter;
    }

    public void setNewsletter(boolean[] newsletter) {
        this.newsletter = newsletter;
    }

    public boolean[] getPrivacyPolicy() {
        return privacyPolicy;
    }

    public void setPrivacyPolicy(boolean[] privacyPolicy) {
        this.privacyPolicy = privacyPolicy;
    }

}
