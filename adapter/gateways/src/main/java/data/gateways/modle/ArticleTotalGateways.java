package data.gateways.modle;

import data.entity.ArticleTotal;
import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleTotalGateways {
    private String  appid;
    private String  refDate;
    private String  msgid;
    private String  title;
    private List<ArticleTotal_Details> details;

    public ArticleTotal toArticleTotal(){
        return ArticleTotal.builder()
                .appid(new AppId(appid))
                .refDate(refDate)
                .msgid(msgid)
                .title(title)
                .build();

    }

}
