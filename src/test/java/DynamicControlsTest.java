import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicControlsTest {

    @Test
    public void dynamicControlTest() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement checkbox = driver.findElement(By.id("checkbox"));
        Assert.assertTrue(checkbox.isDisplayed());
        List<WebElement> buttons = driver.findElements(By.cssSelector("[type=button]"));
        Assert.assertEquals(buttons.size(),2);
        buttons.get(0).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's gone!"));

        driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
        int numberOfElements = driver.findElements(By.id("checkbox")).size();
        Assert.assertEquals(numberOfElements,0);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement input = driver.findElement(By.cssSelector("[type=text]"));
        Assert.assertEquals(input.isEnabled(),false);
        buttons.get(1).click();
        wait.until(ExpectedConditions.elementToBeClickable(input));
        Assert.assertEquals(input.isEnabled(),true);

        driver.quit();

    }


}
