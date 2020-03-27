package data.usecase;

import data.entity.*;
import data.usecase.exception.ApplicationException;
import data.usecase.port.ISynDataRepository;
import data.usecase.port.IWxDataGateways;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TimingSaveData {
    private IWxDataGateways iWxDataGateways;
    private ISynDataRepository iSynDataRepository;

    public void execut(SynParameter synParameter) throws ApplicationException{

            List<ArticleSummary> articleSummaryList = iWxDataGateways.getArticleSummary(synParameter);
            for (ArticleSummary articleSummary : articleSummaryList) {
                iSynDataRepository.insertArticleSummary(articleSummary);
            }
            //补充ArticleTotal的存储
            List<InterfaceSummary> interfaceSummaryList = iWxDataGateways.getInterfaceSummary(synParameter);
            for (InterfaceSummary interfaceSummary : interfaceSummaryList) {
                iSynDataRepository.insertInterfaceSummary(interfaceSummary);
            }
            List<InterfaceSummaryHour> interfaceSummaryHourList = iWxDataGateways.getInterfaceSummaryHour(synParameter);
            for (InterfaceSummaryHour interfaceSummaryHour : interfaceSummaryHourList) {
                iSynDataRepository.insertInterfaceSummaryHour(interfaceSummaryHour);
            }
            List<UpstreamMsg> upstreamMsgList = iWxDataGateways.getUpstreamMsg(synParameter);
            for (UpstreamMsg upstreamMsg : upstreamMsgList) {
                iSynDataRepository.insertUpstreamMsg(upstreamMsg);
            }
            List<UpstreamMsgDist> upstreamMsgDistList = iWxDataGateways.getUpstreamMsgDist(synParameter);
            for (UpstreamMsgDist upstreamMsgDist : upstreamMsgDistList) {
                iSynDataRepository.insertUpstreamMsgDist(upstreamMsgDist);
            }
            List<UpstreamMsgDistMonth> upstreamMsgDistMonthList = iWxDataGateways.getUpstreamMsgDistMonth(synParameter);
            for (UpstreamMsgDistMonth upstreamMsgDistMonth : upstreamMsgDistMonthList) {
                iSynDataRepository.insertUpstreamMsgDistMonth(upstreamMsgDistMonth);
            }
            List<UpstreamMsgDistWeek> upstreamMsgDistWeekList = iWxDataGateways.getUpstreamMsgDistWeek(synParameter);
            for (UpstreamMsgDistWeek upstreamMsgDistWeek : upstreamMsgDistWeekList) {
                iSynDataRepository.insertUpstreamMsgDistWeek(upstreamMsgDistWeek);
            }
            List<UpstreamMsgHour> upstreamMsgHourList = iWxDataGateways.getUpstreamMsgHour(synParameter);
            for (UpstreamMsgHour upstreamMsgHour : upstreamMsgHourList) {
                iSynDataRepository.insertUpstreamMsgHour(upstreamMsgHour);
            }
            List<UpstreamMsgMonth> upstreamMsgMonthList = iWxDataGateways.getUpstreamMsgMonth(synParameter);
            for (UpstreamMsgMonth upstreamMsgMonth : upstreamMsgMonthList) {
                iSynDataRepository.insertUpstreamMsgMonth(upstreamMsgMonth);
            }
            List<UpstreamMsgWeek> upstreamMsgWeekList = iWxDataGateways.getUpstreamMsgWeek(synParameter);
            for (UpstreamMsgWeek upstreamMsgWeek : upstreamMsgWeekList) {
                iSynDataRepository.insertUpstreamMsgWeeK(upstreamMsgWeek);
            }
            List<UserCumulate> userCumulateList = iWxDataGateways.getUserCumulate(synParameter);
            for (UserCumulate userCumulate : userCumulateList) {
                iSynDataRepository.insertUserCumulate(userCumulate);
            }
            List<UserRead> userReadList = iWxDataGateways.getUserRead(synParameter);
            for (UserRead userRead : userReadList) {
                iSynDataRepository.insertUserRead(userRead);
            }
            List<UserReadHour> userReadHourList = iWxDataGateways.getUserReadHour(synParameter);
            for (UserReadHour userReadHour : userReadHourList) {
                iSynDataRepository.insertUserReadHour(userReadHour);
            }
            List<UserShare> userShareList = iWxDataGateways.getUserShare(synParameter);
            for (UserShare userShare : userShareList) {
                iSynDataRepository.insertUserShare(userShare);
            }
            List<UserShareHour> userShareHourList = iWxDataGateways.getUserShareHour(synParameter);
            for (UserShareHour userShareHour : userShareHourList) {
                iSynDataRepository.insertUserShareHour(userShareHour);
            }
            List<UserSummary> userSummaryList = iWxDataGateways.getUserSummary(synParameter);
            for (UserSummary userSummary : userSummaryList) {
                iSynDataRepository.insertUserSummary(userSummary);
            }

    }
}
