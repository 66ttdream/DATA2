package data.usecase;

import data.analyzeentity.ShareRate;
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
public class PractitionerFindShareRate {
    private IContentAnalyzeRepository iContentAnalyzeRepository;
    public List<ShareRate> execut(int userId){
        return  iContentAnalyzeRepository.findContentShareRate(userId);
    }
}
