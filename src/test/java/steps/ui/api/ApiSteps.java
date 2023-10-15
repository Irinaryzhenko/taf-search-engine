package steps.ui.api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import java.io.IOException;

public class ApiSteps {
    CloseableHttpClient httpclient = HttpClients.createDefault();
   CloseableHttpResponse httpResponse;
    private static final Logger logger = LogManager.getLogger(ApiSteps.class);

    @When("I seng get-request to  {string}")
    public void iSengGetRequestTo(String url) throws IOException {
        logger.info("sending request to {}", url);
        HttpGet httpget = new HttpGet(url);
        httpResponse = httpclient.execute(httpget);
    }

    @Then("I received response with Status code {int}")
    public void iReceivedResponseWithStatusCode(int expexcedCode) {
        logger.info("receiving response with code {}", httpResponse.getCode());
        Assert.assertEquals(expexcedCode, httpResponse.getCode());
        System.out.println(httpResponse.getCode());
    }

    @Then("Response contains {string}")
    public void responseContains(String expectedResponseBodyText) throws IOException, ParseException {
        String actualResponseBody = EntityUtils.toString(httpResponse.getEntity());
        logger.info("Loading response: {}", actualResponseBody);
        Assert.assertTrue(actualResponseBody.contains(expectedResponseBodyText));
    }
}
