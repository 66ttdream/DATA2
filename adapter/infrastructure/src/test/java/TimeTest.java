import org.junit.jupiter.api.Test;
import util.Time;

import java.util.Iterator;
import java.util.Map;

public class TimeTest {
    @Test
    public void test(){
        System.out.println(Time.generateSynTime());
    }
    @Test
    public void testGetTimeFrame(){
        Map<String,String> map = Time.getTimeFrame(4);
        Iterator it = map.keySet().iterator();
        while (it.hasNext()){
            String key = (String) it.next();
            String value = map.get(key);
            System.out.println(key+" , "+value);
        }
    }

}
