package data.gateways.modle;

import data.entity.InterfaceSummary;
import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InterfaceSummaryGateways {
    private String appid;
    private String refDate;
    private String callbackCount;
    private String failCount;
    private String totalTimeCost;
    private String maxTimeCost;
    public InterfaceSummary toInterfaceSummary(){
        return InterfaceSummary.builder()
                .appid(new AppId(appid))
                .refDate(refDate)
                .callbackCount(callbackCount)
                .failCount(failCount)
                .totalTimeCost(totalTimeCost)
                .maxTimeCost(maxTimeCost)
                .build();
    }

}
