package data.analyzeentity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class TwiceShareRate {
    String contentName;
    int shareNum;
    int twiceShareNum;
}
