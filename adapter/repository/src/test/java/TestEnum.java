import data.repository.model.EventConf;
import org.junit.jupiter.api.Test;

public class TestEnum {
    @Test
    public void test(){
        System.out.println(EventConf.valueOf("2"));
    }

}
