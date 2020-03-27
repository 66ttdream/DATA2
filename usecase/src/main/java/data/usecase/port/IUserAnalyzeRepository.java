package data.usecase.port;

import data.entity.AppointmentNum;
import data.entity.DistrictRate;
import data.entity.TerminalNum;

import java.util.List;

public interface IUserAnalyzeRepository {
    public int findUser(int userId);
    public int findAllUser();
    public int findNewAddUser(int userId,String beginTime, String endTime);
    public int findAllNewAddUser(String beginTime, String endTime);
    public int findAllActiveUserNum(String beginTime, String endTime);
    public int findActiveUserNum(int userId ,String beginTime, String endTime);
    public List<Integer> findUseTimeFrame(int userId,String beginTime,String endTime,int frame);
    public List<Integer> findAllUseTimeFrame(String beginTime,String endTime,int frame);
    public List<AppointmentNum> findAppointmentNum(int userId, String beginTime, String endTime);
    public List<AppointmentNum> findAllAppointmentNum(String beginTime, String endTime);
    public int findAppointmentSum(int userId,String beginTime, String endTime);
    public int findAllAppointmentSum(String beginTime, String endTime);
    public int findNewAddIp(int userId,String beginTime, String endTime);
    public int findAllNewAddIp(String beginTime, String endTime);
    public List<TerminalNum> findTerminal(int userId,String beginTime, String endTime);
    public List<TerminalNum> findAllTerminal(String beginTime, String endTime);
    public List<DistrictRate> findDistrict(int userId,String beginTime, String endTime);
    public List<DistrictRate> findAllDistrict(String beginTime, String endTime);
}
