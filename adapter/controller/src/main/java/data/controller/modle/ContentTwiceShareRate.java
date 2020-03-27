package data.controller.modle;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContentTwiceShareRate {
    String contentName;
    int shareNum;
    int twiceShareNum;
}
