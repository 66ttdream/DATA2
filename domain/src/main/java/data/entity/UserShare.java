package data.entity;

import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserShare {
    private AppId appid;
    private String refDate;
    private String shareScene;
    private String shareCount;
    private String shareUser;
}
