package fgcuvladtyler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.testng.annotations.Test;

public class AboutSection extends Setup{

  /**
   * The Goal of this test class is to test the about section of the craigslist website.
   * The test will check the response code of the about section and the terms of use section.
   * The test suite is to ensure that key sections of the website are functioning properly.
   * */

  @Test(priority = 1)
  public void testAboutSection() throws IOException {
      driver.get("https://www.craigslist.org/about/");
    String currentUrl = driver.getCurrentUrl();

    URL url = new URL(currentUrl);

    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    int responseCode = connection.getResponseCode();

    assert(responseCode == HttpURLConnection.HTTP_OK);

  }
  @Test(priority = 2)
  public void testTermofUse() throws IOException {
    driver.get("https://www.craigslist.org/about/terms.of.use");
    String currentUrl = driver.getCurrentUrl();

    URL url = new URL(currentUrl);

    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    int responseCode = connection.getResponseCode();

    assert(responseCode == HttpURLConnection.HTTP_OK);
  }

  @Test(priority = 3)
  public void FAQ() throws IOException {
    driver.get("https://www.craigslist.org/about/help/faqs/");
    String currentUrl = driver.getCurrentUrl();

    URL url = new URL(currentUrl);

    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    int responseCode = connection.getResponseCode();

    assert(responseCode == HttpURLConnection.HTTP_OK);
  }

  @Test(priority = 4)
  public void testPrivacyPolicy() throws IOException {
    driver.get("https://www.craigslist.org/about/privacy.policy");
    String currentUrl = driver.getCurrentUrl();

    URL url = new URL(currentUrl);

    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    int responseCode = connection.getResponseCode();

    assert(responseCode == HttpURLConnection.HTTP_OK);
  }
  @Test(priority = 5)
  public void testHelp() throws IOException {
    driver.get("https://www.craigslist.org/about/help/");
    String currentUrl = driver.getCurrentUrl();

    URL url = new URL(currentUrl);

    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    int responseCode = connection.getResponseCode();

    assert(responseCode == HttpURLConnection.HTTP_OK);
  }


}
