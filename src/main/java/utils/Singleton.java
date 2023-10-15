package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Singleton {
    private static WebDriver driver;

    public Singleton() {
    }
    public static WebDriver getDriver(){
        if(driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.google.com/");
        } return driver;
    }
    public static  void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
