package data.gateways.modle;

import data.entity.UserRead;
import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserReadGateways {
    private String appid;
    private String refDate;
    private String intPageReadUser;
    private String intPageReadCount;
    private String oriPageReadUser;
    private String oriPageReadCount;
    private String shareUser;
    private String shareCount;
    private String addToFavUser;
    private String addToFavCount;
    public UserRead toUserRead(){
        return UserRead.builder()
                .appid(new AppId(appid))
                .refDate(refDate)
                .intPageReadUser(intPageReadUser)
                .intPageReadCount(intPageReadCount)
                .oriPageReadUser(oriPageReadUser)
                .oriPageReadCount(oriPageReadCount)
                .shareUser(shareUser)
                .shareCount(shareCount)
                .addToFavUser(addToFavUser)
                .addToFavCount(addToFavCount)
                .build();
    }

}
