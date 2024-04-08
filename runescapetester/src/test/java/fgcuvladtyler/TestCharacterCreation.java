package fgcuvladtyler;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestCharacterCreation extends TestAccountCreation {
        private WebDriver driver = new ChromeDriver();
        private WebDriverWait wait;



        @Test
        public void createNewUser() throws InterruptedException {
            driver.get("https://account.runescape.com/en-GB/game");
            Thread.sleep(5000);
            // Find the iframe whose id attribute starts with 'cf-ch'
            WebElement iframeElement = driver.findElement(By.cssSelector("iframe[id^='cf-ch']"));

            // Switch to the iframe
            driver.switchTo().frame(iframeElement);

            WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));

            // Check if the checkbox is selected, if not, select it
            if (!checkbox.isSelected()) {
              Thread.sleep(3000);
              checkbox.click();
            }

            WebElement createNewButton = driver.findElement(By.cssSelector("button[data-testid='game-accounts-create-new-button']"));
            createNewButton.click();

            Thread.sleep(9000);



        }


}
