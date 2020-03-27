import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {
    @Test
    public void testMap(){
        Map map = new HashMap<String,String>();
        map.put("2","3");
        map.put("da","da");
        map.put("xxsa",null);
        map.remove("da");
        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            System.out.println(map.get(it.next()));
            System.out.println(map.get("gada"));
            System.out.println(map.get("xxsa"));
        }
    }

}
