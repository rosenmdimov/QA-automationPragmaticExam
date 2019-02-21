package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class Browser {
    public static WebDriver driver;

    public static void open(String browserType) {
        String path = "src\\main\\resources\\";

        switch (browserType) {
            case "chrome":
                String chromePath = Paths.get(path + "chromedriver.exe").toString();
                System.setProperty("webdriver.chrome.driver", chromePath);
                driver = new ChromeDriver();
                break;
            case "firefox":
                String firefoxPath = Paths.get(path + "geckodriver.exe").toString();
                System.setProperty("webdriver.gecko.driver", firefoxPath);
                driver = new FirefoxDriver();
                break;
            case "edge":
                String edgePath = Paths.get(path + "MicrosoftWebDriver.exe").toString();
                System.setProperty("webdriver.edge.driver", edgePath);
                driver = new EdgeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public static void shootDown() {
        driver.quit();
    }
}
