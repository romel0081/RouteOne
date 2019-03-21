package stepDefinitions;

import Base.CommonAPI;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pageObjects.CareersPage;
import pageObjects.HomePage;

import javax.swing.*;
import java.io.IOException;

public class MyStepdefs extends CommonAPI {
    @Before
    public void initialize() throws IOException {
        InitializeBrowser();

    }

    @Given("^user is at Route one Homepage$")
    public void userIsAtRouteOneHomepage() {
        HomePage homePage = new HomePage(driver);
        boolean logo = homePage.getLogo().isDisplayed();
        Assert.assertEquals(true, logo);
    }

    @When("^user mouse over to About Us tab$")
    public void userMouseOverToAboutUsTab() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(homePage.getAboutUs()).build().perform();

    }

    @And("^clicks on careers$")
    public void clicksOnCareers() {
        HomePage homePage = new HomePage(driver);
        WebElement career = webDriverWait().until(ExpectedConditions.visibilityOf(homePage.getCareers()));
        career.click();

    }

    @And("^clicks on search by location$")
    public void clicksOnSearchByLocation() throws InterruptedException {
        CareersPage careersPage = new CareersPage(driver);
        driver.switchTo().frame(careersPage.getIframe());
        careersPage.getSearchByLocation().click();
    }

    @And("^selects U S Office$")
    public void selectsUSOffice() {
        CareersPage careersPage = new CareersPage(driver);
        Select select = new Select(careersPage.getSearchByLocation());
        select.selectByVisibleText("U.S. Office");
    }

    @And("^Enters test in the search by title text box$")
    public void entersTestInTheSearchByTitleTextBox() {
    CareersPage careersPage=new CareersPage(driver);
    careersPage.getSearchBox().sendKeys("test");
    }


    @Then("^Software Developer In Test is present in the career page$")
    public void softwareDeveloperInTestIsPresentInTheCareerPage() {
        CareersPage careersPage=new CareersPage(driver);
        String jobTitle= careersPage.getJobTitle().getText();
        String ExpectedTitle="Software Developer in Test";

        Assert.assertEquals(jobTitle,ExpectedTitle);



    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
