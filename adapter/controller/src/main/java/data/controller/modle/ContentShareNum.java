package data.controller.modle;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContentShareNum {
    private String contentName;
    private int shareTime;
}
