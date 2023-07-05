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

public class AbTest {



    private static final Logger logger = LogManager.getLogger(AbTest.class);
    WebDriver driver;
    String url = "http://the-internet.herokuapp.com/";



    @Before
    public void beforeTest(){


        String systemProperties = System.getProperties().toString();
        logger.info(systemProperties);

        String driverPath = System.getProperty("user.dir") + "/src/main/driver/windows/chromedriver.exe";


        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();

        driver.get(url);
        // Make my Chrome window little look good by maximizing the size
        driver.manage().window().maximize();

    }

    @Test
    public void AbTest()  {
        // Go to the Page
        driver.findElement(By.linkText("A/B Testing")).click();
        // I want to know which page I am in? How do I do that?
        String h3actual= driver.findElement(By.tagName("h3")).getText();
        logger.info(h3actual);
        String h3expect = "A/B Test Variation 1";
        Assert.assertEquals(h3expect,h3actual);
      //  driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).click();

       //  Thread.sleep(1000);


        logger.info(" test Passed ");

        // Verifying unchecked status

//        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
//        boolean actualUncheckedStatus = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected();
//        Assert.assertEquals(false, actualUncheckedStatus);
//        logger.info(" Unchecked Status Passed ");
//        Thread.sleep(10000);
    }
       // @After
     //   public void cleanUp(){
       //     driver.close();
      //  }

    }