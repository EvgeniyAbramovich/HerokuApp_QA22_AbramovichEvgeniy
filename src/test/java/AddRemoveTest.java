import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddRemoveTest {

    @Test
    public void addRemoveTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElementButton.click();
        addElementButton.click();
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(deleteButtons.size(),2);
        deleteButtons.get(0).click();
        deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(deleteButtons.size(),1);

        driver.quit();
    }

}
