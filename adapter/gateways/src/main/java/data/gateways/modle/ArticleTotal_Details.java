package data.gateways.modle;

import data.entity.Details;
import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleTotal_Details {
    //private String appid;
    //private String msgId;
    private String  statDate;
    private String  targetUser;
    private String  intPageReadUser;
    private String  intPageReadCount;
    private String  oriPageReadUser;
    private String  oriPageReadCount;
    private String  shareUser;
    private String  shareCount;
    private String  addToFavUser;
    private String  addToFavCount;
    private String  intPageFromSessionReadUser;
    private String  intPageFromSessionReadCount;
    private String  intPageFromHistMsgReadUser;
    private String  intPageFromHistMsgReadCount;
    private String  intPageFromFeedReadUser;
    private String  intPageFromFeedReadCount;
    private String  intPageFromFriendsReadUser;
    private String  intPageFromFriendsReadCount;
    private String  intPageFromOtherReadUser;
    private String  intPageFromOtherReadCount;
    private String  feedShareFromSessionUser;
    private String  feedShareFromSessionCnt;
    private String  feedShareFromFeedUser;
    private String  feedShareFromFeedCnt;
    private String  feedShareFromOtherUser;
    private String  feedShareFromOtherCnt;
    public Details toDetails(){
        return Details.builder()
                //.appid(new AppId(appid))
                //.msgId(msgId)
                .statDate(statDate)
                .targetUser(targetUser)
                .intPageReadUser(intPageReadUser)
                .intPageReadCount(intPageReadCount)
                .oriPageReadUser(oriPageReadUser)
                .oriPageReadCount(oriPageReadCount)
                .shareUser(shareUser)
                .shareCount(shareCount)
                .addToFavUser(addToFavUser)
                .addToFavCount(addToFavCount)
                .intPageFromSessionReadUser(intPageFromSessionReadUser)
                .intPageFromSessionReadCount(intPageFromSessionReadCount)
                .intPageFromHistMsgReadUser(intPageFromHistMsgReadUser)
                .intPageFromHistMsgReadCount(intPageFromHistMsgReadCount)
                .intPageFromFeedReadUser(intPageFromFeedReadUser)
                .intPageFromFeedReadCount(intPageFromFeedReadCount)
                .intPageFromFriendsReadUser(intPageFromFriendsReadUser)
                .intPageFromFriendsReadCount(intPageFromFriendsReadCount)
                .intPageFromOtherReadUser(intPageFromOtherReadUser)
                .intPageFromOtherReadCount(intPageFromOtherReadCount)
                .feedShareFromSessionUser(feedShareFromSessionUser)
                .feedShareFromSessionCnt(feedShareFromSessionCnt)
                .feedShareFromFeedUser(feedShareFromFeedUser)
                .feedShareFromFeedCnt(feedShareFromFeedCnt)
                .feedShareFromOtherUser(feedShareFromOtherUser)
                .feedShareFromOtherCnt(feedShareFromOtherCnt)
                .build();
    }

}
