import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUploadTest {

    @Test
    public void fileUploadTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement fileUploadInput = driver.findElement(By.id("file-upload"));
        fileUploadInput.sendKeys(System.getProperty("user.dir")+"/src/test/java/resources/Pinoccio.jpeg");
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement uploadedFilePanel = driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals(uploadedFilePanel.getText(), "Pinoccio.jpeg");

        driver.quit();


    }
}