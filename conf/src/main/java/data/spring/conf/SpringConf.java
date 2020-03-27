package data.spring.conf;

import data.gateways.datagateways.WxDataGateways;
import data.gateways.tokengateways.AccessTokenGateways;
import data.repository.synparameter.SynPerameterRepository;
import data.usecase.DeleteSynParameter;
import data.usecase.SaveSynParameter;
import data.usecase.port.AccessTokenGet;
import data.usecase.port.IWxDataGateways;
import data.usecase.port.SynParmeterRepository;

public class SpringConf {
    private final AccessTokenGet accessTokenGet = new AccessTokenGateways();
    private final SynParmeterRepository synParmeterRepository = new SynPerameterRepository();
    private final IWxDataGateways iWxDataGateways = new WxDataGateways();

    public SaveSynParameter saveSynParameter(){
        return  new SaveSynParameter(accessTokenGet,synParmeterRepository,iWxDataGateways);
    }

    public DeleteSynParameter deleteSynParameter(){
        return  new DeleteSynParameter(synParmeterRepository);
    }



}
