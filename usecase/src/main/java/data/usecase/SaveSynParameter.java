package data.usecase;

import data.entity.SynParameter;
import data.usecase.exception.AccessTokenException;
import data.usecase.exception.ApplicationException;
import data.usecase.exception.UserTypeException;
import data.usecase.port.AccessTokenGet;
import data.usecase.port.IWxDataGateways;
import data.usecase.port.SynParmeterRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaveSynParameter {
    private  AccessTokenGet accessTokenGet;
    private SynParmeterRepository synParmeterRepository;
    private IWxDataGateways IWxDataGateways;
    public void execute(SynParameter sp) throws AccessTokenException, UserTypeException {
        if(accessTokenGet.get(sp)!=null&&synParmeterRepository.findParameter(sp)==null){
            try {
                IWxDataGateways.getArticleSummary(sp);
            }catch (ApplicationException e){
                e.printStackTrace();
                throw new UserTypeException(e.getErroCode(),e.getMessage());
            }
            synParmeterRepository.insertPerameter(sp);
        }
        if(accessTokenGet.get(sp)!=null&&!synParmeterRepository.findParameter(sp).equals(sp)){
            synParmeterRepository.upPerameter(sp);
        }
    }

}
