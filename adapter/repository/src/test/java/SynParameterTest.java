import data.entity.SynParameter;
import data.repository.synparameter.SynPerameterRepository;
import data.vo.id.AppId;
import org.junit.jupiter.api.Test;

public class SynParameterTest {/*
    @Test
    public void testfind(){
        SynPerameterRepository s = new SynPerameterRepository();
        SynParameter sp = SynParameter.builder()
                                      .aesKey("1")
                                      .token("6")
                                      .synParameterId(new AppId("2"))
                                      .secret("2")
                                      .build();
        //System.out.println(s.findParameter(sp));
        *//*System.out.println(s.findParameter(sp).getToken());
        System.out.println(s.findParameter(sp).getSecret());*//*
        s.upPerameter(sp);
    }*/
   /* @Test
    public void testDelete(){
        SynPerameterRepository s = new SynPerameterRepository();
        SynParameter sp = SynParameter.builder()
                .aesKey("1")
                .token("6")
                .synParameterId(new AppId("2"))
                .secret("2")
                .build();
        s.deletePerameter(sp.getSynParameterId());
    }*/
    @Test
    public void testfind(){
        SynPerameterRepository s = new SynPerameterRepository();
        AppId appid = new AppId("12313");
        var x = s.findParameter(SynParameter.builder().synParameterId(appid).build());
        System.out.println(x);
    }

}