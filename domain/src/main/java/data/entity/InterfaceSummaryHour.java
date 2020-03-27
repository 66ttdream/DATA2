package data.entity;

import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterfaceSummaryHour {
    private AppId appid;
    private String refDate;
    private String refHour;
    private String callbackCount;
    private String failCount;
    private String totalTimeCost;
    private String maxTimeCost;
}
