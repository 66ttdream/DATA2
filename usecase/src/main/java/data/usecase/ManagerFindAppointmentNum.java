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
public class ManagerFindAppointmentNum {
    private IUserAnalyzeRepository iUserAnalyzeRepository;
    public List<AppointmentNum> execut(String beginTime, String endTime){
        return iUserAnalyzeRepository.findAllAppointmentNum(beginTime,endTime);
    }
}
