package data.repository.syndata;

import data.entity.*;
import data.repository.db.Databases;
import data.usecase.port.ISynDataRepository;



public class SynDataRepository implements ISynDataRepository {

    @Override
    public void insertArticleSummary(ArticleSummary articleSummary) {
        var sql = "INSERT INTO GW_WX_ARTICLESUMMARY (appid,ref_date,msgid,title,int_page_read_user,int_page_read_count,ori_page_read_user,ori_page_read_count,share_user,share_count,add_to_fav_user,add_to_fav_count) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        Databases.getDb()
                .update(sql)
                .parameters(articleSummary.getAppid().getAppId(),articleSummary.getRefDate(),articleSummary.getMsgId(),articleSummary.getTitle(),articleSummary.getIntPageReadUser(),articleSummary.getIntPageReadCount(),articleSummary.getOriPageReadUser(),articleSummary.getOriPageReadCount(),articleSummary.getShareUser(),articleSummary.getShareCount(),articleSummary.getAddToFavUser(),articleSummary.getAddToFavCount())
                .complete()
                .blockingAwait();
    }

    @Override
    public void insertInterfaceSummary(InterfaceSummary interfaceSummary) {
        var sql = "INSERT INTO GW_WX_INTERFACESUMMARY(appid,ref_date,callback_count,fail_count,total_time_cost,max_time_cost) VALUES(?,?,?,?,?,?)";
        Databases.getDb()
                .update(sql)
                .parameters(interfaceSummary.getAppid().getAppId(),interfaceSummary.getRefDate(),interfaceSummary.getCallbackCount(),interfaceSummary.getFailCount(),interfaceSummary.getTotalTimeCost(),interfaceSummary.getMaxTimeCost())
                .complete()
                .blockingAwait();

    }

    @Override
    public void insertInterfaceSummaryHour(InterfaceSummaryHour interfaceSummaryHour) {
        var sql = "INSERT INTO GW_WX_INTERFACESUMMARYHOUR (appid,ref_date,ref_hour,callback_count,fail_count,total_time_cost,max_time_cost) VALUES (?,?,?,?,?,?,?);";
        Databases.getDb()
                .update(sql)
                .parameters(interfaceSummaryHour.getAppid().getAppId(),interfaceSummaryHour.getRefDate(),interfaceSummaryHour.getRefHour(),interfaceSummaryHour.getCallbackCount(),interfaceSummaryHour.getFailCount(),interfaceSummaryHour.getTotalTimeCost(),interfaceSummaryHour.getMaxTimeCost())
                .complete()
                .blockingAwait();

    }

    @Override
    public void insertUpstreamMsg(UpstreamMsg upstreamMsg) {
        var sql = "INSERT INTO GW_WX_UPSTREAMMSG (appid,ref_date,msg_type,msg_user,msg_count) VALUES(?,?,?,?,?)";
        Databases.getDb()
                .update(sql)
                .parameters(upstreamMsg.getAppid().getAppId(),upstreamMsg.getRefDate(),upstreamMsg.getMsgType(),upstreamMsg.getMsgUser(),upstreamMsg.getMsgCount())
                .complete()
                .blockingAwait();

    }

    @Override
    public void insertUpstreamMsgDist(UpstreamMsgDist upstreamMsgDist) {
        var sql = "INSERT INTO GW_WX_UPSTREAMMSGDIST (appid,ref_date,count_interval,msg_user) VALUES (?,?,?,?)";
        Databases.getDb()
                .update(sql)
                .parameters(upstreamMsgDist.getAppid().getAppId(),upstreamMsgDist.getRefDate(),upstreamMsgDist.getCountInterval(),upstreamMsgDist.getMsgUser())
                .complete()
                .blockingAwait();

    }

    @Override
    public void insertUpstreamMsgDistMonth(UpstreamMsgDistMonth upstreamMsgDistMonth) {
        var sql = "INSERT INTO GW_WX_UPSTREAMMSGDISTMONTH (appid,ref_date,count_interval,msg_user) VALUES(?,?,?,?)";
        Databases.getDb()
                .update(sql)
                .parameters(upstreamMsgDistMonth.getAppid().getAppId(),upstreamMsgDistMonth.getRefDate(),upstreamMsgDistMonth.getCountInterval(),upstreamMsgDistMonth.getMsgUser())
                .complete()
                .blockingAwait();

    }

    @Override
    public void insertUpstreamMsgDistWeek(UpstreamMsgDistWeek upstreamMsgDistWeek) {
        var sql = "INSERT INTO GW_WX_UPSTREAMMSGDISTWEEK (appid,ref_date,count_interval,msg_user) VALUES(?,?,?,?)";
        Databases.getDb()
                .update(sql)
                .parameters(upstreamMsgDistWeek.getAppid().getAppId(),upstreamMsgDistWeek.getRefDate(),upstreamMsgDistWeek.getCountInterval(),upstreamMsgDistWeek.getMsgUser())
                .complete()
                .blockingAwait();

    }

    @Override
    public void insertUpstreamMsgHour(UpstreamMsgHour upstreamMsgHour) {
        var sql = "INSERT INTO GW_WX_UPSTREAMMSGHOUR (appid,ref_date,ref_hour,msg_type,msg_user,msg_count) VALUES(?,?,?,?,?,?)";
        Databases.getDb()
                .update(sql)
                .parameters(upstreamMsgHour.getAppid().getAppId(),upstreamMsgHour.getRefDate(),upstreamMsgHour.getRefHour(),upstreamMsgHour.getMsgType(),upstreamMsgHour.getMsgUser(),upstreamMsgHour.getMsgCount())
                .complete()
                .blockingAwait();

    }

    @Override
    public void insertUpstreamMsgMonth(UpstreamMsgMonth upstreamMsgMonth) {
        var sql = "INSERT INTO GW_WX_UPSTREAMMSGMONTH (appid,ref_date,msg_type,msg_user,msg_count) VALUES(?,?,?,?,?)";
        Databases.getDb()
                .update(sql)
                .parameters(upstreamMsgMonth.getAppid().getAppId(),upstreamMsgMonth.getRefDate(),upstreamMsgMonth.getMsgType(),upstreamMsgMonth.getMsgUser(),upstreamMsgMonth.getMsgCount())
                .complete()
                .blockingAwait();

    }

    @Override
    public void insertUpstreamMsgWeeK(UpstreamMsgWeek upstreamMsgWeek) {
        var sql = "INSERT INTO GW_WX_UPSTREAMMSGMONTH (appid,ref_date,msg_type,msg_user,msg_count) VALUES(?,?,?,?,?)";
        Databases.getDb()
                .update(sql)
                .parameters(upstreamMsgWeek.getAppid().getAppId(),upstreamMsgWeek.getRefDate(),upstreamMsgWeek.getMsgType(),upstreamMsgWeek.getMsgUser(),upstreamMsgWeek.getMsgCount())
                .complete()
                .blockingAwait();

    }

    @Override
    public void insertUserCumulate(UserCumulate userCumulate) {
        var sql = "INSERT INTO GW_WX_USERCUMULATE (appid,ref_date,cumulate_user) VALUES(?,?,?)";
        Databases.getDb()
                .update(sql)
                .parameters(userCumulate.getAppid().getAppId(),userCumulate.getRefDate(),userCumulate.getCumulateUser())
                .complete()
                .blockingAwait();

    }

    @Override
    public void insertUserRead(UserRead userRead) {
        var sql = "INSERT INTO GW_WX_USERREAD (appid,ref_date,int_page_read_user,int_page_read_count,ori_page_read_user,ori_page_read_count,share_user,share_count,add_to_fav_user,add_to_fav_count) VALUES(?,?,?,?,?,?,?,?,?,?)";
        Databases.getDb()
                .update(sql)
                .parameters(userRead.getAppid().getAppId(),userRead.getRefDate(),userRead.getIntPageReadUser(),userRead.getIntPageReadCount(),userRead.getOriPageReadUser(),userRead.getOriPageReadCount(),userRead.getShareUser(),userRead.getShareCount(),userRead.getAddToFavUser(),userRead.getAddToFavCount())
                .complete()
                .blockingAwait();

    }

    @Override
    public void insertUserReadHour(UserReadHour userReadHour) {
        var sql = "INSERT INTO GW_WX_USERREADHOUR (appid,ref_date,ref_hour,user_source,int_page_read_user,int_page_read_count,ori_page_read_user,ori_page_read_count,share_user,share_count,add_to_fav_user,add_to_fav_count) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        Databases.getDb()
                .update(sql)
                .parameters(userReadHour.getAppid().getAppId(),userReadHour.getRefHour(),userReadHour.getUserSource(),userReadHour.getIntPageReadUser(),userReadHour.getIntPageReadCount(),userReadHour.getOriPageReadUser(),userReadHour.getOriPageReadCount(),userReadHour.getShareUser(),userReadHour.getShareCount(),userReadHour.getAddToFavUser(),userReadHour.getAddToFavCount())
                .complete()
                .blockingAwait();

    }

    @Override
    public void insertUserShare(UserShare userShare) {
        var sql = "INSERT INTO GW_WX_USERSHARE (appid,ref_date,share_scene,share_count,share_user) VALUES (?,?,?,?,?)";
        Databases.getDb()
                .update(sql)
                .parameters(userShare.getAppid().getAppId(),userShare.getRefDate(),userShare.getShareScene(),userShare.getShareCount(),userShare.getShareUser())
                .complete()
                .blockingAwait();

    }

    @Override
    public void insertUserShareHour(UserShareHour userShareHour) {
        var sql = "INSERT INTO GW_WX_USERSHAREHOUR (appid,ref_date,ref_hour,share_scene,share_count,share_user) VALUES (?,?,?,?,?,?)";
        Databases.getDb()
                .update(sql)
                .parameters(userShareHour.getAppid().getAppId(),userShareHour.getRefDate(),userShareHour.getRefHour(),userShareHour.getShareScene(),userShareHour.getShareCount(),userShareHour.getShareUser())
                .complete()
                .blockingAwait();

    }

    @Override
    public void insertUserSummary(UserSummary userSummary) {
        var sql = "INSERT INTO GW_WX_USERSUMMARY (appid,ref_date,user_source,new_user,cancel_user) VALUES (?,?,?,?,?)";
        Databases.getDb()
                .update(sql)
                .parameters(userSummary.getAppid().getAppId(),userSummary.getRefDate(),userSummary.getUserSource(),userSummary.getNewUser(),userSummary.getCancelUser())
                .complete()
                .blockingAwait();

    }
    @Override
    public void insertSynLog(SynLog synLog){
        var sql = "INSERT INTO D_SYNLOG (appid,datatime,excutecontent,executtime,status) VALUES (?,?,?,?,?)";
        Databases.getDb()
                .update(sql)
                .parameters(synLog.getAppid().getAppId(),new java.sql.Timestamp(synLog.getDataTime().getTime()),synLog.getExcutContent(),synLog.getExecutTime(),synLog.getStatus())
                .complete()
                .blockingAwait();

    }

}
