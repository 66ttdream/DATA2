import data.repository.log.LogRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DBFindConf {
    @Test
    public void test1(){
        LogRepository lr = new LogRepository();
        String id = "3";
        List<String> l = lr.findConf(id);
        for(String s:l){
            System.out.println(s);
        }
    }

}
