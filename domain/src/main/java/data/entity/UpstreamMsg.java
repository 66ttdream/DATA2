package data.entity;

import data.vo.id.AppId;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpstreamMsg {
    private AppId appid;
    private String refDate;
    private String msgType;
    private String msgUser;
    private String msgCount;
}
