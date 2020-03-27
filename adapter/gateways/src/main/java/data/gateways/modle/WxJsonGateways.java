package data.gateways.modle;

import data.entity.ArticleSummary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Deprecated
public class WxJsonGateways {
    private ArticleSummaryGateways[] list;

}
