package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public WebDriver driver = null;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By Logo = By.xpath("//*[@id='logo']/img");
    By aboutUs = By.cssSelector(".dropdown-toggle");
    By careers = By.xpath(".//*[@id='tb-megamenu-column-2']/div/ul/li[3]/a");

    public WebElement getLogo() {
        return driver.findElement(Logo);
    }


    public WebElement getAboutUs() {
        return driver.findElement(aboutUs);
    }

    public WebElement getCareers() {
        return driver.findElement(careers);
    }


}
