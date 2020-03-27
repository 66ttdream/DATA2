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
public class PractitionerFindTerminal {
    private IUserAnalyzeRepository iUserAnalyzeRepository;
    public List execut(int userId,String beginTime, String endTime){
        return iUserAnalyzeRepository.findTerminal(userId,beginTime,endTime);
    }
}
