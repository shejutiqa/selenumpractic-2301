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

import java.util.List;

public class TyposPageTest{
    private static final Logger logger = LogManager.getLogger(TyposPageTest.class);
    WebDriver driver;
    String url = "http://the-internet.herokuapp.com/";



    @Before
    public void beforeTest(){

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
    public void TyposBoxesTest() throws InterruptedException {
        // Go to Checkbox Page
        driver.findElement(By.linkText("Typos")).click();

        // I want to know which page I am in? How do I do that?
        String actualHeading = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("Typos", actualHeading);
      logger.info("test passed");
      //check the peragrap is right or not.
      String actualp= driver.findElement( By.xpath("//*[@id=\"content\"]/div/p[2]")).getText();
      Thread.sleep(5000);
        System.out.println(actualp);
      String expectp ="Sometimes you'll see a typo, other times you won,t.";
      //        "  Sometimes you'll see a typo, other times you won't."
     //   boolean actualStatus= driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]");
    Assert.assertEquals(expectp,actualp);
    logger.info("test passed");








        // boolean actualStatus = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isSelected();

        // Verify actualStatus is true - > Box is checked

        // Assert.assertEquals(true, actualStatus);
        //  logger.info(" Checked Status Passed ");
    }
        // Verifying unchecked status

      //  driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
      //  boolean actualUncheckedStatus = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected();
     //   Assert.assertEquals(false, actualUncheckedStatus);
      //  logger.info(" Unchecked Status Passed ");
//


    /**
     * Let's write a method to close the browser as soon as a test is completed (Pass/Fail)
     * This method will run after every time a test runs
     * */
    @After
   public void cleanUp(){
        driver.close();
    }

}
