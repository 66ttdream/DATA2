package data.repository.db;

import io.reactivex.internal.schedulers.IoScheduler;
import org.davidmoten.rx.jdbc.Database;
import org.davidmoten.rx.jdbc.pool.DatabaseType;

import java.util.concurrent.TimeUnit;

public class Databases {
    private static String  url = DBConf.getUrl();
    //private static String  url = "jdbc:mysql://localhost:3306/data?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static int maxPoolSize = Integer.parseInt(DBConf.getMaxPoolSize());

    public static Database getDb() {
        //Database db = Database.from(url, maxPoolSize);
        Database db = Database
                .nonBlocking()
                // the jdbc url of the connections to be placed in the pool
                .url(url)
                // an unused connection will be closed after thirty minutes
                .maxIdleTime(Integer.parseInt(DBConf.getMaxIdleTime()), TimeUnit.MINUTES)
                //.user("root")
                //.password("102466")
                // connections are checked for healthiness on checkout if the connection
                // has been idle for at least 5 seconds
                .healthCheck(DatabaseType.MYSQL)
                .idleTimeBeforeHealthCheck(Integer.parseInt(DBConf.getIdleTimeBeforeHealthCheck()), TimeUnit.SECONDS)
                // if a connection fails creation then retry after 30 seconds
                // the maximum number of connections in the pool
                .maxPoolSize(maxPoolSize).scheduler(new IoScheduler())
                .build();
        return db;
    }
}
