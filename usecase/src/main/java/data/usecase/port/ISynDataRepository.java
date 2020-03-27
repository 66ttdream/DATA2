package data.usecase.port;

import data.entity.*;

public interface ISynDataRepository {
    public void insertArticleSummary(ArticleSummary articleSummary);
    public void insertInterfaceSummary(InterfaceSummary interfaceSummary);
    public void insertInterfaceSummaryHour(InterfaceSummaryHour interfaceSummaryHour);
    public void insertUpstreamMsg(UpstreamMsg upstreamMsg);
    public void insertUpstreamMsgDist(UpstreamMsgDist upstreamMsgDist);
    public void insertUpstreamMsgDistMonth(UpstreamMsgDistMonth upstreamMsgDistMonth);
    public void insertUpstreamMsgDistWeek(UpstreamMsgDistWeek upstreamMsgDistWeek);
    public void insertUpstreamMsgHour(UpstreamMsgHour upstreamMsgHour);
    public void insertUpstreamMsgMonth(UpstreamMsgMonth upstreamMsgMonth);
    public void insertUpstreamMsgWeeK(UpstreamMsgWeek upstreamMsgWeek);
    public void insertUserCumulate(UserCumulate userCumulate);
    public void insertUserRead(UserRead userRead);
    public void insertUserReadHour(UserReadHour userReadHour);
    public void insertUserShare(UserShare userShare);
    public void insertUserShareHour(UserShareHour userShareHour);
    public void insertUserSummary(UserSummary userSummary);
    public void insertSynLog(SynLog synLog);
}
