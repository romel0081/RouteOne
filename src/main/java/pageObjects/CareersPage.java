package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CareersPage {
    public WebDriver driver = null;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
    }

    By searchByLocation = By.xpath(".//*[@id='ddlLocations']");
    By iframe = By.tagName("iframe");

    By searchBox = By.cssSelector("#txtSearch");
    By jobTitle = By.cssSelector(".JobTitle");

    public WebElement getSearchByLocation() {
        return driver.findElement(searchByLocation);
    }

    public WebElement getIframe() {
        return driver.findElement(iframe);
    }

    public WebElement getSearchBox() {
        return driver.findElement(searchBox);
    }

    public WebElement getJobTitle() {
        return driver.findElement(jobTitle);
    }
}
