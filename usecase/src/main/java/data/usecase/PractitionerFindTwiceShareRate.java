package data.usecase;

import data.analyzeentity.TwiceShareRate;
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
public class PractitionerFindTwiceShareRate {
    private IContentAnalyzeRepository iContentAnalyzeRepository;
    public List<TwiceShareRate> execut(int userId){
        return iContentAnalyzeRepository.findTwiceShareRate(userId);
    }
}
