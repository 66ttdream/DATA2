package data.usecase;

import data.analyzeentity.ShareNum;
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
public class ManagerFindShareNum {
    private IContentAnalyzeRepository iContentAnalyzeRepository;
    public List<ShareNum>  execut(int pageNum, int pageSize){
        return iContentAnalyzeRepository.findAllContentShareNum(pageNum,pageSize);
    }
}
