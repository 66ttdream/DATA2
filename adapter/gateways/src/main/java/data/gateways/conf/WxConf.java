package data.gateways.conf;

import data.entity.SynParameter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;

public class WxConf {
    //private static WxMpDefaultConfigImpl conf;
    //private static WxMpService wxMpService;

    //WxMpDefaultConfigImpl conf = new WxMpDefaultConfigImpl();

    public static WxMpService init(SynParameter sp) {
        WxMpDefaultConfigImpl conf = new WxMpDefaultConfigImpl();
        conf.setSecret(sp.getSecret());//设置公众号密钥
        conf.setAppId(sp.getSynParameterId().getAppId());//设置公众号唯一Id
        conf.setToken(sp.getToken());//设置令牌
        conf.setAesKey(sp.getAesKey());//加密方式
        WxMpService ws= new WxMpServiceImpl();
        ws.setWxMpConfigStorage(conf);
        return ws;

    }


}
