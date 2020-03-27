package data.entity;

import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SynParameter {
    private AppId synParameterId;
    private String secret;
    private String token;
    private String aesKey;
   /* public void synparameter(final AppId appid,final String secret,final String token,final String aesKey){
        this.secret=secret;
        this.synParameterId=appid;
        this.token=token;
        this.aesKey=aesKey;
    }*/

}
