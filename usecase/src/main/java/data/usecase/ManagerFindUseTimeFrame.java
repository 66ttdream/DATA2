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
public class ManagerFindUseTimeFrame {
    private IUserAnalyzeRepository iUserAnalyzeRepository;
    public List<Integer> execut(String beginTime, String endTime, int frame){
        return iUserAnalyzeRepository.findAllUseTimeFrame(beginTime, endTime, frame);
    }
}
