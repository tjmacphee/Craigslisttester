package fgcuvladtyler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DiscussionForums extends Setup {

  @Test (priority = 1)
  public void testDiscussionForumsLink() {
    driver.get().get("https://fortmyers.craigslist.org/");
    driver.get().findElement(By.className("forums")).click();
    sleep(2000);
    String url = driver.get().getCurrentUrl();
    System.out.println(url);
  }

  @Test (priority = 2)
  public void testDiscussionForumsSearch() {
    driver.get().findElement(By.className("forumID")).click();
    WebElement selectElement = driver.get().findElement(By.tagName("select"));

    // Create a Select object
    Select select = new Select(selectElement);

    // Select option by value
    select.selectByValue("5500");

    WebElement selectedOption = select.getFirstSelectedOption();
    System.out.println("Selected Option Text: " + selectedOption.getText());
    driver.get().findElement(By.id("SQ")).sendKeys("Camera");
    WebElement searchButton = driver.get().findElement(By.xpath("//input[@type='submit' and @value='search']"));
    searchButton.click();

  }

  @Test (priority = 3)
  public void testDiscussionForumsPost() {

    driver.get().findElement(By.xpath("//a[@href='https://accounts.craigslist.org/forum/newhdl?rp=%2Fret%2FMToBQyokTXj-zlyiBhBnxhxVG-07r42ss4pLoxbbmtAGNFho9a2s4vBORm_BaPKn4Yv_Wc7n8diqoIXLgccOVxmtz3GMPyicqQfmCLLlZw&rt=F']")).click();

    driver.get().findElement(By.name("inputNewForumHandle")).sendKeys("CameraMan");
    driver.get().findElement(By.name("inputNewForumHandleRetype")).sendKeys("CameraMan");
    driver.get().findElement(By.name("memo")).sendKeys("Just a camera");
    sleep(10000);


  }
}