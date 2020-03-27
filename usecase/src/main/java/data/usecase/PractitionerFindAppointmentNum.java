package data.usecase;

import data.entity.AppointmentNum;
import data.usecase.port.IUserAnalyzeRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PractitionerFindAppointmentNum {
    private IUserAnalyzeRepository iUserAnalyzeRepository;
    public List<AppointmentNum> execut(int userId, String beginTime, String endTime){
        return iUserAnalyzeRepository.findAppointmentNum(userId, beginTime, endTime);
    }
}
