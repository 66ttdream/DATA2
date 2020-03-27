package data.entity;

import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class UserSummary {
    private AppId appid;
    private String refDate;
    private String userSource;
    private String newUser;
    private String cancelUser;
}
