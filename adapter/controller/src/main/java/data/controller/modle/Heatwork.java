package data.controller.modle;

import data.analyzeentity.HeatworkOfUser;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Heatwork {
    private String contentName;
    private int pageView;
}
