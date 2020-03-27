package data.usecase;

import data.usecase.port.ILogRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveLog {
    private ILogRepository iLogRepository;
    public void execut(Map<String,String[]> map){
        List<String> l = iLogRepository.findConf(map.get("eventid")[0]);
        //System.out.println(l.get(0));
        Map m = new LinkedHashMap<String,String>();
        for(String str:l){
            if(str=="eventtime"){
                l.remove("eventtime");
            }else
            if(map.get(str)==null){
                m.put(str, "0");
            }else {
                m.put(str, map.get(str)[0]);
            }
        }
        iLogRepository.upData(m);
    }
}
