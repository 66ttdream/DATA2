package data.spring.controller;

import data.controller.UserAnalyzeControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "analyses")
@RestController
public class UserAnalyzeController {
    private UserAnalyzeControl userAnalyzeControl;
    @Autowired
    public UserAnalyzeController(UserAnalyzeControl userAnalyzeControl){
        this.userAnalyzeControl = userAnalyzeControl;
    }

    @GetMapping(value = "usernum/manager")
    public int getAllUserNum(){
        return userAnalyzeControl.getAllUserNum();
    }
    @GetMapping(value = "usernum/practitioner/{userid}")
    public int getUserNum(@PathVariable("userid") int userId){
        return userAnalyzeControl.getUserNum(userId);
    }
    @GetMapping(value = "newadduser/practitioner/{userid}/{begintime}/{endtime}")
    public int getNewAddUser(@PathVariable("userid") int userId,@PathVariable("bengintime") String beginTime,@PathVariable("endtime") String endTime){
        return userAnalyzeControl.getNewAddUser(userId,beginTime,endTime);
    }
    @GetMapping(value = "newadduser/manager/{begintime}/{endtime}")
    public int getAllNewAddUser(@PathVariable String beginTime, String endTime){
        return userAnalyzeControl.getAllNewAddUser(beginTime,endTime);
    }
    @GetMapping(value = "activeuser/practitioner/{userid}/{bengintime}/{endtime}")
    public int getActiveUser(@PathVariable("userid") int userId,@PathVariable("begintime") String beginTime,@PathVariable("endtime") String endTime){
        return userAnalyzeControl.getActiveUser(userId,beginTime,endTime);
    }
    @GetMapping(value = "activeuser/manager/{bengintime}/{endtime}")
    public int getAllActiveUser(@PathVariable("bengintime") String beginTime,@PathVariable("endtime") String endTime){
        return userAnalyzeControl.getAllActiveUser(beginTime,endTime);
    }
    @GetMapping(value = "usetimeframe/practitioner/{userid}/{bengintime}/{endtime}/{frame}")
    public List getAllUseTimeFrame(@PathVariable("userid") int userId,@PathVariable("bengintime") String beginTime,@PathVariable("endtime") String endTime,@PathVariable("frame") int frame){
        return userAnalyzeControl.getUseTimeFrame(userId, beginTime, endTime, frame);
    }
    @GetMapping(value = "usetimeframe/manager/{bengintime}/{endtime}/{frame}")
    public List getUseTimeFrame(@PathVariable("bengintime") String beginTime,@PathVariable("endtime") String endTime,@PathVariable("frame") int frame){
        return userAnalyzeControl.getAllUseTimeFrame(beginTime, endTime, frame);
    }
    @GetMapping(value = "appointmentnum/manager/{bengintime}/{endtime}")
    public List getAllAppointmentNum(@PathVariable("bengintime") String beginTime,@PathVariable("endtime") String endTime){
        return userAnalyzeControl.getAllAppointmentNum(beginTime, endTime);
    }
    @GetMapping(value = "appointmentnum/practitioner/{userid}/{bengintime}/{endtime}")
    public List getAppointmentNum(@PathVariable("userid") int userId,@PathVariable("bengintime") String beginTime,@PathVariable("bengintime") String endTime){
        return userAnalyzeControl.getAppointmentNum(userId,beginTime, endTime);
    }
    @GetMapping(value = "appointmentsum/manager/{bengintime}/{endtime}")
    public int getAllAppointmentSum(@PathVariable("bengintime") String beginTime,@PathVariable("bengintime") String endTime){
        return userAnalyzeControl.getAllAppointmentSum(beginTime,endTime);
    }
    @GetMapping(value = "appointmentsum/practitioner/{userid}/{bengintime}/{endtime}")
    public int getAppointmentSum(@PathVariable("userid") int userId,@PathVariable("bengintime") String beginTime,@PathVariable("bengintime") String endTime){
        return userAnalyzeControl.getAppointmentSum(userId,beginTime, endTime);
    }
    @GetMapping(value = "newaddip/manager/{bengintime}/{endtime}")
    public int getAllNewAddIp(@PathVariable("bengintime") String beginTime,@PathVariable("bengintime") String endTime){
        return userAnalyzeControl.getAllNewAddIp(beginTime, endTime);
    }
    @GetMapping(value = "newaddip/practitioner/{userid}/{bengintime}/{endtime}")
    public int getNewAddIp(@PathVariable("userid") int userId,@PathVariable("bengintime") String beginTime,@PathVariable("bengintime") String endTime){
        return userAnalyzeControl.getNewAddIp(userId,beginTime, endTime);
    }
    @GetMapping(value = "allterminal/manager/{bengintime}/{endtime}")
    public List getAllTerminal(@PathVariable("bengintime") String beginTime,@PathVariable("bengintime") String endTime){
        return userAnalyzeControl.getAllTerminal(beginTime, endTime);
    }
    @GetMapping(value = "allterminal/practitioner/{userid}/{bengintime}/{endtime}")
    public List getTerminal(@PathVariable("userid") int userId,@PathVariable("bengintime") String beginTime,@PathVariable("bengintime") String endTime){
        return userAnalyzeControl.getTerminal(userId,beginTime, endTime);
    }
    @GetMapping(value = "district/manager/{bengintime}/{endtime}")
    public List getAllDistrict(@PathVariable("bengintime") String beginTime,@PathVariable("bengintime") String endTime){
        return userAnalyzeControl.getAllDistrict(beginTime, endTime);
    }
    @GetMapping(value = "district/practitioner/{userid}/{bengintime}/{endtime}")
    public List getDistrict(@PathVariable("userid") int userId,@PathVariable("bengintime") String beginTime,@PathVariable("bengintime") String endTime){
        return userAnalyzeControl.getDistrict(userId,beginTime, endTime);
    }


    @GetMapping(value = "test")
    public void getTest(HttpServletRequest req){
        Map<String,String[]> map = req.getParameterMap();
        System.out.println(map.get("url")[0].toString());
    }


    @GetMapping(value = "/useranalysesdata")
    public Map<String,Object> getPeriodAnalysisData(HttpServletRequest hsq){
        Map<String,String[]> map = hsq.getParameterMap();
        String beginTime = map.get("bengintime")[0];
        String endTime =  map.get("endtime")[0];
        int frame = Integer.valueOf(map.get("frame")[0]);
        int userId = Integer.valueOf(map.get("userId")[0]);
        Map rmap = new HashMap();
        //List<Heatwork> l = ContentanalyzeControl.getAllHeatwork(pageNum,pageSize);
        rmap.put("allusernum",userAnalyzeControl.getAllUserNum());
        rmap.put("usernum",userAnalyzeControl.getUserNum(userId));
        rmap.put("newadduser",userAnalyzeControl.getNewAddUser(userId,beginTime,endTime));
        rmap.put("allnewadduser",userAnalyzeControl.getAllNewAddUser(beginTime,endTime));
        rmap.put("activeUser",userAnalyzeControl.getActiveUser(userId,beginTime,endTime));
        rmap.put("allactiveUser",userAnalyzeControl.getAllActiveUser(beginTime,endTime));
        rmap.put("usetimeframe",userAnalyzeControl.getUseTimeFrame(userId, beginTime, endTime, frame));
        rmap.put("AllUseTimeFrame",userAnalyzeControl.getAllUseTimeFrame(beginTime, endTime, frame));
        rmap.put("allAppointmentNum",userAnalyzeControl.getAllAppointmentNum(beginTime, endTime));
        rmap.put("AppointmentNum",userAnalyzeControl.getAppointmentNum(userId,beginTime, endTime));
        rmap.put("AllAppointmentSum",userAnalyzeControl.getAllAppointmentSum(beginTime,endTime));
        rmap.put("AppointmentSum",userAnalyzeControl.getAppointmentSum(userId,beginTime, endTime));
        rmap.put("AllNewAddIp",userAnalyzeControl.getAllNewAddIp(beginTime, endTime));
        rmap.put("NewAddIp",userAnalyzeControl.getNewAddIp(userId,beginTime, endTime));
        rmap.put("AllTerminal",userAnalyzeControl.getAllTerminal(beginTime, endTime));
        rmap.put("Terminal",userAnalyzeControl.getTerminal(userId,beginTime, endTime));
        rmap.put("AllDistrict",userAnalyzeControl.getAllDistrict(beginTime, endTime));
        rmap.put("District",userAnalyzeControl.getDistrict(userId,beginTime, endTime));
        return rmap;
    }

}
