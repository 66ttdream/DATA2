package data.gateways.modle;

import data.entity.ArticleSummary;
import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleSummaryGateways {
    private String appid;
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
    public ArticleSummary toArticleSummary(){
        return ArticleSummary.builder()
                .appid(new AppId(appid))
                .refDate(refDate)
                .msgId(msgId)
                .title(title)
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
