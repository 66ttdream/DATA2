package data.entity;

import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SynLog {
    private AppId appid;
    private Date dataTime;
    private String excutContent;
    private int executTime;
    private Boolean status;
}
