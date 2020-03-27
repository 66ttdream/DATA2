import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import data.entity.ArticleSummary;
import data.gateways.modle.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public class GsonStringTest {
    /*@Test
    public void test(){
        *//*String json = "[{\"refDate\":\"2014-12-08\",\"msgId\":\"10000050_1\",\"title\": \"12月27日 DiLi日报\",\"intPageReadUser\": 23676,\"intPageReadCount\": 25615,\"oriPageReadUser\": 29,\"oriPageReadCount\": 34,\"shareUser\": 122,\"shareCount\": 994,\"addToFavUser\": 1,\"addToFavCount\": 3},{\"refDate\":\"2014-12-08\",\"msgId\":\"10000050_1\",\"title\": \"12月27日 DiLi日报\",\"intPageReadUser\": 23676,\"intPageReadCount\": 25615,\"oriPageReadUser\": 29,\"oriPageReadCount\": 34,\"shareUser\": 122,\"shareCount\": 994,\"addToFavUser\": 1,\"addToFavCount\": 3}]";
        Gson gson = new Gson();
        JsonArray jsonArray = new JsonParser().parse(json).getAsJsonArray();
        for(int i=0; i< jsonArray.size(); i++){
                   JsonElement jsonElement = jsonArray.get(i);
            ArticleSummary  articleSummary=gson.fromJson(jsonElement,  ArticleSummary.class);
            System.out.println(articleSummary);

        }

        String json1 = "{ \n" +
                "    \"list\":[{\"refDate\":\"2014-12-08\",\"msgId\":\"10000050_1\",\"title\": \"12月27日 DiLi日报\",\"intPageReadUser\": 23676,\"intPageReadCount\": 25615,\"oriPageReadUser\": 29,\"oriPageReadCount\": 34,\"shareUser\": 122,\"shareCount\": 994,\"addToFavUser\": 1,\"addToFavCount\": 3},{\"refDate\":\"2014-12-08\",\"msgId\":\"10000050_1\",\"title\": \"12月27日 DiLi日报\",\"intPageReadUser\": 23676,\"intPageReadCount\": 25615,\"oriPageReadUser\": 29,\"oriPageReadCount\": 34,\"shareUser\": 122,\"shareCount\": 994,\"addToFavUser\": 1,\"addToFavCount\": 3}]}";
        WxJsonGateways user = gson.fromJson(json1, WxJsonGateways.class);
        ArticleSummaryGateways[] s = user.getList();
        for(ArticleSummaryGateways a:s){
            a.setAppid("1122");
            System.out.println(a+"11");
            System.out.println(a.getAppid());
            System.out.println(a.getAddToFavCount());
        }*//*
        //System.out.println(user);
        String json2 = "{ \n" +
                "   \"list\": [ \n" +
                "       { \n" +
                "           \"ref_date\": \"2014-12-14\", \n" +
                "           \"msgid\": \"202457380_1\", \n" +
                "           \"title\": \"马航丢画记\", \n" +
                "           \"details\": [ \n" +
                "               { \n" +
                "                   \"stat_date\": \"2014-12-14\", \n" +
                "                   \"target_user\": 261917, \n" +
                "                   \"int_page_read_user\": 23676, \n" +
                "                   \"int_page_read_count\": 25615, \n" +
                "                   \"ori_page_read_user\": 29, \n" +
                "                   \"ori_page_read_count\": 34, \n" +
                "                   \"share_user\": 122, \n" +
                "                   \"share_count\": 994, \n" +
                "                   \"add_to_fav_user\": 1, \n" +
                "                   \"add_to_fav_count\": 3,\n" +
                "                    \"int_page_from_session_read_user\": 657283, \n" +
                "                    \"int_page_from_session_read_count\": 753486, \n" +
                "                    \"int_page_from_hist_msg_read_user\": 1669, \n" +
                "                    \"int_page_from_hist_msg_read_count\": 1920, \n" +
                "                    \"int_page_from_feed_read_user\": 367308, \n" +
                "                    \"int_page_from_feed_read_count\": 433422, \n" +
                "                    \"int_page_from_friends_read_user\": 15428, \n" +
                "                    \"int_page_from_friends_read_count\": 19645, \n" +
                "                    \"int_page_from_other_read_user\": 477, \n" +
                "                    \"int_page_from_other_read_count\": 703, \n" +
                "                    \"feed_share_from_session_user\": 63925, \n" +
                "                    \"feed_share_from_session_cnt\": 66489, \n" +
                "                    \"feed_share_from_feed_user\": 18249, \n" +
                "                    \"feed_share_from_feed_cnt\": 19319, \n" +
                "                    \"feed_share_from_other_user\": 731, \n" +
                "                    \"feed_share_from_other_cnt\": 775\n" +
                "               }, \n" +
                "           ]\n" +
                "       },\n" +
                "   ]\n" +
                "}";
        Gson gson = new Gson();
        ArticleTotalList use = gson.fromJson(json2, ArticleTotalList.class);
        List<ArticleTotalGateways> m = use.getList();
        System.out.println(m.toString());
        //Iterator it = m.iterator();
        *//*while (it.hasNext()){
            System.out.println(it.next());
            //ArticleTotalGateways ArticleTotalGateways = it.next();
            while (it.hasNext()){
                System.out.println(it.next());

            }

        }*//*
        for(ArticleTotalGateways a:m){
            List<ArticleTotal_Details>  l = a.getDetails();
            System.out.println(a.getMsgid());
            for(ArticleTotal_Details de:l){

                //System.out.println(de.getAddToFavCount());
                System.out.println(de);
                //System.out.println("1");
                System.out.println(de.getFeedShareFromFeedCnt());

                System.out.println(de.getIntPageFromOtherReadCount());
            }
        }
    }
    @Test
    public void test1(){
        var json = "";
        Gson gson = new Gson();
        ArticleTotalList articleTotalList = gson.fromJson(json, ArticleTotalList.class);


    }*/


}
