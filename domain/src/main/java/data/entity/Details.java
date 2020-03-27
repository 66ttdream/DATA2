package data.entity;

import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Details {
    private AppId appid;
    private String  msgId;
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
}
