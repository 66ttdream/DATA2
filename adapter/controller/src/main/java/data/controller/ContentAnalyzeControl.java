package data.controller;

import data.analyzeentity.HeatworkOfUser;
import data.analyzeentity.ShareNum;
import data.analyzeentity.ShareRate;
import data.analyzeentity.TwiceShareRate;
import data.controller.modle.ContentShareNum;
import data.controller.modle.ContentShareRate;
import data.controller.modle.ContentTwiceShareRate;
import data.controller.modle.Heatwork;
import data.usecase.*;
import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.List;
@AllArgsConstructor
public class ContentAnalyzeControl {
    private PractitionerFindHeatwork practitionerFindHeatwork;
    private ManagerFindHeatwork managerFindHeatwork;
    private ManagerFindShareNum managerFindShareNum;
    private PractitionerFindShareNum practitionerFindShareNum;
    private ManagerFindShareRate managerFindShareRate;
    private PractitionerFindShareRate practitionerFindShareRate;
    private ManagerFindTwiceShareRate managerFindTwiceShareRate;
    private PractitionerFindTwiceShareRate practitionerFindTwiceShareRate;

    /**
     *作者获取其作品及被浏览数排行
     * @param userId 作者ID
     * @param pageNum  页码
     * @param pageSize  页面显示条数
     * @return
     */
    public List<Heatwork> getHeatwork(int userId, int pageNum, int pageSize){
        List<HeatworkOfUser> list = practitionerFindHeatwork.execut(userId,pageNum,pageSize);
        List<Heatwork> l = new LinkedList<Heatwork>();
        for(HeatworkOfUser heatworkOfUser: list ){
            Heatwork heatwork =  Heatwork.builder()
                    .contentName(heatworkOfUser.getContentName())
                    .pageView(heatworkOfUser.getPageView())
                    .build();
            l.add(heatwork);
        }
        return l;
    }

    /**
     *获取所有作品及其浏览数排行
     * @param pageNum 页码
     * @param pageSize 页面显示条数
     * @return
     */
    public List<Heatwork> getAllHeatwork(int pageNum, int pageSize) {
        List<Heatwork> l = new LinkedList<Heatwork>();
        List<HeatworkOfUser> list = managerFindHeatwork.execut(pageNum, pageSize);
        for (HeatworkOfUser heatworkOfUser : list) {
            Heatwork heatwork = Heatwork.builder()
                    .contentName(heatworkOfUser.getContentName())
                    .pageView(heatworkOfUser.getPageView())
                    .build();
            l.add(heatwork);
        }
        return l;
    }

    /**
     *获取所有作品被分享数排行
     * @param pageNum 页码
     * @param pageSize 页面显示条数
     * @return
     */
    public List<ContentShareNum> getAllShareNum(int pageNum, int pageSize){
        List<ContentShareNum> l = new LinkedList<ContentShareNum>();
        List<ShareNum> list = managerFindShareNum.execut(pageNum, pageSize);
        for (ShareNum shareNum : list) {
            ContentShareNum contentShareNum = ContentShareNum.builder()
                    .contentName(shareNum.getContentName())
                    .shareTime(shareNum.getShareTime())
                    .build();
            l.add(contentShareNum);
        }
        return l;
    }
    /**
     *作者获取作品被分享数排行
     * @param userId 作者ID
     * @param pageNum  页码
     * @param pageSize  页面显示条数
     * @return
     */
    public List<ContentShareNum> getShareNum(int userId,int pageNum, int pageSize){
        List<ContentShareNum> l = new LinkedList<ContentShareNum>();
        List<ShareNum> list = practitionerFindShareNum.execut(userId,pageNum, pageSize);
        for (ShareNum shareNum : list) {
            ContentShareNum contentShareNum = ContentShareNum.builder()
                    .contentName(shareNum.getContentName())
                    .shareTime(shareNum.getShareTime())
                    .build();
            l.add(contentShareNum);
        }
        return l;
    }

    /**
     * 获取所有内容的分享率
     * @return
     */
    public List<ContentShareRate>  getAllShareRate(){
        List<ShareRate> list = managerFindShareRate.execut();
        List<ContentShareRate> l = new LinkedList<ContentShareRate>();
        for(ShareRate shareRate: list ){
            ContentShareRate contentShareRate =  ContentShareRate.builder()
                    .shareNum(shareRate.getShareNum())
                    .contentName(shareRate.getContentName())
                    .viewNum(shareRate.getViewNum())
                    .build();
            l.add(contentShareRate);
        }
        return l;
    }

    /**
     * 获取作者其作品的分享率
     * @param userId
     * @return
     */
    public List<ContentShareRate> getShareRate(int userId){
        List<ShareRate> list = practitionerFindShareRate.execut(userId);
        List<ContentShareRate> l = new LinkedList<ContentShareRate>();
        for(ShareRate shareRate: list ){
            ContentShareRate contentShareRate =  ContentShareRate.builder()
                    .contentName(shareRate.getContentName())
                    .shareNum(shareRate.getShareNum())
                    .viewNum(shareRate.getViewNum())
                    .build();
            l.add(contentShareRate);
        }
        return l;
    }

    /**
     * 获取从业者作品的分享率
     * @param userId 用户（从业者）id
     * @return
     */
    public List<ContentTwiceShareRate> getTwiceShareRate(int userId){
        List<TwiceShareRate> list = practitionerFindTwiceShareRate.execut(userId);
        List<ContentTwiceShareRate> l = new LinkedList<ContentTwiceShareRate>();
        for(TwiceShareRate twiceShareRate: list ){
            ContentTwiceShareRate contentTwiceShareRate =  ContentTwiceShareRate.builder()
                    .contentName(twiceShareRate.getContentName())
                    .shareNum(twiceShareRate.getShareNum())
                    .twiceShareNum(twiceShareRate.getTwiceShareNum())
                    .build();
            l.add(contentTwiceShareRate);
        }
        return l;

    }
    public List<ContentTwiceShareRate> getAllTwiceShareRate(){
        List<TwiceShareRate> list = managerFindTwiceShareRate.execut();
        List<ContentTwiceShareRate> l = new LinkedList<ContentTwiceShareRate>();
        for(TwiceShareRate twiceShareRate: list ){
            ContentTwiceShareRate contentTwiceShareRate =  ContentTwiceShareRate.builder()
                    .contentName(twiceShareRate.getContentName())
                    .shareNum(twiceShareRate.getShareNum())
                    .twiceShareNum(twiceShareRate.getTwiceShareNum())
                    .build();
            l.add(contentTwiceShareRate);
        }
        return l;

    }
}
