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
public class ManagerFinNewAddUser {
    private IUserAnalyzeRepository iUserAnalyzeRepository;
    public int execut(String beginTime, String endTime){
        return iUserAnalyzeRepository.findAllNewAddUser(beginTime,endTime);
    }
}
