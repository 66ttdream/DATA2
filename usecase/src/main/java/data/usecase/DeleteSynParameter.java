package data.usecase;

import data.entity.SynParameter;
import data.usecase.exception.NotExistException;
import data.usecase.port.SynParmeterRepository;
import data.vo.id.AppId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeleteSynParameter {
    private SynParmeterRepository synParmeterRepository;
    public void execut(AppId appid) throws NotExistException{
        if(synParmeterRepository.findParameter(SynParameter.builder().synParameterId(appid).build())!=null){
            synParmeterRepository.deletePerameter(appid);
        }else {
            throw new NotExistException(1000,"任务不存在");
        }

    }
}
