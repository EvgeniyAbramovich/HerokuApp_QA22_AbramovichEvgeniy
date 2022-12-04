import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownTest {

    @Test
    public void dropDownTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dropdown");

        Select select = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> allOptions = select.getOptions();
        Assert.assertEquals(allOptions.size(),3);
        Assert.assertEquals(allOptions.get(0).getText(), "Please select an option");
        Assert.assertEquals(allOptions.get(1).getText(), "Option 1");
        Assert.assertEquals(allOptions.get(2).getText(), "Option 2");

        select.selectByIndex(1);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Option 1");
        select.selectByIndex(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");

        driver.quit();

    }
}