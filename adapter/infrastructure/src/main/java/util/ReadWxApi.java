package util;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * 读取微信数据同步的所有api
 * @author Administrator
 *
 */
public class ReadWxApi {
    public  static String getusersummary;
    public  static String getusercumulate;
    public  static String getarticlesummary;
    public  static String getarticletotal;
    public  static String getuserread;
    public  static String getuserreadhour;
    public  static String getusershare;
    public  static String getusersharehour;
    public  static String getupstreammsg;
    public  static String getupstreammsghour;
    public  static String getupstreammsgweek;
    public  static String getupstreammsgmonth;
    public  static String getupstreammsgdist;
    public  static String getupstreammsgdistweek;
    public  static String getupstreammsgdistmonth;
    public  static String getinterfacesummary;
    public  static String getinterfacesummaryhour;
    static{
        Properties p = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream("E:/utilTest/Test/src/conf/conf.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {
            p.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        getusersummary = p.getProperty("getusersummary");
        getusercumulate = p.getProperty("getusercumulate");
        getarticlesummary = p.getProperty("getarticlesummary");
        getarticletotal = p.getProperty("getarticletotal");
        getuserread = p.getProperty("getuserread");
        getuserreadhour = p.getProperty("getuserreadhour");
        getusershare = p.getProperty("getusershare");
        getusersharehour = p.getProperty("getusersharehour");
        getupstreammsg = p.getProperty("getupstreammsg");
        getupstreammsghour = p.getProperty("getupstreammsghour");
        getupstreammsgweek = p.getProperty("getupstreammsgweek");
        getupstreammsgmonth = p.getProperty("getupstreammsgmonth");
        getupstreammsgdist = p.getProperty("getupstreammsgdist");
        getupstreammsgdistweek = p.getProperty("getupstreammsgdistweek");
        getupstreammsgdistmonth = p.getProperty("getupstreammsgdistmonth");
        getinterfacesummaryhour = p.getProperty("getinterfacesummaryhour");
        getinterfacesummary = p.getProperty("getinterfacesummary");
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

