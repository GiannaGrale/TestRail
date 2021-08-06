package tests.lesson_16;


import baseEntities.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class LoggerTest extends BaseTest {
    Logger logger = LogManager.getLogger(LoggerTest.class);

    @Test
    public  void loggingLevelsTest(){
        logger.fatal("Fatal");
        logger.error("Error");
        logger.warn("Warn");
        logger.info("Info");
        logger.debug("Debug");

    }
}
