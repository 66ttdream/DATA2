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
public class PractitionerFindNewAddIp {
    private IUserAnalyzeRepository iUserAnalyzeRepository;
    public int execut(int userId,String beginTime, String endTime){
        return iUserAnalyzeRepository.findNewAddIp(userId,beginTime,endTime);
    }
}
