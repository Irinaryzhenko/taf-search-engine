package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Singleton;

public class SearchPage {
    public WebDriver driver;
    private String searchInputField = "//textarea[@name = 'q']";
    private String cookiesButton = "//div[@class = 'QS5gu sy4vM'][text()='Zaakceptuj wszystko']";

    public SearchPage() {
        driver = Singleton.getDriver();
    }

    public void acceptCookies() {
        WebElement cookiesButtonElement = driver.findElement(By.xpath(cookiesButton));
        cookiesButtonElement.click();
    }

    public String getSearchInputField() {
        return searchInputField;
    }
}
