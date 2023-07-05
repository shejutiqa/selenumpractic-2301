
package base;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class Base {

    private static Logger logger = LogManager.getLogger(Base.class.getName());

    public static final String url = "https://www.qcc.cuny.edu/academics/academic-calendars.html";

    public static String buildURL() {
        String url =buildURL() ;
        logger.info("URL : " + url);
        return url;
    }
}