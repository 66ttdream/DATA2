package data.usecase;

import data.analyzeentity.HeatworkOfUser;
import data.usecase.port.IContentAnalyzeRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ManagerFindHeatwork {
    private IContentAnalyzeRepository iContentAnalyzeRepository;
    public List<HeatworkOfUser> execut(int pageNum, int pageSize){
        return iContentAnalyzeRepository.findAllHeatwork(pageNum,pageSize);
    }
}
