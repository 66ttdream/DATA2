package data.gateways.modle;

import data.entity.InterfaceSummaryHour;
import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InterfaceSummaryHourGateways {
    private String appid;
    private String refDate;
    private String refHour;
    private String callbackCount;
    private String failCount;
    private String totalTimeCost;
    private String maxTimeCost;
    public InterfaceSummaryHour toInterfaceSummaryHour(){
        return  InterfaceSummaryHour.builder()
                .appid(new AppId(appid))
                .refDate(refDate)
                .refHour(refHour)
                .callbackCount(callbackCount)
                .failCount(failCount)
                .totalTimeCost(totalTimeCost)
                .maxTimeCost(maxTimeCost)
                .build();
    }


}
