package fgcuvladtyler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;

public class AboutSites extends Setup {

  @Test (priority = 1)
  public void testAboutCraigslistTitle() {
    driver.get("https://www.craigslist.org/about/sites");
    sleep(2000);
    String expectedTitle = "craigslist > sites";
    String actualTitle = driver.getTitle();
    Assert.assertEquals(actualTitle, expectedTitle, "The title does not match the expected title.");
  }

  @Test (priority = 2)
  public void testAboutCraigslistContent() {
    sleep(2000);
    driver.get("https://www.craigslist.org/about/sites");
    sleep(2000);
    String expectedContent = "craigslist sites worldwide";
    String actualContent = driver.findElement(By.xpath("//h1")).getText();
    Assert.assertEquals(actualContent, expectedContent, "The content does not match the expected content.");
  }


  @Test (priority = 3)
  public void testAboutCraigslistFooter() {
    driver.get("https://www.craigslist.org/about/sites");
    sleep(2000);
    WebElement footer = driver.findElement(By.tagName("footer"));
    java.util.List<WebElement> footerLinks = footer.findElements(By.tagName("a"));
    String[] expectedLinks = {
      "https://www.craigslist.org/about/help/",
      "https://www.craigslist.org/about/help/safety",
      "https://www.craigslist.org/about/privacy.policy",
      "https://www.craigslist.org/about/terms.of.use",
      "https://www.craigslist.org/about/",
      "https://www.craigslist.org/about/craigslist_app",
    };
    for (int i = 0; i < footerLinks.size(); i++) {
      WebElement link = footerLinks.get(i);
      String href = link.getAttribute("href");
      Assert.assertEquals(href, expectedLinks[i], "Footer link mismatch: " + href);
    }

  }

  @Test (priority = 4)
  public void mapTest() {
    driver.get("https://www.craigslist.org/about/sites");
    sleep(2000);
    WebElement mapElement = driver.findElement(By.xpath("//*[@id='map']"));
    Assert.assertTrue(mapElement.isDisplayed(), "The map is not displayed on the page.");
  }
}