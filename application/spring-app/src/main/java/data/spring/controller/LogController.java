package data.spring.controller;

import data.controller.LogControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RequestMapping(value="/log")
@RestController
public class LogController {
    private final LogControl logcontrol;
    @Autowired
    public LogController(LogControl logcontrol) {
        this.logcontrol = logcontrol;
    }

    @PostMapping(value = "/set")
    public String setLogConf(HttpServletRequest httpRequest) {
        Map<String, String[]> ans = httpRequest.getParameterMap();
        if(ans.get("eventid")==null){
            return "未关联事件：eventid为空";
        }
        List l = logcontrol.setConf(ans);
        if(l==null){
            return "参数设置成功";
        }else{
            return "重复参数："+l.toString();
        }
    }
    @PostMapping(value = "/gether")
    public void acceptLog(HttpServletRequest httpRequest){
        Map<String, String[]> ans = httpRequest.getParameterMap();
        Iterator it = ans.keySet().iterator();
        logcontrol.proccess(ans);
    }
}
