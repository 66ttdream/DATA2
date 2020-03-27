package data.repository.db;

import java.util.Map;

public class DBConf {
    static String url;
    static String maxPoolSize;
    static String maxIdleTime;
    static String user;
    static String password;
    static String idleTimeBeforeHealthCheck;
    static String userDBName;
    static String userid_column;
    static String username_column;
    static String contentDBName;
    static String contentid_column;
    static String contentname_column;
    static Map<String, String> map;
    static {
        map = System.getenv();
        url = map.get("URL");
        maxPoolSize = map.get("MAX_POOLSIZE");
        maxIdleTime = map.get("MAX_IDLETIME");
        user = map.get("USER");
        password = map.get("PASSWORD");
        idleTimeBeforeHealthCheck = map.get("IDLETIMEBEFOREHEALTHCHECK");
        userDBName = map.get("USERDBNAME");
        userid_column = map.get("USERID_COLUMN");
        username_column = map.get("USERNAME_COLUMN");
        contentDBName = map.get("CONTENTDBNAME");
        contentid_column = map.get("CONTENTID_COLUMN");
        contentname_column = map.get("CONTENTNAME_COLUMN");
    }

    public static String getUrl() {
        return url;
    }

    public static String getMaxPoolSize() {
        if(maxPoolSize==null){
            maxPoolSize = "1";
        }
        if(Integer.parseInt(maxPoolSize)>5){
            maxPoolSize="5";
        }
        return maxPoolSize;
    }

    public static String getMaxIdleTime() {
        if(maxIdleTime==null){
            maxIdleTime = "30";
        }
        return maxIdleTime;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static String getIdleTimeBeforeHealthCheck() {
        if(idleTimeBeforeHealthCheck==null){
            idleTimeBeforeHealthCheck = "5";
        }
        return idleTimeBeforeHealthCheck;
    }

    public static String getUserDBName() {
        return userDBName;
    }

    public static String getUserid_column() {
        return userid_column;
    }

    public static String getUsername_column() {
        return username_column;
    }

    public static String getContentDBName() {
        return contentDBName;
    }

    public static String getContentid_column() {
        return contentid_column;
    }

    public static String getContentname_column() {
        return contentname_column;
    }
}