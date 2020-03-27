package data.gateways.modle;

import data.entity.UpstreamMsg;
import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpstreamMsgGateways {
    private String appid;
    private String refDate;
    private String msgType;
    private String msgUser;
    private String msgCount;
    public UpstreamMsg toUpstreamMsg(){
        return UpstreamMsg.builder()
                .appid(new AppId(appid))
                .refDate(refDate)
                .msgType(msgType)
                .msgUser(msgUser)
                .msgCount(msgCount)
                .build();
    }

}
