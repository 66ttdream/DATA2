import data.entity.SynLog;
import data.entity.UserSummary;
import data.repository.syndata.SynDataRepository;
import data.vo.id.AppId;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class SynDataRepositoryTest {
    //@Test
    public void test(){
        SynDataRepository sdr = new SynDataRepository();
        UserSummary userSummary = new UserSummary(new AppId("2132141"),"321","2313","0","421");
        sdr.insertUserSummary(userSummary);

    }
    @Test
    public void testInsertSynLog(){
        SynLog synLog = SynLog.builder()
                .status(false)
                .executTime(2)
                .excutContent("1")
                .dataTime(new Date())
                .appid(new AppId("213"))
                .build();
        SynDataRepository sdr = new SynDataRepository();
        sdr.insertSynLog(synLog);
    }

}
