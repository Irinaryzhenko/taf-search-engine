package po;

import org.openqa.selenium.WebDriver;



public class SearchResultPage {
    WebDriver driver;
    private String title = "//div[@class = 'kb0PBd cvP2Ce jGGQ5e ieodic']";
    private String url = "//div[@class = 'kb0PBd cvP2Ce jGGQ5e ieodic']";


    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "SearchResultPage{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
