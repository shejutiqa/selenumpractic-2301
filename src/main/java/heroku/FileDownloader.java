package heroku;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownloader {

    private static final Logger logger = LogManager.getLogger(TyposPageTest.class);
    WebDriver driver;
    String url = "http://the-internet.herokuapp.com/";

    @Before
    public void beforeTest() {

        String systemProperties = System.getProperties().toString();
        logger.info(systemProperties);

        String driverPath = System.getProperty("user.dir") + "/src/main/driver/windows/chromedriver.exe";

        // Let's show the application where is the driver object
        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver(); // Chrome Browser Object
        // Open a new Chrome Window and browse to the website using URL
        driver.get(url);
        // Make my Chrome window little look good by maximizing the size
        driver.manage().window().maximize();

    }

    @Test
    public void FiledownloderTest() throws InterruptedException {
        // Go to Checkbox Page
        driver.findElement(By.linkText("File Downloader")).click();

        // I want to know which page I am in? How do I do that?
        String actualHeading = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("File Downloader", actualHeading);
        logger.info("test passed");

        WebElement filedownload =driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[9]"));
        filedownload.click();
    }
    @After
    public void cleanup(){
        driver.close();
    }

}

