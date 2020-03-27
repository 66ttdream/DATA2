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
public class PractitionerFindUseTimeFrame {
    private IUserAnalyzeRepository iUserAnalyzeRepository;
    public List<Integer> execut(int userId, String beginTime, String endTime, int frame){
       return iUserAnalyzeRepository.findUseTimeFrame(userId, beginTime, endTime, frame);
    }
}
