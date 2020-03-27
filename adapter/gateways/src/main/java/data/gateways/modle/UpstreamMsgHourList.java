package data.gateways.modle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpstreamMsgHourList {
    private UpstreamMsgHourGateways[] list;
}
