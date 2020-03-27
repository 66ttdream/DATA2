import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;

public class test {
    public static void main(String args[]){
        WxMpDefaultConfigImpl wx = new WxMpDefaultConfigImpl();
        wx.setAppId("wx4ad60466cb29735c");
        wx.setSecret("9f05d836a29b5b6769231a93e6366614");
        String json = wx.getAccessToken();
        System.out.println(json);
    }
}