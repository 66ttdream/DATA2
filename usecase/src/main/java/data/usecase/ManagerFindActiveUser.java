package data.usecase;

import data.usecase.port.IUserAnalyzeRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ManagerFindActiveUser {
    private IUserAnalyzeRepository iUserAnalyzeRepository;
    public int execut(String beginTime, String endTime){
        return iUserAnalyzeRepository.findAllActiveUserNum(beginTime,endTime);
    }
}
