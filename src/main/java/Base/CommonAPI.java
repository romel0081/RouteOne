package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonAPI {
    public WebDriver driver = null;
    public Properties properties = null;

    public WebDriver InitializeBrowser() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\saam1\\IdeaProjects\\RouteOne\\src\\test\\resources\\testProp.properties");
        properties=new Properties();
        properties.load(fileInputStream);


        String browserName = properties.getProperty("Browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("InternetExplorer")) {
            System.setProperty("webdriver.ie.driver", "Drivers\\MicrosoftWebDriver.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));

        return driver;
    }

    public void closeBrowser(){
        driver.manage().deleteAllCookies();
        driver.close();
        driver=null;

    }
public WebDriverWait webDriverWait(){
        WebDriverWait webDriverWait=new WebDriverWait(driver,10);
        return webDriverWait;
}
}
