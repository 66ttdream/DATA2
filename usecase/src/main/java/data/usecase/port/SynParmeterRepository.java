package data.usecase.port;

import data.entity.SynParameter;
import data.vo.id.AppId;

import java.util.List;

public interface SynParmeterRepository {
    public SynParameter findParameter(SynParameter sp);
    public List<SynParameter> findAllParameter();
    public void insertPerameter(SynParameter sp);
    public void deletePerameter(AppId appid);
    public void upPerameter(SynParameter sp);
}
