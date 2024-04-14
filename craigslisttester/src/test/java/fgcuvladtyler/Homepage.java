package fgcuvladtyler;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homepage extends Setup {

    @Test (priority = 2)
    public void verifyHomePageTitle() {
        sleep(1500);
        driver.get().get("https://fortmyers.craigslist.org/");
        sleep(1500);
        driver.get().findElement(By.xpath("//title[text()='craigslist: fort myers jobs, apartments, for sale, services, community, and events']"));
        String expectedTitle = "craigslist: fort myers jobs, apartments, for sale, services, community, and events";
        String actualTitle = driver.get().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "The title does not match the expected title.");


        // TODO: implement some kind of homepage test

    }
    @Test (priority = 1)
    public void verifyFooterLinks() {
       // driver.get().get("https://www.craigslist.com");
        sleep(1500);

        WebElement footer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("footer")));

        // Find all links within the footer
        List<WebElement> footerLinks = footer.findElements(By.tagName("a"));

        // Iterate through each footer link and verify it
        for (WebElement link : footerLinks) {
            String href = link.getAttribute("href");
            // Check if it's an absolute URL
            if (href != null && href.startsWith("http")) {
                // Print out the URL for debugging purposes
                System.out.println("Checking footer link: " + href);
        }
        }
        String[] expectedLinks = {
            "https://www.craigslist.org/about/help/",
            "https://www.craigslist.org/about/help/safety",
            "https://www.craigslist.org/about/privacy.policy",
            "https://www.craigslist.org/about/terms.of.use",
            "https://www.craigslist.org/about/",
            "https://www.craigslist.org/about/craigslist_app",
            "https://fortmyers.craigslist.org/sitemap.html"
        };
        for (int i = 0; i < footerLinks.size(); i++) {
            WebElement link = footerLinks.get(i);
            String href = link.getAttribute("href");
            Assert.assertEquals(href, expectedLinks[i], "Footer link mismatch: " + href);
        }

    }
    @Test(priority = 3)
    public void testLanguageLinksText() {
        // Navigate to the webpage you want to test
        driver.get().get("https://www.craigslist.com");

        sleep(4000);

        // Find the language dropdown menu
        WebElement langDropdown = driver.get().findElement(By.id("chlang"));
        sleep(2000);
        Select select = new Select(langDropdown);
        sleep(2000);
        java.util.List<WebElement> options = select.getOptions();
        sleep(2000);
        String[] expectedText = {
            "dansk",
            "deutsch",
            "english",
            "español",
            "français",
            "italiano",
            "português",
            "suomi",
            "svenska",
            "tiếng việt",
            "türkçe",
            "русский",
            "中文",
            "日本語",
            "한국말"
        };

        // Iterate through each option and verify the displayed text
        for (int i = 0; i < options.size(); i++) {
            WebElement option = options.get(i);
            String displayedText = option.getText();
            assert displayedText.equals(expectedText[i]) : "Language link text mismatch: " + displayedText;
        }
    }
    @Test (priority = 4)
    public void testLogo() {
        // Navigate to the webpage you want to tests
        // Find the logo element
        driver.get().get("https://www.craigslist.com");
        sleep(4000);
        WebElement logo = driver.get().findElement(By.id("logo"));

        // Get the anchor element within the logo
        WebElement anchor = logo.findElement(By.tagName("a"));

        // Get the value of the href attribute (logo link URL)
        String href = anchor.getAttribute("href");

        // Click on the logo to navigate to the URL
        anchor.click();
        String expectedURL = "https://www.craigslist.org/about/sites";
        // Verify that the current URL matches the expected logo link URL
        Assert.assertEquals(expectedURL, href, "Logo link doesn't work");

    }
}
