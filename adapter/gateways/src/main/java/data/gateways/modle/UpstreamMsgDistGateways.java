package data.gateways.modle;

import data.entity.UpstreamMsgDist;
import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpstreamMsgDistGateways {
    private String appid;
    private String refDate;
    private String countInterval;
    private String msgUser;
    public UpstreamMsgDist toUpstreamMsgDist(){
        return UpstreamMsgDist.builder()
                .appid(new AppId(appid))
                .countInterval(countInterval)
                .refDate(refDate)
                .msgUser(msgUser)
                .build();
    }
}
