package data.entity;

import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Deprecated
public class SynHistoryDataParameter {
    private AppId appid;
    private Date beginTime;
    private Date endTime;
    /*public void synHistoryDataParameter(AppId appid,Date beginTime,Date endTime){
        this.appid=appid;
        this.beginTime=beginTime;
        this.endTime=endTime;
    }*/

}
