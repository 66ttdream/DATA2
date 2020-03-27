package data.gateways.tokengateways;

import data.entity.SynParameter;
import data.gateways.conf.WxConf;
import data.usecase.exception.AccessTokenException;
import data.usecase.port.AccessTokenGet;
import me.chanjar.weixin.common.error.WxErrorException;

public class AccessTokenGateways implements AccessTokenGet {

    public String get(SynParameter sp) throws AccessTokenException{
        try {
            return WxConf.init(sp).getAccessToken(true);
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw  new AccessTokenException(e.getError().getErrorCode(),e.getMessage());
        }
    }
}
