import data.repository.db.DBConf;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Map;

public class DBconfTest {
    @Test
    public void test1(){
        Map<String, String> map = System.getenv();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        //System.out.println(map.get("url"));
        System.out.println("值："+DBConf.getMaxPoolSize());
    }
}
