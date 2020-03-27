package data.gateways.modle;

import data.entity.UpstreamMsgDist;
import data.entity.UpstreamMsgDistMonth;
import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpstreamMsgDistMonthGateways {
    private String appid;
    private String refDate;
    private String countInterval;
    private String msgUser;
    public UpstreamMsgDistMonth toUpstreamMsgDistMonth(){
        return UpstreamMsgDistMonth.builder()
                .appid(new AppId(appid))
                .refDate(refDate)
                .countInterval(countInterval)
                .msgUser(msgUser)
                .build();
    }
}
