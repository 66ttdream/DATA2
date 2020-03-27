package data.repository.dataanalyze;

import data.entity.AppointmentNum;
import data.entity.DistrictRate;
import data.entity.TerminalNum;
import data.repository.db.Databases;
import data.repository.model.IAppointmentNum;
import data.repository.model.IDistrictRate;
import data.repository.model.ITerminalNum;
import data.usecase.port.IUserAnalyzeRepository;
import org.davidmoten.rx.jdbc.Database;
import util.Time;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class UserAnalyzeRepository implements IUserAnalyzeRepository {
    /**
     * 从业者查询其用户数
     * @return 全部用户数
     */
    public int findUser(int userId){
        var sql = "SELECT COUNT(DISTINCT(userid)) FROM D_LOADRESOURCE WHERE authorid="+userId;
        return Databases.getDb()
                .select(sql)
                .getAs(Integer.class)
                .blockingFirst()
                ;

    }

    /**
     * 查询用户总数
     * @return
     */
    public int findAllUser(){
        var sql = "SELECT COUNT(DISTINCT(userid)) FROM D_LOADRESOURCE";
        return Databases.getDb()
                .select(sql)
                .getAs(Integer.class)
                .blockingFirst()
                ;

    }

    /**
     *查询时段内从业者新增的用户量
     * @param beginTime
     * @param endTime
     * @return
     */
    public int findNewAddUser(int userId,String beginTime, String endTime){
        var sql = "SELECT a.userid FROM (SELECT COUNT(DISTINCT(userid)) FROM TESTCONF WHERE DATE_FORMAT(eventtime,'%Y%m%d')=DATE_FORMAT(NOW(),'%Y%m%d') a) union SELECT userid FROM b (SELECT COUNT(DISTINCT(userid)) FROM TESTCONF WHERE DATE_FORMAT(eventtime,'%Y%m%d')<DATE_FORMAT(NOW(),'%Y%m%d') b)";
        return Databases.getDb()
                .select(sql)
                .getAs(Integer.class)
                .blockingFirst()
                ;
    }

    /**
     *查询时间段内新增的用户数量
     * @param beginTime  需要查询时段的开始时间
     * @param endTime 需要查询时段的结束时间
     * @return
     */
    public int findAllNewAddUser(String beginTime, String endTime){
        var sql = "SELECT a.userid FROM (SELECT COUNT(DISTINCT(userid)) FROM TESTCONF WHERE DATE_FORMAT(eventtime,'%Y%m%d')=DATE_FORMAT(NOW(),'%Y%m%d') a) union SELECT userid FROM b (SELECT COUNT(DISTINCT(userid)) FROM TESTCONF WHERE DATE_FORMAT(eventtime,'%Y%m%d')<DATE_FORMAT(NOW(),'%Y%m%d') b)";
        return Databases.getDb()
                .select(sql)
                .getAs(Integer.class)
                .blockingFirst()
                ;
    }

    /**
     * 查询时间段内活跃的用户总数
     * @param beginTime
     * @param endTime
     * @return
     */
    public int findAllActiveUserNum(String beginTime, String endTime){
        var sql = "SELECT COUNT(DISTINCT(userId)) FROM D_LOADRESOURCE WHERE time BETWEEN "+beginTime+" "+endTime;
        return Databases.getDb()
                .select(sql)
                .getAs(Integer.class)
                .blockingFirst()
                ;
    }

    /**
     * 查询从业者的用户活跃数
     * @param userId 从业者Id
     * @param beginTime 需查询时间段的开始时间
     * @param endTime 需查询时间段的结束时间
     * @return
     */
    public int findActiveUserNum(int userId ,String beginTime, String endTime){
        var sql = "SELECT COUNT(DISTINCT(userId)) FROM D_LOADRESOURCE WHERE time BETWEEN "+beginTime+" "+endTime+ "AND userId=?";
        return Databases.getDb()
                .select(sql)
                .parameter(userId)
                .getAs(Integer.class)
                .blockingFirst()
                ;
    }

    /**
     *查询用户使用时间段
     * @param userId 从业者id
     * @param beginTime
     * @param endTime
     * @param frame 划分一天24小时为多少段
     * @return
     */
    public List<Integer> findUseTimeFrame(int userId,String beginTime,String endTime,int frame){
        Database db = Databases.getDb();
        Map<String,String> map = Time.getTimeFrame(frame);
        Iterator it = map.keySet().iterator();
        List<Integer> list = new LinkedList<Integer>();
        String sql;
        if(beginTime==null&&endTime==null){
            sql = "SELECT COUNT(DISTINCT(userid)) FROM D_LOADRESOURCE";
            int allUserNum = db
                    .select(sql)
                    .getAs(Integer.class)
                    .blockingFirst()
                    ;
            list.add(allUserNum);
            while (it.hasNext()){
                String key = (String) it.next();
                String value = map.get(key);
                sql = "SELECT COUNT(d.eventtime) FROM (SELECT eventtime FROM D_LOADRESOURCE WHERE DATE_FORMAT(eventtime,'%H:%i:%s')>"+"'"+key+"'"+" AND DATE_FORMAT(eventtime,'%H:%i:%s')<"+"'"+map.get(key)+"'"+") d";
                int data = db
                        .select(sql)
                        .getAs(Integer.class)
                        .blockingFirst()
                        ;
                list.add(data);
            }
            return list;
        }else {
            sql = "SELECT COUNT(d.eventtime) FROM (SELECT eventtime FROM D_LOADRESOURCE WHERE eventtime<"+"'"+beginTime+"'"+"definedendtime AND eventtime>"+"'"+endTime+"'"+") d";
            int allUserNum = db
                    .select(sql)
                    .getAs(Integer.class)
                    .blockingFirst()
                    ;
            list.add(allUserNum);
            while (it.hasNext()) {
                String key = (String) it.next();
                String value = map.get(key);
                sql = "SELECT COUNT(y.eventtime) FROM (SELECT eventtime  from  countofdefined x  where x.eventtime BETWEEN begintime AND endtime) y";
                int data = db
                        .select(sql)
                        .getAs(Integer.class)
                        .blockingFirst()
                        ;
                list.add(data);
            }
            return list;
        }
    }

    /**
     * 查询用户使用时间段
     * @param beginTime
     * @param endTime
     * @param frame
     * @return 划分一天24小时为多少段
     */
    public List<Integer> findAllUseTimeFrame(String beginTime, String endTime, int frame){
        Database db = Databases.getDb();
        Map<String,String> map = Time.getTimeFrame(frame);
        Iterator it = map.keySet().iterator();
        List<Integer> list = new LinkedList<Integer>();
        String sql;
        if(beginTime==null&&endTime==null){
            sql = "SELECT COUNT(DISTINCT(userid)) FROM D_LOGINAPP";
            int allUserNum = db
                    .select(sql)
                    .getAs(Integer.class)
                    .blockingFirst()
                    ;
            list.add(allUserNum);
            while (it.hasNext()){
                String key = (String) it.next();
                String value = map.get(key);
                sql = "SELECT COUNT(d.eventtime) FROM (SELECT eventtime FROM TESTCONF WHERE DATE_FORMAT(eventtime,'%H:%i:%s')>"+"'"+key+"'"+" AND DATE_FORMAT(eventtime,'%H:%i:%s')<"+"'"+map.get(key)+"'"+") d";
                int data = db
                        .select(sql)
                        .getAs(Integer.class)
                        .blockingFirst()
                ;
                list.add(data);
            }
            return list;
        }else {
            sql = "SELECT COUNT(d.eventtime) FROM (SELECT eventtime FROM TESTCONF WHERE eventtime<"+"'"+beginTime+"'"+"definedendtime AND eventtime>"+"'"+endTime+"'"+") d";
            int allUserNum = db
                    .select(sql)
                    .getAs(Integer.class)
                    .blockingFirst()
                    ;
            list.add(allUserNum);
            while (it.hasNext()) {
                String key = (String) it.next();
                String value = map.get(key);
                sql = "SELECT COUNT(y.eventtime) FROM (SELECT eventtime  from  countofdefined x  where x.eventtime BETWEEN begintime AND endtime) y";
                int data = db
                        .select(sql)
                        .getAs(Integer.class)
                        .blockingFirst()
                        ;
                list.add(data);
            }
            return list;
        }
    }

    /**
     * 查询单个作品的预约量集合
     * @param userId
     * @param beginTime
     * @param endTime
     * @return
     */
    public List<AppointmentNum> findAppointmentNum(int userId, String beginTime, String endTime){
        String sql;
        if(beginTime==null&&endTime==null){
            //查询用户所有作品的预约数集合
            sql="SELECT  authorid,COUNT(userid) FROM D_APPOINTMENT WHERE authorid="+userId;
        }else {
            //查询用户所有作品时间段内预约数集合
            sql="SELECT  authorid,COUNT(userid) FROM D_APPOINTMENT WHERE authorid="+userId+" and DATE_FORMAT(time,'%Y%m%d') BETWEEN "+beginTime+" AND "+endTime;
        }
        return Databases.getDb()
                .select(sql)
                .parameter(userId)
                .getAs(IAppointmentNum.class)
                .map(IAppointmentNum::toDomain)
                .toList()
                .blockingGet()
                ;
    }

    /**
     * 查询所有作品预约了的集合
     * @param beginTime
     * @param endTime
     * @return
     */
    public List<AppointmentNum> findAllAppointmentNum(String beginTime, String endTime){
        String sql;
        if(beginTime==null&&endTime==null){
            //查询所有作品预约量
            sql="SELECT  authorid,COUNT(userid) FROM D_APPOINTMENT";
        }else {
            //查询时间段内所有作品预约量
            sql="SELECT  authorid,COUNT(userid) FROM D_APPOINTMENT WHERE DATE_FORMAT(time,'%Y%m%d') BETWEEN "+beginTime+" AND "+endTime;
        }
        return Databases.getDb()
                .select(sql)
                .getAs(IAppointmentNum.class)
                .map(IAppointmentNum::toDomain)
                .toList()
                .blockingGet()
                ;
    }

    /**
     *查询用户所有作品对应的预约总数
     * @param userId 用户唯一身份标识
     * @param beginTime
     * @param endTime
     * @return
     */
    public int findAppointmentSum(int userId,String beginTime, String endTime){
        String sql;
        if(beginTime==null&&endTime==null){
            sql="select count(userid) from D_APPOINTMENT where userid=?";
        }else {
            sql="select count(userid) from D_APPOINTMENT where userid=? and DATE-FORMAT(time,\'%Y%m%d\') BETWEEN "+beginTime+" and "+endTime;
        }
        return Databases.getDb()
                .select(sql)
                .parameter(userId)
                .getAs(Integer.class)
                .blockingFirst()
                ;
    }

    /**
     * 查询所有作品的预约总数
     * @param beginTime
     * @param endTime
     * @return
     */
    public int findAllAppointmentSum(String beginTime, String endTime){
        String sql;
        if(beginTime==null&&endTime==null){
            sql="select count(userid) from D_APPOINTMENT";
        }else {
            sql="select count(userid) from D_APPOINTMENT where DATE-FORMAT(time,\'%Y%m%d\') BETWEEN "+beginTime+" and "+endTime;
        }
        return Databases.getDb()
                .select(sql)
                .getAs(Integer.class)
                .blockingFirst()
                ;
    }

    /**
     * 查询个人新增IP
     * @param userId
     * @param beginTime
     * @param endTime
     * @return
     */
    public int findNewAddIp(int userId,String beginTime, String endTime){
        String sql;
        if(beginTime==null&&endTime==null){
            sql="SELECT CONUNT(ip) FROM TEST ";
        }else {
            sql="";
        }
        return Databases.getDb()
                .select(sql)
                .getAs(Integer.class)
                .blockingFirst()
                ;
    }

    /**
     * 查询用户新增IP
     * @param beginTime
     * @param endTime
     * @return
     */
    public int findAllNewAddIp(String beginTime, String endTime){
        String sql;
        if(beginTime==null&&endTime==null){
            sql="";
        }else {
            sql="";
        }
        return Databases.getDb()
                .select(sql)
                .getAs(Integer.class)
                .blockingFirst()
                ;
    }

    /**
     * 查询个人用户设备
     * @param userId
     * @param beginTime
     * @param endTime
     * @return
     */
    public List<TerminalNum> findTerminal(int userId,String beginTime, String endTime){
        String sql;
        if(beginTime!=null&&endTime!=null){
            sql="SELECT brand,model,COUNT(model) FROM D_LOADRESOURCE WHERE DATE_FORMAT(eventtime,'%Y%m%d')>"+beginTime+" and DATE_FORMAT(eventtime,'%Y%m%d')<"+endTime+" and  authorid="+userId+" GROUP BY brand,model ORDER BY COUNT(model)";
        }else {
            sql="SELECT brand terminalManufacturers,model terminalNumber,COUNT(model) terminalSum FROM D_LOADRESOURCE WHERE authorid="+userId+"GROUP BY brand,model ORDER BY COUNT(model)";
        }
        return Databases.getDb()
                .select(sql)
                .getAs(ITerminalNum.class)
                .map(ITerminalNum::toDomain)
                .toList()
                .blockingGet()
                ;
    }

    /**
     * 查询所有用户使用的设备
     * @param beginTime
     * @param endTime
     * @return
     */
    public List<TerminalNum> findAllTerminal(String beginTime, String endTime){
        String sql;
        if(beginTime!=null&&endTime!=null){
            sql="SELECT brand,model,COUNT(model) FROM D_LOGINAPP WHERE DATE_FORMAT(eventtime,'%Y%m%d')>"+beginTime+" and DATE_FORMAT(eventtime,'%Y%m%d')<"+endTime+" GROUP BY brand,model ORDER BY COUNT(model)";
        }else {
            sql="SELECT brand terminalManufacturers,model terminalNumber,COUNT(model) terminalSum FROM D_LOGINAPP GROUP BY brand,model ORDER BY COUNT(model)";
        }
        return Databases.getDb()
                .select(sql)
                .getAs(ITerminalNum.class)
                .map(ITerminalNum::toDomain)
                .toList()
                .blockingGet()
                ;
    }

    /**
     * 查询个人用户时间段内地域数据
     * @param userId
     * @param beginTime
     * @param endTime
     * @return
     */
    public List<DistrictRate> findDistrict(int userId, String beginTime, String endTime){

        String sql;
        if(beginTime==null&&endTime==null){
            sql="SELECT districtcode district，count(districtcode) num FROM D_LOADRESOURCE WHERE userid="+userId;
        }else {
            sql="SELECT districtcode district，count(districtcode) num FROM D_LOADRESOURCE WHERE DATE_FORMAT(eventtime,'%Y%m%d') > "+beginTime+" and "+endTime+" and userid="+userId;
        }
        return Databases.getDb()
                .select(sql)
                .getAs(IDistrictRate.class)
                .map(IDistrictRate::toDomain)
                .toList()
                .blockingGet()
                ;
    }

    /**
     * 查询所有地域时间段内数据
     * @param beginTime
     * @param endTime
     * @return
     */
    public List<DistrictRate> findAllDistrict(String beginTime, String endTime){
        String sql;
        if(beginTime==null&&endTime==null){
            sql="SELECT districtcode district，count(districtcode) num FROM D_LOADRESOURCE";
        }else {
            sql="SELECT districtcode district，count(districtcode) num FROM D_LOADRESOURCE WHERE DATE_FORMAT(eventtime,'%Y%m%d') > "+beginTime+" and "+endTime;
        }
        return Databases.getDb()
                .select(sql)
                .getAs(IDistrictRate.class)
                .map(IDistrictRate::toDomain)
                .toList()
                .blockingGet()
                ;
    }

}
