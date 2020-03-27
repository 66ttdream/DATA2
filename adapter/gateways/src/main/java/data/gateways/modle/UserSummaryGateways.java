package data.gateways.modle;

import data.entity.UserSummary;
import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserSummaryGateways {
    private String appid;
    private String refDate;
    private String userSource;
    private String newUser;
    private String cancelUser;
    public UserSummary toUserSummary(){
        return UserSummary.builder()
                .appid(new AppId(appid))
                .refDate(refDate)
                .userSource(userSource)
                .newUser(newUser)
                .cancelUser(cancelUser)
                .build();
    }
}
