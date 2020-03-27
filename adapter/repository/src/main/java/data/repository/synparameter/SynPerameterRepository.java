package data.repository.synparameter;

import data.entity.SynParameter;
import data.repository.db.Databases;
import data.repository.model.ISynParameterDb;
import data.usecase.port.SynParmeterRepository;
import data.vo.id.AppId;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SynPerameterRepository implements SynParmeterRepository {
    @Override
    public SynParameter findParameter(SynParameter sp){
        var sql = "SELECT appid,secret,token,asekey FROM synparameter WHERE appid=?";
        ISynParameterDb iSynParameterDb;
        try {
            iSynParameterDb = Databases.getDb()
                    .select(sql)
                    .parameter(sp.getSynParameterId().getAppId())
                    .autoMap(ISynParameterDb.class)
                    .blockingFirst();
        }catch (NoSuchElementException e){
                     return null;
        }
        return  ISynParameterDb.toDomain(iSynParameterDb);
    }

    @Override
    public List<SynParameter> findAllParameter(){
        var sql = "SELECT * FROM synparameter";
        return Databases.getDb()
                .select(sql)
                .autoMap(ISynParameterDb.class)
                .map(ISynParameterDb::toDomain)
                .toList()
                .blockingGet()
                ;
    }

    @Override
    public void insertPerameter(SynParameter sp){
                var sql = "INSERT INTO synparameter VAlUES(?,?,?,?)";
                Databases.getDb()
                        .update(sql)
                        .parameters(sp.getSynParameterId().getAppId(),sp.getSecret(),sp.getToken(),sp.getAesKey())
                        .complete()
                        .blockingAwait();
    }


    @Override
    public void deletePerameter(AppId appid){
        var sql = "DELETE FROM synparameter WHERE appid=?";
        Databases.getDb()
                .update(sql)
                .parameter(appid.getAppId())
                .complete()
                .blockingAwait();
    }

    @Override
    public void upPerameter(SynParameter sp) {
        var sql = "UPDATE synparameter SET secret = ?,token= ?,asekey=? WHERE appid = ?";
        Databases.getDb()
                .update(sql)
                .parameters(sp.getSecret(),sp.getToken(),sp.getAesKey(),sp.getSynParameterId().getAppId())
                .complete()
                .blockingAwait();
    }
}
