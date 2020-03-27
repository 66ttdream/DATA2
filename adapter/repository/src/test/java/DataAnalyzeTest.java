import data.repository.dataanalyze.ContentAnalyzeRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DataAnalyzeTest {
    @Test
    public void test1(){
        ContentAnalyzeRepository c = new ContentAnalyzeRepository();
        List l = c.findHeatwork(21,1,1);
        for(Object h:l){
            System.out.println(h);
        }
        System.out.println(c.findHeatwork(4,1,1).toString());
    }
}
