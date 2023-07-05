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

public class BrokenImages {

    /**
     * Problem Statement
     * I want to go to Heroku app website and verify the brokenimages page
     * working properly.
     * 1. So I want to check the img and verify img is checked
     * 2. I also want to checked all img and verify
     */

    private static final Logger logger = LogManager.getLogger(BrokenImages.class);
    WebDriver driver;
    String url = "http://the-internet.herokuapp.com/";


    @Before
    public void beforeTest() {

        // Get the current System Properties
        String systemProperties = System.getProperties().toString();
        logger.info(systemProperties);

        String driverPath = System.getProperty("user.dir") + "/src/main/driver/windows/chromedriver.exe";


        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver(); // Chrome Browser Object

        driver.get(url);
        driver.manage().window().maximize();

    }

    @Test
    public void brokenimagetest() throws InterruptedException {

        driver.findElement(By.linkText("Broken Images")).click();
        // I want to know which page I am in? How do I do that?
        String actualHeading = driver.findElement(By.tagName("h3")).getText();
        assertEquals("Broken Images", actualHeading);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).click();


        Thread.sleep(5000);

        boolean selectimg1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/img[1]")).isSelected();

        //  Verify selectedoption1 is true -
        Assert.assertEquals(true, selectimg1);
        logger.info(" Checke img1");

        //  Verifying selectoption2
        boolean selectimg2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/img[2]")).isSelected();

        Assert.assertEquals(true, selectimg2);
        logger.info(" Checke img2");

        boolean selectimg3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/img[3]")).isDisplayed();

        Assert.assertEquals(true, selectimg2);
        logger.info(" Checke img3");
    }
}

//        @After
//        public void cleanUp () {
//            driver.close();
//        }
//
//    }
//}
//
//


//    boolean isImageBroken;
//        if (driver.findElement(By.tagName("img")).getAttribute("src").endsWith("asdf.jpg")) isImageBroken = true;
//                else isImageBroken = false;
//                Assert.assertEquals(false, isImageBroken);
//                Thread.sleep(5000);
//                logger.info("The first image is broken.");
//                Thread.sleep(10000);
//
//