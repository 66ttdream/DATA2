package data.usecase;

import data.entity.AppointmentNum;
import data.usecase.port.IUserAnalyzeRepository;

import java.util.List;

public class PratictionerFindAppointmentNum {
    private IUserAnalyzeRepository iUserAnalyzeRepository;
    public List<AppointmentNum> execut(int userId, String benginTime, String endTime){
        return iUserAnalyzeRepository.findAppointmentNum(userId, benginTime, endTime);
    }
}
