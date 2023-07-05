package heroku;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EntryAd {
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
    public void entryadTest() throws InterruptedException {
        // Go to Checkbox Page
        driver.findElement(By.linkText("Entry Ad")).click();

        // I want to know which page I am in? How do I do that?
        String actualHeading = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("Entry Ad", actualHeading);
        logger.info("test passed");

        driver.findElement(By.id("click here")).click();
        String actualkey=driver.findElement(By.xpath("//*[@id=\"restart-ad\"]")).getText();


        String modalwindow=driver.findElement(By.tagName("h3")).getText();
       Assert.assertEquals(modalwindow,"This is a modal window");
    Thread.sleep(5000);
    logger.info("test passed");
    }
}