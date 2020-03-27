package data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class AppointmentNum {
    String contentName;
    int AppointmentNum;
}
