package data.gateways.modle;

import data.entity.UserShare;
import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserShareGateways {
    private String appid;
    private String refDate;
    private String shareScene;
    private String shareCount;
    private String shareUser;
    public UserShare toUserShare(){
        return UserShare.builder()
                .appid(new AppId(appid))
                .refDate(refDate)
                .shareScene(shareScene)
                .shareCount(shareCount)
                .shareUser(shareUser)
                .build();
    }


}
