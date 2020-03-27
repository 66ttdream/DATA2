package data.gateways.modle;

import data.entity.UserReadHour;
import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserReadHourGateways {
    private String appid;
    private String refDate;
    private String refHour;
    private String userSource;
    private String intPageReadUser;
    private String intPageReadCount;
    private String oriPageReadUser;
    private String oriPageReadCount;
    private String shareUser;
    private String shareCount;
    private String addToFavUser;
    private String addToFavCount;
    public UserReadHour toUserReadHour(){
        return UserReadHour.builder()
                .appid(new AppId(appid))
                .refDate(refDate)
                .refHour(refHour)
                .userSource(userSource)
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
