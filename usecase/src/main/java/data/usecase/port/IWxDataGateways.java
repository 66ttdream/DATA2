package data.usecase.port;

import data.entity.*;
import data.usecase.exception.ApplicationException;

import java.util.List;

public interface IWxDataGateways {
    public List<ArticleSummary> getArticleSummary(SynParameter sp) throws ApplicationException;
    public List<ArticleTotal> getArticleTotal(SynParameter sp) throws ApplicationException;
    public List<InterfaceSummary> getInterfaceSummary(SynParameter sp) throws ApplicationException;
    public List<InterfaceSummaryHour> getInterfaceSummaryHour(SynParameter sp) throws ApplicationException;
    public List<UpstreamMsg> getUpstreamMsg(SynParameter sp) throws ApplicationException;
    public List<UpstreamMsgDist> getUpstreamMsgDist(SynParameter sp) throws ApplicationException;
    public List<UpstreamMsgDistMonth> getUpstreamMsgDistMonth(SynParameter sp) throws ApplicationException;
    public List<UpstreamMsgDistWeek> getUpstreamMsgDistWeek(SynParameter sp) throws ApplicationException;
    public List<UpstreamMsgHour> getUpstreamMsgHour(SynParameter sp) throws ApplicationException;
    public List<UpstreamMsgMonth> getUpstreamMsgMonth(SynParameter sp) throws ApplicationException;
    public List<UpstreamMsgWeek> getUpstreamMsgWeek(SynParameter sp) throws ApplicationException;
    public List<UserCumulate> getUserCumulate(SynParameter sp) throws ApplicationException;
    public List<UserRead> getUserRead(SynParameter sp) throws ApplicationException;
    public List<UserReadHour> getUserReadHour(SynParameter sp) throws ApplicationException;
    public List<UserShare> getUserShare(SynParameter sp)throws ApplicationException;
    public List<UserShareHour> getUserShareHour(SynParameter sp)throws ApplicationException;
    public List<UserSummary> getUserSummary(SynParameter sp)throws ApplicationException;

}
