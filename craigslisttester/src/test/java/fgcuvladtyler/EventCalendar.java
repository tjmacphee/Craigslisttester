package fgcuvladtyler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EventCalendar extends Setup {

  @Test(priority = 1)
    public void testEventCalendarLink() {
        driver.get().get("https://fortmyers.craigslist.org/");
        driver.get().findElement(By.xpath("//*[@id='calban']/a")).click();
        String url = driver.get().getCurrentUrl();
        System.out.println(url);
    }

    @Test(priority = 2)
  public void eventCalendarFavoriteButtonTest() {
     // driver.get().get("https://fortmyers.craigslist.org/search/eee#search=1~list~0~0");
      sleep(4000);
      driver.get().findElement(By.cssSelector("button.bd-button.cl-favorite-button")).click();
      sleep(4000);
      WebElement buttonElement = driver.get().findElement(By.cssSelector("button.bd-button.cl-favorite-button"));
      sleep(1500);

      // Assert that the button element is visible
      Assert.assertTrue(buttonElement.isDisplayed(), "Button is not visible");
    }

    @Test(priority = 3)
    public void testEventCalendarSearch() {

        driver.get().findElement(By.cssSelector("input[placeholder='search events']")).sendKeys("events");
        sleep(4000);
        driver.get().findElement(By.className("cl-exec-search")).click();
        Assert.assertTrue(driver.get().findElement(By.xpath("/html/body/div[1]/main/div[1]")).isDisplayed());
    }
    @Test(priority = 4)
    public void testEventsCheckBox() {

        sleep(2500);
        driver.get().findElement(By.name("srchType")).click();
        sleep(2500);
        driver.get().findElement(By.name("hasPic")).click();
        sleep(2500);
        driver.get().findElement(By.name("postedToday")).click();
        sleep(2500);
        driver.get().findElement(By.name("bundleDuplicates")).click();
      // Check if the checkbox is selected, if not, select it
        sleep(5000);

    }

}
