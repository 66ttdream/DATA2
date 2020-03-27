package data.gateways.modle;

import data.entity.UpstreamMsgHour;
import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpstreamMsgHourGateways {
    private String appid;
    private String refDate;
    private String refHour;
    private String msgType;
    private String msgUser;
    private String msgCount;
    public UpstreamMsgHour toUpstreamMsgHour(){
        return UpstreamMsgHour.builder()
                .appid(new AppId(appid))
                .refDate(refDate)
                .refHour(refHour)
                .msgType(msgType)
                .msgUser(msgUser)
                .msgCount(msgCount)
                .build();
    }

}
