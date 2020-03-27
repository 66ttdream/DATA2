package data.spring.controller;

import data.controller.ContentAnalyzeControl;
import data.controller.modle.ContentShareNum;
import data.controller.modle.ContentShareRate;
import data.controller.modle.ContentTwiceShareRate;
import data.controller.modle.Heatwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "analyses")
@RestController
public class ContentAnalyzeController {
    private ContentAnalyzeControl ContentanalyzeControl;

    @Autowired
    public ContentAnalyzeController(ContentAnalyzeControl contentAnalyzeControl){
        this.ContentanalyzeControl = contentAnalyzeControl;
    }

    /**
     * 获取个人作品热度排行榜
     * @param userId 作者id
     * @param pageNum 页码
     * @param pageSize 页面条数
     * @return
     */
    @GetMapping(value = "heatwork/practitioner/{userid}/{pagenum}/{pagesize}")
    public List<Heatwork> getHeatwork(@PathVariable("userid") int userId, @PathVariable("pagenum") int pageNum, @PathVariable("pagesize") int pageSize){
        return ContentanalyzeControl.getHeatwork(userId,pageNum,pageSize);
    }

    /**
     * 获取全部作品排行榜
     * @param pageNum 页码
     * @param pageSize 页面条数
     * @return
     */
    @GetMapping(value = "heatwork/manager/{pagenum}/{pagesize} ")
    public List<Heatwork> getAllHeatwork(@PathVariable("pagenum") int pageNum, @PathVariable("pagesize") int pageSize){
        return ContentanalyzeControl.getAllHeatwork(pageNum,pageSize);
    }
    @GetMapping(value = "sharenum/practitioner/{userid}/{pagenum}/{pagesize}")
    public List<ContentShareNum> getShareNum(@PathVariable("userid") int userId,@PathVariable("pagenum") int pageNum, @PathVariable("pagesize") int pageSize){
        return ContentanalyzeControl.getShareNum(userId,pageNum,pageSize);
    }
    @GetMapping(value = "sharenum/manager/{pagenum}/{pagesize}")
    public List<ContentShareNum> getAllShareNum(@PathVariable("pagenum") int pageNum, @PathVariable("pagesize") int pageSize){
       return ContentanalyzeControl.getAllShareNum(pageNum,pageSize);
    }
    @GetMapping(value = "sharerate/practitioner/{userid}")
    public List<ContentShareRate> getShareRate(@PathVariable("userid") int userId){
        return ContentanalyzeControl.getShareRate(userId);
    }
    @GetMapping(value = "sharerate/manager/{userid}")
    public List<ContentShareRate> getAllShareRate(@PathVariable("userid") int userId){
        return ContentanalyzeControl.getAllShareRate();
    }
    @GetMapping(value = "twicesharerate/practitioner/{userid}")
    public List<ContentTwiceShareRate> getTwiceShareRate(@PathVariable("userid") int userId){
        return ContentanalyzeControl.getTwiceShareRate(userId);
    }
    @GetMapping(value = "twicesharerate/manager")
    public List<ContentTwiceShareRate> getAllTwiceShareRate(@PathVariable("userid") int userId){
        return ContentanalyzeControl.getAllTwiceShareRate();
    }

    @GetMapping(value = "/contentanalyze")
    public Map<String,Object> getPeriodAnalysisData(HttpServletRequest hsq){
        Map<String,String[]> map = hsq.getParameterMap();
        int pageNum = Integer.valueOf(map.get("pageNum")[0]);
        int pageSize =  Integer.valueOf(map.get("pageSize")[0]);
        int userId = Integer.valueOf(map.get("userId")[0]);
        Map rmap = new HashMap();
        //List<Heatwork> l = ContentanalyzeControl.getAllHeatwork(pageNum,pageSize);
        rmap.put("heatwork",ContentanalyzeControl.getHeatwork(userId,pageNum,pageSize));
        rmap.put("allheatwork",ContentanalyzeControl.getAllHeatwork(pageNum,pageSize));
        rmap.put("sharenum",ContentanalyzeControl.getShareNum(userId,pageNum,pageSize));
        rmap.put("allsharenum",ContentanalyzeControl.getAllShareNum(pageNum,pageSize));
        rmap.put("sharerate",ContentanalyzeControl.getShareRate(userId));
        rmap.put("allsharerate",ContentanalyzeControl.getAllShareRate());
        rmap.put("twicesharerate",ContentanalyzeControl.getTwiceShareRate(userId));
        rmap.put("alltwicesharerate",ContentanalyzeControl.getAllTwiceShareRate());
        return rmap;
    }
    @PostMapping(value = "/test2")
    public Map<String,Object> test2(){
        ContentTwiceShareRate c = new ContentTwiceShareRate();
        ContentShareRate c2 = new ContentShareRate();
        Map<String,Object> map = new HashMap();
        List l = new LinkedList();
        l.add(c);
        l.add(c);
        map.put("c1",l);
        map.put("c2",c2);
        return map;
    }
}
