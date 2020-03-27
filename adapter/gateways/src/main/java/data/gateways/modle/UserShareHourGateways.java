package data.gateways.modle;

import data.entity.UserShareHour;
import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserShareHourGateways {
    private String appid;
    private String refDate;
    private String refHour;
    private String shareScene;
    private String shareCount;
    private String shareUser;
    public UserShareHour toUserShareHour(){
        return UserShareHour.builder()
                .appid(new AppId(appid))
                .refDate(refDate)
                .refHour(refHour)
                .shareScene(shareScene)
                .shareCount(shareCount)
                .shareUser(shareUser)
                .build();
    }

}
