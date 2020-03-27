package data.gateways.modle;

import data.entity.UpstreamMsgMonth;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpstreamMsgMonthGateways {
    private String appid;
    private String refDate;
    private String msgType;
    private String msgUser;
    private String msgCount;
    public UpstreamMsgMonth toUpstreamMsgMonth(){
        return UpstreamMsgMonth.builder()
                .refDate(refDate)
                .msgType(msgType)
                .msgUser(msgUser)
                .msgCount(msgCount)
                .build();
    }

}
