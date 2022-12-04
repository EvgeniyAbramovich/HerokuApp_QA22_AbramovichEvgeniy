import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBoxesTest {

    @Test
    public void checkBoxesTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("[type=checkbox]"));
        Assert.assertEquals(checkBoxes.size(),2);
        Assert.assertEquals(checkBoxes.get(0).isSelected(), false);
        checkBoxes.get(0).click();
        Assert.assertEquals(checkBoxes.get(0).isSelected(), true);
        Assert.assertEquals(checkBoxes.get(1).isSelected(), true);
        checkBoxes.get(1).click();
        Assert.assertEquals(checkBoxes.get(1).isSelected(), false);

        driver.quit();
    }
}
