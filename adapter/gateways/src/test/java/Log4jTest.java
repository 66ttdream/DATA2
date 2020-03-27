
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;


public class Log4jTest {
    private Logger logger = Logger.getLogger(Log4jTest.class);
    @Test
    public void  testLog(){
        for(int i=0;i<10;i++) {
            String s = "sqeq";
            logger.info(s);
        }
   }
}
