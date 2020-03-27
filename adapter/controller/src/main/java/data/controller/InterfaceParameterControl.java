package data.controller;

import data.controller.modle.CancleParameterWeb;
import data.controller.modle.SynParameterWeb;
import data.usecase.DeleteSynParameter;
import data.usecase.SaveSynParameter;
import data.usecase.exception.AccessTokenException;
import data.usecase.exception.NotExistException;
import data.usecase.exception.UserTypeException;

//@AllArgsConstructor
public class InterfaceParameterControl {
    private SaveSynParameter saveSynParameter;
    private DeleteSynParameter deleteSynParameter;

    public InterfaceParameterControl(SaveSynParameter saveSynParameter, DeleteSynParameter deleteSynParameter) {
        this.saveSynParameter = saveSynParameter;
        this.deleteSynParameter = deleteSynParameter;
    }

    public void start(SynParameterWeb spw) throws AccessTokenException, UserTypeException {
        saveSynParameter.execute(spw.toSynParameter());
    }

    public void cancel(CancleParameterWeb appid) throws NotExistException{
        deleteSynParameter.execut(appid.toAppId());
    }
}
