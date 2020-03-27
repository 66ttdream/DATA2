package data.entity;

import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpstreamMsgHour{
    private AppId appid;
    private String refDate;
    private String refHour;
    private String msgType;
    private String msgUser;
    private String msgCount;
}
