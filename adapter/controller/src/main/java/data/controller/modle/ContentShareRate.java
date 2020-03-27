package data.controller.modle;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContentShareRate {
    private String contentName;
    private  int viewNum;
    private int shareNum;
}
