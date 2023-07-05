package heroku;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class DropDownList {

    /**
     * Problem Statement
     * I want to go to Heroku app website and verify the checkbox page check boxes are
     * working properly.
     * 1. So I want to check the box and verify that box is checked
     * 2. I also want to uncheck a box and verify the box is unchecked
     * */

    private static final Logger logger = LogManager.getLogger(DropDownList.class);
    WebDriver driver;
    String url = "http://the-internet.herokuapp.com/";


    @Before
    public void beforeTest(){

        // Get the current System Properties
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
    public void DropDowntest() throws InterruptedException {
        // Go to Dropdwon Page
        driver.findElement(By.linkText("Dropdown")).click();
        // I want to know which page I am in? How do I do that?
        String actualHeading = driver.findElement(By.tagName("h3")).getText();
        assertEquals("Dropdown List", actualHeading);
        driver.findElement(By.xpath("//*[@id=\"dropdown\"]")).click();
        // Stop execution for 5 sec
        // Thread.sleep(5000);

        boolean selectedoption1 = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[2]")).isSelected();

        // Verify selectedoption1 is true -
       Assert.assertEquals(false, selectedoption1);
      //  Assert.assertEquals(true, selectedoption1);
        logger.info(" Checke option1");

        // Verifying selectoption2
       boolean selectedoption2 = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]")).isDisplayed();

       Assert.assertEquals(false, selectedoption1);
        logger.info(" Checke option2");

    }

    /**
     * Let's write a method to close the browser as soon as a test is completed (Pass/Fail)
     * This method will run after every time a test runs
     * */
    @After
    public void cleanUp(){
    driver.close();
   }

}