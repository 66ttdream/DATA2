package data.controller;

import data.usecase.*;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserAnalyzeControl {
    private ManagerFindUser managerFindUser;
    private PractitionerFindUser practitionerFindUser;
    private ManagerFinNewAddUser managerFinNewAddUser;
    private PractitionerFindNewAddUser practitionerFindNewAddUser;
    private ManagerFindActiveUser managerFindActiveUser;
    private PractitionerFindActiveUser practitionerFindActiveUser;
    private ManagerFindUseTimeFrame managerFindUseTimeFrame;
    private PractitionerFindUseTimeFrame practitionerFindUseTimeFrame;
    private ManagerFindAppointmentNum managerFindAppointmentNum;
    private PractitionerFindAppointmentNum practitionerFindAppointmentNum;
    private ManagerFindAppointmentSum managerFindAppointmentSum;
    private PractitionerFindAppointmentSum practitionerFindAppointmentSum;
    private ManagerFindNewAddIp managerFindNewAddIp;
    private PractitionerFindNewAddIp practitionerFindNewAddIp;
    private ManagerFindTerminal managerFindTerminal;
    private PractitionerFindTerminal practitionerFindTerminal;
    private ManagerFindDistrict managerFindDistrict;
    private PractiotionerFindDistrict practiotionerFindDistrict;
    public int getAllUserNum(){
        return managerFindUser.execut();
    }
    public int getUserNum(int userId){
        return practitionerFindUser.execut(userId);
    }
    public int getNewAddUser(int userId,String beginTime, String endTime){
        return practitionerFindNewAddUser.execut(userId,beginTime,endTime);
    }
    public int getAllNewAddUser(String beginTime, String endTime){
        return managerFinNewAddUser.execut(beginTime,endTime);
    }
    public int getActiveUser(int userId ,String beginTime, String endTime){
        return practitionerFindActiveUser.execut(userId,beginTime,endTime);
    }
    public int getAllActiveUser(String beginTime, String endTime){
        return managerFindActiveUser.execut(beginTime,endTime);
    }
    public List getUseTimeFrame(int userId,String beginTime,String endTime,int frame){
        return practitionerFindUseTimeFrame.execut(userId, beginTime, endTime, frame);
    }
    public List getAllUseTimeFrame(String beginTime,String endTime,int frame){
        return managerFindUseTimeFrame.execut(beginTime, endTime, frame);
    }
    public List getAllAppointmentNum(String beginTime, String endTime){
        return managerFindAppointmentNum.execut(beginTime, endTime);
    }
    public List getAppointmentNum(int userId,String beginTime,String endTime){
        return practitionerFindAppointmentNum.execut(userId, beginTime, endTime);
    }
    public int getAllAppointmentSum(String benginTime,String endTime){
        return managerFindAppointmentSum.execut(benginTime,endTime);
    }
    public int getAppointmentSum(int userId,String beginTime,String endTime){
        return practitionerFindAppointmentSum.execut(userId, beginTime, endTime);
    }
    public int getAllNewAddIp(String beginTime, String endTime){
        return managerFindNewAddIp.execut(beginTime, endTime);
    }
    public int getNewAddIp(int userId,String beginTime, String endTime){
        return practitionerFindNewAddIp.execut(userId, beginTime, endTime);
    }
    public List getAllTerminal(String beginTime, String endTime){
        return managerFindTerminal.execut(beginTime, endTime);
    }
    public List getTerminal(int userId,String beginTime, String endTime){
        return practitionerFindTerminal.execut(userId, beginTime, endTime);
    }
    public List getAllDistrict(String beginTime, String endTime){
        return managerFindDistrict.execut(beginTime, endTime);
    }
    public List getDistrict(int userId,String beginTime, String endTime){
        return practiotionerFindDistrict.execut(userId, beginTime, endTime);
    }
}
