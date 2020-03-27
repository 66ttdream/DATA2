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
public class PractitionerFindShareNum {
    private IContentAnalyzeRepository iContentAnalyzeRepository;
    public List<ShareNum> execut(int userId,int pageNum, int pageSize){
        return iContentAnalyzeRepository.findContentShareNum(userId,pageNum,pageSize);
    }
}
