package com.google.search.steps;

import driver.Singleton;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import po.SearchPage;
import po.SearchResultPage;

import java.util.concurrent.TimeUnit;

public class UiSteps {
    private static final Logger logger = LogManager.getLogger(UiSteps.class);
    WebDriver driver;

    @Given("Open the website")
    public void openTheWebsite() {
        logger.info("Opening the website");
        driver = Singleton.getDriver();
        SearchPage searchPage = new SearchPage();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       try {
           searchPage.acceptCookies();
       } catch (Exception e) {};
    }

    @When("I enter {string} into the search field")
    public void iEnterIntoTheSearchField(String searchText) {
        SearchPage searchPage = new SearchPage();
        logger.info("Entering the text: {}", searchText);
        WebElement searchField = driver.findElement(By.xpath(searchPage.getSearchInputField()));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value = arguments[1];", searchField, searchText);
    }

    @When("I submit the search")
    public void iSubmitTheSearch() {
        logger.info("Clicking on the Enter button");
        SearchPage searchPage = new SearchPage();
        WebElement searchField = driver.findElement(By.xpath(searchPage.getSearchInputField()));
        searchField.submit();
    }
    @Then("I should see search results contains {string}  and {string}")
    public void iShouldSeeSearchResultsContains(String expectedTitle, String expectedUrl) {
        logger.info("Checking result for title: {} and url: {}", expectedTitle, expectedUrl);
//            List<WebElement> results = driver.findElements(By.xpath("//div[@class = 'srKDX cvP2Ce']"));
//            WebElement nameElement;
//            String name;
//            int index = 0;
//            String actualText = "";
//            for (int i = 0; i < results.size(); i++) {
//                nameElement = results.get(i).findElement(By.xpath(".//a[@jsname='UWckNb']"));
//                name = nameElement.getText();
//                if (name.contains(expectedTitle)) {
//                    index= i;
//                    actualText = name;
//                }
//            }
//            System.out.println(index);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        WebElement linkElement = results.get(index).findElement(By.xpath(".//div[@class = 'srKDX cvP2Ce']//cite"));
//            String actualLink = linkElement.getAttribute("href");
//        Assert.assertEquals(expectedTitle, actualText);
//        Assert.assertEquals(expectedUrl, actualLink);
//
//        }
//        System.out.println(expectedUrl);
//        System.out.println(expectedTitle);
        SearchResultPage searchResultPage = new SearchResultPage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualTitle = driver.findElement(By.xpath(searchResultPage.getTitle())).getText();
        String actualUrl = driver.findElement(By.xpath(searchResultPage.getUrl())).getText();
        Assertions.assertTrue(actualTitle.contains(expectedTitle));
        Assertions.assertTrue(actualUrl.contains(expectedUrl));
    }

    @After
    public void iCloseBrowser() {
        Singleton.quitDriver();
    }
}

