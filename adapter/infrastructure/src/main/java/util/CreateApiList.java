package util;

import java.util.ArrayList;
import java.util.List;
/**
 * 获取微信数据同步api的list集合
 * @author liu
 * @return List:所有数据同步pai集合
 *
 */
public class CreateApiList {
    public static List<String> getApiList() {
        List<String> ls = new ArrayList<String>();
        ls.add(ReadWxApi.getarticlesummary);
        ls.add(ReadWxApi.getarticletotal);
        ls.add(ReadWxApi.getinterfacesummary);
        ls.add(ReadWxApi.getinterfacesummaryhour);
        ls.add(ReadWxApi.getupstreammsg);
        ls.add(ReadWxApi.getupstreammsgdist);
        ls.add(ReadWxApi.getupstreammsgdistmonth);
        ls.add(ReadWxApi.getupstreammsgdistweek);
        ls.add(ReadWxApi.getupstreammsghour);
        ls.add(ReadWxApi.getupstreammsgmonth);
        ls.add(ReadWxApi.getupstreammsgweek);
        ls.add(ReadWxApi.getusercumulate);
        ls.add(ReadWxApi.getuserread);
        ls.add(ReadWxApi.getuserreadhour);
        ls.add(ReadWxApi.getusershare);
        ls.add(ReadWxApi.getusersharehour);
        ls.add(ReadWxApi.getusersummary);

        return ls;

    }
}

