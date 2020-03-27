package data.entity;

import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ArticleSummary {
    private AppId appid;
    private String refDate;
    private String msgId;
    private String title;
    private String intPageReadUser;
    private String intPageReadCount;
    private String oriPageReadUser;
    private String oriPageReadCount;
    private String shareUser;
    private String shareCount;
    private String addToFavUser;
    private String addToFavCount;
}
