package Pages;

import Utils.Browser;
import org.openqa.selenium.By;

public class ShopHomePage {
    public static void goToPage(String url) {
        Browser.driver.get(url);
    }

    public static void goToRegistration() {
        Browser.driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        Browser.driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
    }

    public static void goToLogin() {
        Browser.driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        Browser.driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
    }
}
