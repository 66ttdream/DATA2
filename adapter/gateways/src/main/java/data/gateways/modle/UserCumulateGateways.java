package data.gateways.modle;

import data.entity.UserCumulate;
import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCumulateGateways {
    private String appid;
    private String refDate;
    private String cumulateUser;
    public UserCumulate toUserCumulate(){
        return UserCumulate.builder()
                .appid(new AppId(appid))
                .refDate(refDate)
                .cumulateUser(cumulateUser)
                .build();
    }
}
