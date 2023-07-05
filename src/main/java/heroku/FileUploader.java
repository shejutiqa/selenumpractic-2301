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

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FileUploader {


    private static final Logger logger = LogManager.getLogger(FileUploader.class);
    WebDriver driver;
    String url = "http://the-internet.herokuapp.com/";


    @Before
    public void beforeTest() {


        String systemProperties = System.getProperties().toString();
        logger.info(systemProperties);

        String driverPath = System.getProperty("user.dir") + "/src/main/driver/windows/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();

    }

    @Test
    public void FileUplodertest() throws InterruptedException {
        // Go to File Uploader Page
        driver.findElement(By.linkText("File Upload")).click();

        String h3 = driver.findElement(By.tagName("h3")).getText();
        logger.info("h3");
        String h3actual="File Uploader";
        Assert.assertEquals("File Uploader", h3);
        logger.info("test passed");



        // find the upload button
        WebElement fileUpload = driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));
        //select the root path from my pc
        File file = new File("book class.png");
        // windows file upload with file path

        fileUpload.sendKeys(file.getAbsolutePath());
        driver.findElement(By.xpath("//*[@id=\"file-submit\"]")).click();


        String heading = driver.findElement(By.tagName("h3")).getText();
        logger.info(h3);
        String headingactual = "File Uploaded";
        Assert.assertEquals("File Uploader", h3);
        logger.info("test passed");
        Thread.sleep(100000);
    }

   @After
    public void cleanup(){

        driver.close();
   }

}
