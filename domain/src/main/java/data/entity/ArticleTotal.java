package data.entity;

import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ArticleTotal {
    private AppId appid;
    private String  refDate;
    private String  msgid;
    private String  title;
}
