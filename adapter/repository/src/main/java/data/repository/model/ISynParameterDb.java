package data.repository.model;

import data.entity.SynParameter;
import data.vo.id.AppId;
import org.davidmoten.rx.jdbc.annotations.Column;


public interface ISynParameterDb {
    @Column
    String appid();
    @Column
    String secret();
    @Column
    String token();
    @Column
    String asekey();

    static SynParameter toDomain(ISynParameterDb iSynParameterDb){

        return SynParameter.builder()
                .token(iSynParameterDb.token())
                .synParameterId(new AppId(iSynParameterDb.appid()))
                .secret(iSynParameterDb.secret())
                .aesKey(iSynParameterDb.asekey())
                .build();
    }

}
