package data.repository.dataanalyze;

import data.analyzeentity.HeatworkOfUser;
import data.analyzeentity.ShareNum;
import data.analyzeentity.ShareRate;
import data.analyzeentity.TwiceShareRate;
import data.repository.db.Databases;
import data.repository.model.IHeadwork;
import data.repository.model.IShareNum;
import data.repository.model.IShareRate;
import data.repository.model.ITwiceShareRate;
import data.usecase.port.IContentAnalyzeRepository;

import java.util.List;

public class ContentAnalyzeRepository implements IContentAnalyzeRepository {
    /**
     *查询从业者作品内容热度
     * @param userId 从业者的用户唯一标识即内容作者的唯一id
     * @param pageNum 页码
     * @param pageSize 页面条目数（一页的内容有多少条）
     */
    @Override
    public List<HeatworkOfUser> findHeatwork(int userId, int pageNum, int pageSize){
        int startPage = (pageNum-1)*pageSize;
        int endPage = pageNum*pageSize;
        //var sql = "SELECT contentid COUNT(*) count FROM TESTCONF WHERE pagetype = 1 AND authorid= ? GROUP BY userid ORDER BY count DESC LIMIT "+startPage+","+endPage;
        var sql = "SELECT authorid,count(contentid) pv FROM D_LOADRESOURCE where authorid=? GROUP BY contentid ORDER BY count(contentid) DESC LIMIT "+startPage+","+endPage;
       return Databases.getDb()
                .select(sql)
                .parameter(userId)
                .autoMap(IHeadwork.class)
                .map(IHeadwork::toDomain)
                .toList()
                .blockingGet();
    }

    /**
     *查询所有内容页得浏览热度
     * @param pageNum 页码
     * @param pageSize 页面显示条数
     * @return  内容热度分析的领域对象集合
     */
    @Override
    public List<HeatworkOfUser> findAllHeatwork(int pageNum, int pageSize){
        int startPage = (pageNum-1)*pageSize;
        int endPage = pageNum*pageSize;
        var sql = "SELECT authorid,count(contentid) pv FROM D_LOADRESOURCE GROUP BY contentid ORDER BY count(contentid) DESC LIMIT "+startPage+","+endPage;
        return Databases.getDb()
                .select(sql)
                .autoMap(IHeadwork.class)
                .map(IHeadwork::toDomain)
                .toList()
                .blockingGet();
    }

    /**
     * 查询内容页及其对应被分享次数
     * @param userId 作者id
     * @param pageNum 页码
     * @param pageSize 页面显示数
     * @return 数据库查询结果的传输对象
     */
    @Override
    public List<ShareNum> findContentShareNum(int userId,int pageNum, int pageSize){
        int startPage = (pageNum-1)*pageSize;
        int endPage = pageNum*pageSize;
        var sql = "SELECT contentid, COUNT(contentid) times FROM D_SHAREPAGE WHERE authorid = "+userId+" GROUP BY contentid "+"ORDER BY COUNT(contentid) DESC LIMIT "+startPage+","+endPage;
        return Databases.getDb()
                .select(sql)
                .autoMap(IShareNum.class)
                .map(IShareNum::toDomain)
                .toList()
                .blockingGet();
    }

    /**
     * 查询内容页及其对应被分享次数
     * @param pageNum 页码
     * @param pageSize  页面显示条数
     * @return  数据库查询结果的传输对象
     */
    @Override
    public List<ShareNum> findAllContentShareNum(int pageNum, int pageSize){
        int startPage = (pageNum-1)*pageSize;
        int endPage = pageNum*pageSize;
        var sql = "SELECT contentid, COUNT(contentid) times FROM D_SHAREPAGE GROUP BY contentid "+"ORDER BY COUNT(contentid) DESC LIMIT "+startPage+","+endPage;
        return Databases.getDb()
                .select(sql)
                .autoMap(IShareNum.class)
                .map(IShareNum::toDomain)
                .toList()
                .blockingGet();
    }

    /**
     *
     * @param userId
     * @return
     */
    @Override
    public List<ShareRate> findContentShareRate(int userId){
        var sql = "SELECT contentid,COUNT(contentid) viewNum,COUNT(eventsource) shareNum from opentest WHERE eventsource=1 and authorid="+userId+"  GROUP BY contentid";
        return Databases.getDb()
                .select(sql)
                .autoMap(IShareRate.class)
                .map(IShareRate::toDomain)
                .toList()
                .blockingGet();
    }

    /**
     *
     * @return
     */
    @Override
    public List<ShareRate> findAllContentShareRate(){
        var sql = "SELECT contentid,COUNT(contentid),COUNT(eventsource) from opentest WHERE eventsource=1  GROUP BY contentid";
        return Databases.getDb()
                .select(sql)
                .autoMap(IShareRate.class)
                .map(IShareRate::toDomain)
                .toList()
                .blockingGet();
    }

    /**
     * 从业者查询其用户由分享页面进入再次分享的数据
     * @param userId
     * @return
     */
    public List<TwiceShareRate> findTwiceShareRate(int userId){
        var sql = "SELECT contentid,COUNT(eventsource) twicehareNum,COUNT(contentid) shareNum from D_SHAREPAGE WHERE eventsource=1 and authorid="+userId+" GROUP BY contentid";
        return Databases.getDb()
                .select(sql)
                .autoMap(ITwiceShareRate.class)
                .map(ITwiceShareRate::toDomain)
                .toList()
                .blockingGet();
    }

    /**
     * 查询用户由分享页面进入再次分享的数据
     * @return
     */
    public List<TwiceShareRate> findAllTwiceShareRate(){
        var sql = "SELECT contentid,COUNT(eventsource) twicehareNum,COUNT(contentid) shareNum from D_SHAREPAGE WHERE eventsource=1 GROUP BY contentid";
        return Databases.getDb()
                .select(sql)
                .autoMap(ITwiceShareRate.class)
                .map(ITwiceShareRate::toDomain)
                .toList()
                .blockingGet();
    }
}
