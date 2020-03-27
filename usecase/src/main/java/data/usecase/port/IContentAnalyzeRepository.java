package data.usecase.port;

import data.analyzeentity.HeatworkOfUser;
import data.analyzeentity.ShareNum;
import data.analyzeentity.ShareRate;
import data.analyzeentity.TwiceShareRate;

import java.util.List;

public interface IContentAnalyzeRepository {
    public List<HeatworkOfUser> findHeatwork(int userId, int pageNum, int pageSize);
    public List<HeatworkOfUser> findAllHeatwork(int pageNum, int pageSize);
    public List<ShareNum> findAllContentShareNum(int pageNum, int pageSize);
    public List<ShareNum> findContentShareNum(int userId,int pageNum, int pageSize);
    public List<ShareRate> findContentShareRate(int userId);
    public List<ShareRate> findAllContentShareRate();
    public List<TwiceShareRate> findTwiceShareRate(int userId);
    public List<TwiceShareRate> findAllTwiceShareRate();
}
