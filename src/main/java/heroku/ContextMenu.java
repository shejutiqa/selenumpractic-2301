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
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class ContextMenu {

    private static final Logger logger = LogManager.getLogger(ContextMenu.class);
    // public static Logger logger= LogManager.(ContextMenu.class);
    WebDriver driver;
    String url = "http://the-internet.herokuapp.com/";

    @Before
    public void beforeTest() {
        String systemProperties = System.getProperties().toString();
        logger.info(systemProperties);
        String driverPath = System.getProperty("user.dir") + "/src/main/driver/windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(url);
        driver.manage().window().maximize();

    }

    @Test

    public void contextMenuTest() throws InterruptedException {

        driver.findElement(By.linkText("Context Menu")).click();

       String actualHeading= driver.findElement(By.tagName("h3")).getText();
        logger.info(actualHeading);
        String h3expected = "Context Menu";
        Assert.assertEquals(h3expected, actualHeading);
        logger.info("test passed");


        // Right click the button to launch right click menu options

        Actions action = new Actions(driver);
        WebElement box = driver.findElement(By.id("hot-spot"));
 //String x=box.getText();
        action.contextClick(box).perform();
        Thread.sleep(5000);

        driver.switchTo().alert().accept();
        logger.info("Right click Alert Accepted");
        logger.info("test passed");
        Thread.sleep(5000);


    }

    @After
    public void cleanup() {

        driver.close();


    }
}