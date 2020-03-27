package data.analyzeentity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class HeatworkOfUser {
    private String contentName;
    private int pageView;
}
