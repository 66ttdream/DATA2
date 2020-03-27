package data.gateways.datagateways;

import com.google.gson.Gson;
import data.entity.*;
import data.gateways.conf.WxConf;
import data.gateways.modle.*;
import data.usecase.exception.ApplicationException;
import data.usecase.port.IWxDataGateways;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.impl.WxMpDataCubeServiceImpl;
import util.Time;

import java.util.LinkedList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class WxDataGateways implements IWxDataGateways {
    private static Gson gson = new Gson();
    private static Date begindate = Time.generateSynTime();
    private static Date enddate = Time.generateSynTime();
   /*public static LinkedList get(SynParameter sp) throws WxErrorException {  //date需要工具类实现
        Gson gson = new Gson();
        var begindate = Time.generateSynTime();
        var enddate = Time.generateSynTime();
        LinkedList al = new LinkedList<Object>();
        var wxMpService = WxConf.init(sp);
        WxMpDataCubeServiceImpl wd = new WxMpDataCubeServiceImpl(wxMpService);
        var ArticleSummary = wd.getArticleSummary(begindate,enddate);//获取图文群发每日数据
        al.add(ArticleSummary);
        var ArticleTotal = wd.getArticleTotal(begindate,enddate);//获取图文群发总数据
        al.add(ArticleTotal);
        var InterfaceSummary = wd.getInterfaceSummary(begindate,enddate);//获取接口分析数据
        al.add(InterfaceSummary);
        var InterfaceSummaryHour = wd.getInterfaceSummaryHour(begindate,enddate);//获取接口分析分时数据
        al.add(InterfaceSummaryHour);
        var UpstreamMsg = wd.getUpstreamMsg(begindate,enddate);//获取消息发送概况数据
        al.add(UpstreamMsg);
        var UpstreamMsgDist = wd.getUpstreamMsgDist(begindate,enddate);//获取消息发送分布数据
        al.add(UpstreamMsgDist);
        var UpstreamMsgDistMonth = wd.getUpstreamMsgDistMonth(begindate,enddate);//获取消息发送分布月数据
        al.add(UpstreamMsgDistMonth);
        var UpstreamMsgDistWeek = wd.getUpstreamMsgDistWeek(begindate,enddate);//获取消息发送分布周数据
        al.add(UpstreamMsgDistWeek);
        var UpstreamMsgHour = wd.getUpstreamMsgHour(begindate,enddate);//获取消息分送分时数据
        al.add(UpstreamMsgHour);
        var UpstreamMsgMonth = wd.getUpstreamMsgMonth(begindate,enddate);//获取消息发送月数据
        al.add(UpstreamMsgMonth);
        var UpstreamMsgWeek = wd.getUpstreamMsgWeek(begindate,enddate);//获取消息发送周数据
        al.add(UpstreamMsgWeek);
        var UserCumulate = wd.getUserCumulate(begindate,enddate);//获取累计用户数据
        al.add(UserCumulate);
        var UserRead = wd.getUserRead(begindate,enddate);//获取图文统计数据
        al.add(UserRead);
        var UserReadHour = wd.getUserReadHour(begindate,enddate);//获取图文统计分时数据
        al.add(UserReadHour);
        var UserShare = wd.getUserShare(begindate,enddate);//获取图文分享转发数据
        al.add(UserShare);
        var UserShareHour = wd.getUserShareHour(begindate,enddate);//获取图文分享转发分时数据
        al.add(UserShareHour);
        var UserSummary = wd.getUserSummary(begindate,enddate);//获取用户增减数据
        //UserSummaryGateways userSummaryGateways = gson.fromJson(wd.getUserSummary(begindate,enddate).toString().replace("[","").replace("]",""),UserSummaryGateways.class);
        al.add(UserSummary);
        return al;

    }
*/
    @Override
    public List<ArticleSummary> getArticleSummary(SynParameter sp) throws ApplicationException {
        var wxMpService = WxConf.init(sp);
        WxMpDataCubeServiceImpl wd = new WxMpDataCubeServiceImpl(wxMpService);
        List<ArticleSummary> l = new LinkedList<ArticleSummary>();
        try {

            String jeson = wd.getArticleSummary(begindate,enddate).toString();//获取图文群发每日数据
            ArticleSummaryList list = gson.fromJson(jeson, ArticleSummaryList.class);
            ArticleSummaryGateways[] articleSummaryGateways = list.getList();
            for(ArticleSummaryGateways a : articleSummaryGateways){
                a.setAppid(sp.getSynParameterId().getAppId());
                ArticleSummary articleSummary = a.toArticleSummary();
                l.add(articleSummary);
            }

        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new ApplicationException(e.getError().getErrorCode(),e.getMessage());
        }
        return l;
    }
    @Deprecated
    @Override
    public List<ArticleTotal> getArticleTotal(SynParameter sp) throws ApplicationException{
        var wxMpService = WxConf.init(sp);
        WxMpDataCubeServiceImpl wd = new WxMpDataCubeServiceImpl(wxMpService);
        try {
            var articleTotaly = wd.getArticleTotal(begindate,enddate);//获取图文群发总数据

        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new ApplicationException(e.getError().getErrorCode(),e.getMessage());
        }
        return null;
    }

    @Override
    public List<InterfaceSummary> getInterfaceSummary(SynParameter sp)throws ApplicationException {
        var wxMpService = WxConf.init(sp);
        WxMpDataCubeServiceImpl wd = new WxMpDataCubeServiceImpl(wxMpService);
        List<InterfaceSummary> l = new LinkedList<InterfaceSummary>();
        try {
            String jeson = wd.getInterfaceSummary(begindate,enddate).toString();//获取接口分析数据
            InterfaceSummaryList list = gson.fromJson(jeson, InterfaceSummaryList.class);
            InterfaceSummaryGateways[] interfaceSummaryGateways = list.getList();
            for(InterfaceSummaryGateways a : interfaceSummaryGateways){
                a.setAppid(sp.getSynParameterId().getAppId());
                InterfaceSummary interfaceSummary = a.toInterfaceSummary();
                l.add(interfaceSummary);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new ApplicationException(e.getError().getErrorCode(),e.getMessage());
        }
        return l;
    }

    @Override
    public List<InterfaceSummaryHour> getInterfaceSummaryHour(SynParameter sp)throws ApplicationException {
        var wxMpService = WxConf.init(sp);
        WxMpDataCubeServiceImpl wd = new WxMpDataCubeServiceImpl(wxMpService);
        List<InterfaceSummaryHour> l = new LinkedList<InterfaceSummaryHour>();
        try {
            String jeson = wd.getInterfaceSummaryHour(begindate,enddate).toString();//获取接口分析分时数据
            InterfaceSummaryHourList list = gson.fromJson(jeson, InterfaceSummaryHourList.class);
            InterfaceSummaryHourGateways[] interfaceSummaryHourGateways = list.getList();
            for(InterfaceSummaryHourGateways a : interfaceSummaryHourGateways){
                a.setAppid(sp.getSynParameterId().getAppId());
                InterfaceSummaryHour interfaceSummaryHour = a.toInterfaceSummaryHour();
                l.add(interfaceSummaryHour);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new ApplicationException(e.getError().getErrorCode(),e.getMessage());
        }
        return null;
    }

    @Override
    public List<UpstreamMsg> getUpstreamMsg(SynParameter sp)throws ApplicationException {
        var wxMpService = WxConf.init(sp);
        WxMpDataCubeServiceImpl wd = new WxMpDataCubeServiceImpl(wxMpService);
        List<UpstreamMsg> l = new LinkedList<UpstreamMsg>();
        try {
            String  json = wd.getUpstreamMsg(begindate,enddate).toString();//获取消息发送概况数据
            UpstreamMsgList list = gson.fromJson(json, UpstreamMsgList.class);
            UpstreamMsgGateways[] upstreamMsgGateways = list.getList();
            for(UpstreamMsgGateways a : upstreamMsgGateways){
                a.setAppid(sp.getSynParameterId().getAppId());
                UpstreamMsg upstreamMsg = a.toUpstreamMsg();
                l.add(upstreamMsg);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new ApplicationException(e.getError().getErrorCode(),e.getMessage());
        }
        return l;
    }

    @Override
    public List<UpstreamMsgDist> getUpstreamMsgDist(SynParameter sp)throws ApplicationException {
        var wxMpService = WxConf.init(sp);
        WxMpDataCubeServiceImpl wd = new WxMpDataCubeServiceImpl(wxMpService);
        List<UpstreamMsgDist> l = new LinkedList<UpstreamMsgDist>();
        try {
            String json = wd.getUpstreamMsgDist(begindate,enddate).toString();//获取消息发送分布数据
            UpstreamMsgDistList list = gson.fromJson(json, UpstreamMsgDistList.class);
            UpstreamMsgDistGateways[] upstreamMsgDistGateways = list.getList();
            for(UpstreamMsgDistGateways a : upstreamMsgDistGateways){
                a.setAppid(sp.getSynParameterId().getAppId());
                UpstreamMsgDist upstreamMsgDist = a.toUpstreamMsgDist();
                l.add(upstreamMsgDist);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new ApplicationException(e.getError().getErrorCode(),e.getMessage());
        }
        return l;
    }

    @Override
    public List<UpstreamMsgDistMonth> getUpstreamMsgDistMonth(SynParameter sp) throws ApplicationException{
        var wxMpService = WxConf.init(sp);
        WxMpDataCubeServiceImpl wd = new WxMpDataCubeServiceImpl(wxMpService);
        List<UpstreamMsgDistMonth> l = new LinkedList<UpstreamMsgDistMonth>();
        try {
            String  json = wd.getUpstreamMsgDistMonth(begindate,enddate).toString();//获取消息发送分布月数据
            UpstreamMsgDistMonthList list = gson.fromJson(json, UpstreamMsgDistMonthList.class);
            UpstreamMsgDistMonthGateways[] upstreamMsgDistMonthGateways = list.getList();
            for(UpstreamMsgDistMonthGateways a : upstreamMsgDistMonthGateways){
                a.setAppid(sp.getSynParameterId().getAppId());
                UpstreamMsgDistMonth upstreamMsgdistMonth = a.toUpstreamMsgDistMonth();
                l.add(upstreamMsgdistMonth);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new ApplicationException(e.getError().getErrorCode(),e.getMessage());
        }
        return l;
    }

    @Override
    public List<UpstreamMsgDistWeek> getUpstreamMsgDistWeek(SynParameter sp) throws ApplicationException{
        var wxMpService = WxConf.init(sp);
        WxMpDataCubeServiceImpl wd = new WxMpDataCubeServiceImpl(wxMpService);
        List<UpstreamMsgDistWeek> l = new LinkedList<UpstreamMsgDistWeek>();
        try {
            String json = wd.getUpstreamMsgDistWeek(begindate,enddate).toString();//获取消息发送分布周数据
            UpstreamMsgDistWeekList list = gson.fromJson(json, UpstreamMsgDistWeekList.class);
            UpstreamMsgDistWeekGateways[] upstreamMsgDistWeekGateways = list.getList();
            for(UpstreamMsgDistWeekGateways a : upstreamMsgDistWeekGateways){
                a.setAppid(sp.getSynParameterId().getAppId());
                UpstreamMsgDistWeek upstreamMsgDistWeek = a.toUpstreamMsgDistWeek();
                l.add(upstreamMsgDistWeek);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new ApplicationException(e.getError().getErrorCode(),e.getMessage());
        }
        return l;
    }

    @Override
    public List<UpstreamMsgHour> getUpstreamMsgHour(SynParameter sp) throws ApplicationException{
        var wxMpService = WxConf.init(sp);
        WxMpDataCubeServiceImpl wd = new WxMpDataCubeServiceImpl(wxMpService);
        List<UpstreamMsgHour> l = new LinkedList<UpstreamMsgHour>();
        try {
            String json = wd.getUpstreamMsgHour(begindate,enddate).toString();//获取消息分送分时数据
            UpstreamMsgHourList list = gson.fromJson(json, UpstreamMsgHourList.class);
            UpstreamMsgHourGateways[] upstreamMsgHourGateways = list.getList();
            for(UpstreamMsgHourGateways a : upstreamMsgHourGateways){
                a.setAppid(sp.getSynParameterId().getAppId());
                UpstreamMsgHour upstreamMsgHour = a.toUpstreamMsgHour();
                l.add(upstreamMsgHour);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new ApplicationException(e.getError().getErrorCode(),e.getMessage());
        }
        return l;
    }

    @Override
    public List<UpstreamMsgMonth> getUpstreamMsgMonth(SynParameter sp) throws ApplicationException{
        var wxMpService = WxConf.init(sp);
        WxMpDataCubeServiceImpl wd = new WxMpDataCubeServiceImpl(wxMpService);
        List<UpstreamMsgMonth> l = new LinkedList<UpstreamMsgMonth>();
        try {
            String json = wd.getUpstreamMsgMonth(begindate,enddate).toString();//获取消息发送月数据
            UpstreamMsgMonthList list = gson.fromJson(json, UpstreamMsgMonthList.class);
            UpstreamMsgMonthGateways[] upstreamMsgMonthGateways = list.getList();
            for(UpstreamMsgMonthGateways a : upstreamMsgMonthGateways){
                a.setAppid(sp.getSynParameterId().getAppId());
                UpstreamMsgMonth upstreamMsgMonth = a.toUpstreamMsgMonth();
                l.add(upstreamMsgMonth);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new ApplicationException(e.getError().getErrorCode(),e.getMessage());
        }
        return l;
    }

    @Override
    public List<UpstreamMsgWeek> getUpstreamMsgWeek(SynParameter sp) throws ApplicationException{
        var wxMpService = WxConf.init(sp);
        WxMpDataCubeServiceImpl wd = new WxMpDataCubeServiceImpl(wxMpService);
        List<UpstreamMsgWeek> l = new LinkedList<UpstreamMsgWeek>();
        try {
            String json = wd.getUpstreamMsgWeek(begindate,enddate).toString();//获取消息发送周数据
            UpstreamMsgWeekList list = gson.fromJson(json, UpstreamMsgWeekList.class);
            UpstreamMsgWeekGateways[] upstreamMsgWeekGateways = list.getList();
            for(UpstreamMsgWeekGateways a : upstreamMsgWeekGateways){
                a.setAppid(sp.getSynParameterId().getAppId());
                UpstreamMsgWeek upstreamMsgWeek = a.toUpstreamMsgWeek();
                l.add(upstreamMsgWeek);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new ApplicationException(e.getError().getErrorCode(),e.getMessage());
        }
        return l;
    }

    @Override
    public List<UserCumulate> getUserCumulate(SynParameter sp) throws ApplicationException{
        var wxMpService = WxConf.init(sp);
        WxMpDataCubeServiceImpl wd = new WxMpDataCubeServiceImpl(wxMpService);
        List<UserCumulate> l = new LinkedList<UserCumulate>();
        try {
            String json = wd.getUserCumulate(begindate,enddate).toString();//获取累计用户数据
            UserCumulateList list = gson.fromJson(json, UserCumulateList.class);
            UserCumulateGateways[] userCumulateGateways = list.getList();
            for(UserCumulateGateways a : userCumulateGateways){
                a.setAppid(sp.getSynParameterId().getAppId());
                UserCumulate userCumulate = a.toUserCumulate();
                l.add(userCumulate);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new ApplicationException(e.getError().getErrorCode(),e.getMessage());
        }
        return l;
    }

    @Override
    public List<UserRead> getUserRead(SynParameter sp) throws ApplicationException{
        var wxMpService = WxConf.init(sp);
        WxMpDataCubeServiceImpl wd = new WxMpDataCubeServiceImpl(wxMpService);
        List<UserRead> l = new LinkedList<UserRead>();
        try {
            String json = wd.getUserRead(begindate,enddate).toString();//获取图文统计数据
            UserReadList list = gson.fromJson(json, UserReadList.class);
            UserReadGateways[] userReadGateways = list.getList();
            for(UserReadGateways a : userReadGateways){
                a.setAppid(sp.getSynParameterId().getAppId());
                UserRead userRead = a.toUserRead();
                l.add(userRead);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new ApplicationException(e.getError().getErrorCode(),e.getMessage());
        }
        return l;
    }

    @Override
    public List<UserReadHour> getUserReadHour(SynParameter sp) throws ApplicationException{
        var wxMpService = WxConf.init(sp);
        WxMpDataCubeServiceImpl wd = new WxMpDataCubeServiceImpl(wxMpService);
        List<UserReadHour> l = new LinkedList<UserReadHour>();
        try {
            String json = wd.getUserReadHour(begindate,enddate).toString();//获取图文统计分时数据
            UserReadHourList list = gson.fromJson(json, UserReadHourList.class);
            UserReadHourGateways[] userReadHourGateways = list.getList();
            for(UserReadHourGateways a : userReadHourGateways){
                a.setAppid(sp.getSynParameterId().getAppId());
                UserReadHour userReadHour = a.toUserReadHour();
                l.add(userReadHour);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new ApplicationException(e.getError().getErrorCode(),e.getMessage());
        }
        return l;
    }

    @Override
    public List<UserShare> getUserShare(SynParameter sp) throws ApplicationException{
        var wxMpService = WxConf.init(sp);
        WxMpDataCubeServiceImpl wd = new WxMpDataCubeServiceImpl(wxMpService);
        List<UserShare> l = new LinkedList<UserShare>();
        try {
            String json = wd.getUserShare(begindate,enddate).toString();//获取图文分享转发数据
            UserShareList list = gson.fromJson(json, UserShareList.class);
            UserShareGateways[] userShareGateways = list.getList();
            for(UserShareGateways a : userShareGateways){
                a.setAppid(sp.getSynParameterId().getAppId());
                UserShare userShare = a.toUserShare();
                l.add(userShare);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new ApplicationException(e.getError().getErrorCode(),e.getMessage());
        }
        return null;
    }

    @Override
    public List<UserShareHour> getUserShareHour(SynParameter sp) throws ApplicationException{
        var wxMpService = WxConf.init(sp);
        WxMpDataCubeServiceImpl wd = new WxMpDataCubeServiceImpl(wxMpService);
        List<UserShareHour> l = new LinkedList<UserShareHour>();
        try {
            String json = wd.getUserShareHour(begindate,enddate).toString();//获取图文分享转发分时数据
            UserShareHourList list = gson.fromJson(json, UserShareHourList.class);
            UserShareHourGateways[] userShareHourGateways = list.getList();
            for(UserShareHourGateways a : userShareHourGateways){
                a.setAppid(sp.getSynParameterId().getAppId());
                UserShareHour userShareHour = a.toUserShareHour();
                l.add(userShareHour);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new ApplicationException(e.getError().getErrorCode(),e.getMessage());
        }
        return null;
    }

    @Override
    public List<UserSummary> getUserSummary(SynParameter sp) throws ApplicationException{
        var wxMpService = WxConf.init(sp);
        WxMpDataCubeServiceImpl wd = new WxMpDataCubeServiceImpl(wxMpService);
        List<UserSummary> l = new LinkedList<UserSummary>();
        try {
            String json = wd.getUserSummary(begindate,enddate).toString();//获取用户增减数据
            UserSummaryList list = gson.fromJson(json, UserSummaryList.class);
            UserSummaryGateways[] userSummaryGateways = list.getList();
            for(UserSummaryGateways a : userSummaryGateways){
                a.setAppid(sp.getSynParameterId().getAppId());
                UserSummary userSummary = a.toUserSummary();
                l.add(userSummary);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new ApplicationException(e.getError().getErrorCode(),e.getMessage());
        }
        return null;
    }
}
