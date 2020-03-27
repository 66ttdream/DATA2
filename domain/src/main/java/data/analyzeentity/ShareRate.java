package data.analyzeentity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class ShareRate {
    private String contentName;
    private  int viewNum;
    private int shareNum;
}
