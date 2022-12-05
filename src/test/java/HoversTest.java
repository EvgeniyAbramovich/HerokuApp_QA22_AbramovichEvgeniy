import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class HoversTest {

    @Test
    public void hoversTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/hovers");

        WebElement firstUser = driver.findElement(By.xpath("//div[@id='content']//descendant::div[@class='figure'][1]"));
        WebElement secondUser = driver.findElement(By.xpath("//div[@id='content']//descendant::div[@class='figure'][2]"));
        WebElement thirdUser = driver.findElement(By.xpath("//div[@id='content']//descendant::div[@class='figure'][3]"));

        Actions action = new Actions(driver);

        action.moveToElement(firstUser).build().perform();
        WebElement firstUserName = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement link1 = driver.findElement(By.xpath("//h5[text()='name: user1']/following-sibling::a"));
        Assert.assertTrue(firstUserName.isDisplayed());
        link1.click();
        WebElement firstUserPage = driver.findElement(By.xpath("//h1[text()='Not Found']"));
        Assert.assertTrue(firstUserPage.isDisplayed());
        driver.navigate().back();

        secondUser = driver.findElement(By.xpath("//div[@id='content']//descendant::div[@class='figure'][2]"));
        action.moveToElement(secondUser).build().perform();
        WebElement secondUserName = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement link2 = driver.findElement(By.xpath("//h5[text()='name: user2']/following-sibling::a"));
        Assert.assertTrue(secondUserName.isDisplayed());
        link2.click();
        WebElement secondUserPage = driver.findElement(By.xpath("//h1[text()='Not Found']"));
        Assert.assertTrue(secondUserPage.isDisplayed());
        driver.navigate().back();


        thirdUser = driver.findElement(By.xpath("//div[@id='content']//descendant::div[@class='figure'][3]"));
        action.moveToElement(thirdUser).build().perform();
        WebElement thirdUserName = driver.findElement(By.xpath("//h5[text()='name: user3']"));
        WebElement link3 = driver.findElement(By.xpath("//h5[text()='name: user3']/following-sibling::a"));
        Assert.assertTrue(thirdUserName.isDisplayed());
        link3.click();
        WebElement thirdUserPage = driver.findElement(By.xpath("//h1[text()='Not Found']"));
        Assert.assertTrue(thirdUserPage.isDisplayed());
        driver.navigate().back();

        driver.quit();

    }
    }