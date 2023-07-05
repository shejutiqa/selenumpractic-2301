package com.selenum;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GetQccCalenderData {

    /**
     * 1. Go to Queens College website
     * 2. Get the calendar information
     * 3. Find out if there is any special event for today
     * 4. Notify Nazrul about the information via email
     */
    private static final Logger logger = LogManager.getLogger(GetQccCalenderData.class);

    public static void main(String[] args) {
        logger.info("Hello!! Let's get calender info.");
        String url = "https://www.qcc.cuny.edu/academics/academic-calendars.html";


        String systemProperties = System.getProperties().toString();
        logger.info(systemProperties);

        String driverPath = System.getProperty("user.dir") + "/src/main/driver/windows/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        String heading = driver.findElement(new By.ByTagName("h2")).getText();
        logger.info(heading);


         List<WebElement>webElementList=driver.findElements(new By.ByTagName("h2"));
         String firstH2Value =webElementList.get(0).getText();

         logger.info(firstH2Value);
       // for (int i = 0; i < 3; i++) {
           //   String H2Value =
           //       WebElement.get()
            // logger.info(H2Value);

         //   driver.close();

        }
    }

