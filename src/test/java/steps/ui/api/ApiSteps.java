package api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;


import java.io.IOException;

public class ApiSteps {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpResponse httpresponse;
    private static final Logger logger = LogManager.getLogger(ApiSteps.class);

    @When("I seng get-request to  {string}")
    public void iSengGetRequestTo(String url) throws IOException {
        logger.info("sending request to {}", url);
        HttpGet httpget = new HttpGet(url);
        httpresponse = httpclient.execute(httpget);
    }

    @Then("I received response with Status code {int}")
    public void iReceivedResponseWithStatusCode(int expexcedCode) {
        logger.info("receiving response with code {}", httpresponse.getCode());
        Assert.assertEquals(expexcedCode, httpresponse.getCode());
        System.out.println(httpresponse.getCode());
    }
}
