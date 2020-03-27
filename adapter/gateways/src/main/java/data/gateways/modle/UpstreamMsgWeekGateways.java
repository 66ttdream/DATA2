package data.gateways.modle;

import data.entity.UpstreamMsgWeek;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpstreamMsgWeekGateways {
    private String appid;
    private String refDate;
    private String msgType;
    private String msgUser;
    private String msgCount;
    public UpstreamMsgWeek toUpstreamMsgWeek(){
        return UpstreamMsgWeek.builder()
                .refDate(refDate)
                .msgType(msgType)
                .msgUser(msgUser)
                .msgCount(msgCount)
                .build();
    }
}
