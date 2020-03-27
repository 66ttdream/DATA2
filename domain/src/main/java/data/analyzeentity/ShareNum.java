package data.analyzeentity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class ShareNum {
    private String contentName;
    private int shareTime;
}
