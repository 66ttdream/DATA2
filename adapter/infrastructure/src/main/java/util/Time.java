package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间操作的工具类
 * @author liu
 *
 */
public class Time {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    static Date da = new Date();
    /**
     * 获取时间段内所有按天的时间
     * @param dBegin 开始时间
     * @param dEnd 结束时间
     * @return 开始时间与结束时间段内的所有时间
     * @throws ParseException
     */
    public static List<String> findDates(String dBegin, String dEnd) throws ParseException {
        //日期工具类准备
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        //设置开始时间
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(format.parse(dBegin));

        //设置结束时间
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(format.parse(dEnd));

        //装返回的日期集合容器
        List<String> Datelist = new ArrayList<String>();

        // 每次循环给calBegin日期加一天，直到calBegin.getTime()时间等于dEnd
        while (format.parse(dEnd).after(calBegin.getTime()))  {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            Datelist.add(format.format(calBegin.getTime()));
        }

        //打印结果 [2018-10-01, 2018-10-02, 2018-10-03, 2018-10-04, 2018-10-05, 2018-10-06, 2018-10-07, 2018-10-08, 2018-10-09, 2018-10-10, 2018-10-11, 2018-10-12, 2018-10-13, 2018-10-14, 2018-10-15, 2018-10-16, 2018-10-17, 2018-10-18, 2018-10-19, 2018-10-20, 2018-10-21, 2018-10-22, 2018-10-23, 2018-10-24, 2018-10-25]
        System.out.println(Datelist);
        return Datelist;
    }
    /**
     * 获取系统此刻时间
     * @return
     */
    public static String getNowTime() {
        String nowTime = sdf.format(da).toString();
        return nowTime;

    }
    /**
     * 获取接口post当前时间参数字符串
     * @return
     */
    public static Date generateSynTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,-1);
        Date date = calendar.getTime();
        return date;

    }
    /**
     *
     * @return 接口POST时间参数的时间集合
     * @throws ParseException
     */
    public static List<String> getPostMuchTime(String dBegin,String dEnd) throws ParseException{
        List<String> muchTime = Time.findDates(dBegin, dEnd);
        List<String> postMuchTime = new ArrayList<String>();
        for(String dayTime:muchTime) {

            StringBuffer str = new StringBuffer();
            str.append("{\"begin_date\": \"");
            str.append(dayTime);
            str.append("\",\"end_date\": \"");
            str.append(dayTime);
            //System.out.println(sdf.parse(dayTime));
            str.append("\"}");
            postMuchTime.add(str.toString());
        }

        return postMuchTime;

    }

    /**
     * 获取凌晨时刻
     * @return
     */
    public static long getTomorrowBegin() {
        long now = System.currentTimeMillis() / 1000l;
        long daySecond = 60 * 60 * 24;
        long dayTime = now - (now + 8 * 3600) % daySecond + 1*daySecond; return dayTime;
    }

    public static Map<String,String> getTimeFrame(int timeSegment){
        Map<String,String> map = new LinkedHashMap<String,String>();
        if(timeSegment>24&&24%timeSegment!=0){
            return null;
        }else {
           int timeSegmentLength =  24/timeSegment;
           for(int i=1;i<=timeSegmentLength;i++){
               String key = String.valueOf((i-1)*timeSegment)+":00:00";
               String value = String.valueOf(timeSegment*i-1)+":59:59";
               map.put(key,value);
           }
        }
        return map;
    }


}
