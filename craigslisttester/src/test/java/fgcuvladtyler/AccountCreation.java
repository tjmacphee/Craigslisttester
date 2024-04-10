package fgcuvladtyler;

import org.junit.Test;
import org.openqa.selenium.By;

public class AccountCreation extends Setup {

  @Test
  public void createAccount() {
    System.out.println("Creating account...");
    String url = "https://accounts.craigslist.org/login?rp=%2Flogin%2Fhome&rt=L";
    driver.get(url);
    driver.findElement(By.xpath("//*[@id=\"emailAddress\"]")).sendKeys("testemail@test.com");
    driver.findElement(By.xpath("//*[@id=\"create\"]")).click();
    sleep(2000);

  }
}
