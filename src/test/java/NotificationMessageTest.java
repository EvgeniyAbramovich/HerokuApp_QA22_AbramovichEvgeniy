import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NotificationMessageTest {

    @Test
    public void notificationMessageTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");

        driver.findElement(By.cssSelector(".example a")).click();
        String message = driver.findElement(By.cssSelector(".flash")).getText();
        Assert.assertEquals(message, "Action unsuccesful, please try again\n" + "×");

        driver.quit();
    }
}
