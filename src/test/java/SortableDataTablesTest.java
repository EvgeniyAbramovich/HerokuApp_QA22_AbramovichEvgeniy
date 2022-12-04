import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SortableDataTablesTest {

    @Test
    public void sortableDataTablesTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/tables");

        WebElement cell1 = driver.findElement(By.xpath("//table//tr[1]//td[1]"));
        Assert.assertEquals(cell1.getText(), "Smith");

        WebElement cell2 = driver.findElement(By.xpath("//table//tr[2]//td[3]"));
        Assert.assertEquals(cell2.getText(), "fbach@yahoo.com");

        WebElement cell3 = driver.findElement(By.xpath("//table//tr[4]//td[5]"));
        Assert.assertEquals(cell3.getText(), "http://www.timconway.com");

        driver.quit();

    }
}