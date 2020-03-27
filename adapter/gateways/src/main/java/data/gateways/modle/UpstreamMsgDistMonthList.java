package data.gateways.modle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpstreamMsgDistMonthList {
    private UpstreamMsgDistMonthGateways[] list;
}
