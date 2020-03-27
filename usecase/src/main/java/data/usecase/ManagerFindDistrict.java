package data.usecase;

import data.usecase.port.IUserAnalyzeRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ManagerFindDistrict {
    private IUserAnalyzeRepository iUserAnalyzeRepository;
    public List execut(String beginTime, String endTime){
        return iUserAnalyzeRepository.findAllDistrict(beginTime, endTime);
    }
}
