package data.controller.modle;

import data.entity.SynParameter;
import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SynParameterWeb {
    String appid;
    String secret;
    String token;
    String aesKey;
    public SynParameter toSynParameter() {
        return SynParameter.builder()
                .synParameterId(new AppId(appid))
                .secret(secret)
                .token(token)
                .aesKey(aesKey)
                .build();

    }
}
