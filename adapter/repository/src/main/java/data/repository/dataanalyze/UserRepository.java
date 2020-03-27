package data.repository.dataanalyze;

import data.repository.db.DBConf;
import data.repository.db.Databases;

public class UserRepository {
    public static String findUserById(int userId){
        var sql = "SELECT "+ DBConf.getUsername_column() +" FROM "+DBConf.getUserDBName()+" WHERE "+ DBConf.getUserid_column()+"=?";
        return Databases.getDb()
                .select(sql)
                .parameter(userId)
                .getAs(String.class)
                .blockingFirst();
    }
}
