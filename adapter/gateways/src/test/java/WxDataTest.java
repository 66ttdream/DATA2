import com.google.gson.Gson;
import data.entity.SynParameter;
import data.gateways.datagateways.WxDataGateways;
import data.gateways.modle.UserCumulateGateways;
import data.vo.id.AppId;
import me.chanjar.weixin.common.error.WxErrorException;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WxDataTest {
    /*@Test
    public  void  Test() throws WxErrorException {
        SynParameter sp = SynParameter.builder()
                .aesKey("1bowgIQcyrHMGq90sO4oXDFhseBrAPkW4uZ9xEca9la")
                .token("104466")
                .synParameterId(new AppId("wx204617e03f6e00c7"))
                .secret("d1f3f3e4797decbafe3c3a608f84b656")
                .build();
        //List<List> l = WxDataGateways.get(sp);
        for(List li:l){
                System.out.print(li.toString());
        }
        System.out.println(l.get(11));
        Gson gson = new Gson();
        UserCumulateGateways userCumulateGateways = gson.fromJson(l.get(11).toString().replace("[","").replace("]",""),UserCumulateGateways.class);
        System.out.println(userCumulateGateways.getRefDate());

    }*/
}
