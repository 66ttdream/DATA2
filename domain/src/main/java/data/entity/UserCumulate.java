package data.entity;

import data.vo.id.AppId;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCumulate{
    private AppId appid;
    private String refDate;
    private String cumulateUser;
}
