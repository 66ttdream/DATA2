package data.repository.log;

import data.repository.db.Databases;
import data.usecase.port.ILogRepository;
import org.davidmoten.rx.jdbc.Database;

import java.util.*;

public class LogRepository implements ILogRepository {

    @Override
    public void insert(Map<String,String[]> map) {
        Database db = Databases.getDb();
        String str = map.get("eventid")[0];
        //map.remove("eventid",map.get("eventid"));
        StringBuffer sb = new StringBuffer();
        Iterator it = map.keySet().iterator();
        String sql;
        Map<String,String> m = new HashMap<String,String>();
        while (it.hasNext()){
            String key =  (String)it.next();
            m.put(key,map.get(key)[0]);
        }
        m.remove("eventid",m.get("eventid"));
        Iterator itr = m.keySet().iterator();
        switch (str){
            case "1":
                while(itr.hasNext()){
                    String key  = (String)itr.next();
                    if(key=="eventid") {
                        itr.remove();
                        //var sql = "ALTER TABLE D_LOADRESOURCE ADD column_name datatype";
                    }else{
                        sb.append(key);
                        sb.append(" " + map.get(key)[0]);
                        sb.append(",");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                sql = "ALTER TABLE D_LOADRESOURCE ADD "+"( "+sb.toString()+" )";
                //System.out.println(sql);
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
            case "2":
                //map.remove("eventid");
                while(itr.hasNext()){
                    String key  = (String)itr.next();
                    if(key=="eventid") {
                        itr.remove();
                        //var sql = "ALTER TABLE D_SHAREPAGE ADD column_name datatype";
                    }else{
                        sb.append(key);
                        sb.append(" " + map.get(key)[0]);
                        sb.append(",");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                sql = "ALTER TABLE D_SHAREPAGE ADD "+"( "+sb.toString()+" )";
                //System.out.println(sql);
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
            case "3":
                //map.remove("eventid");
                while(itr.hasNext()){
                    String key  = (String)itr.next();
                    if(key=="eventid") {
                        itr.remove();
                        //var sql = "ALTER TABLE D_COSMETOLOGIST ADD column_name datatype";
                    }else{
                        sb.append(key);
                        sb.append(" " + map.get(key)[0]);
                        sb.append(",");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                sql = "ALTER TABLE D_COSMETOLOGIST ADD "+"( "+sb.toString()+" )";
                //System.out.println(sql);
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
            case "4":
                //map.remove("eventid");
                while(itr.hasNext()){
                    String key  = (String)itr.next();
                    if(key=="eventid") {
                        itr.remove();
                        //var sql = "ALTER TABLE D_OPENAPP ADD column_name datatype";
                    }else{
                        sb.append(key);
                        sb.append(" " + map.get(key)[0]);
                        sb.append(",");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                sql = "ALTER TABLE D_OPENAPP ADD "+"( "+sb.toString()+" )";
                //System.out.println(sql);
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
            case "5":
                //map.remove("eventid");
                while(itr.hasNext()){
                    String key  = (String)itr.next();
                    if(key=="eventid") {
                        itr.remove();
                        //var sql = "ALTER TABLE D_FORWARDINGAPP ADD column_name datatype";
                    }else{
                        sb.append(key);
                        sb.append(" " + map.get(key)[0]);
                        sb.append(",");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                sql = "ALTER TABLE D_FORWARDINGAPP ADD "+"( "+sb.toString()+" )";
                //System.out.println(sql);
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
            case "6":
                //map.remove("eventid");
                while(itr.hasNext()){
                    String key  = (String)itr.next();
                    if(key=="eventid") {
                        itr.remove();
                        //var sql = "ALTER TABLE D_ASTERISKAPP ADD column_name datatype";
                    }else{
                        sb.append(key);
                        sb.append(" " + map.get(key)[0]);
                        sb.append(",");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                sql = "ALTER TABLE D_ASTERISKAPP ADD "+"( "+sb.toString()+" )";
                //System.out.println(sql);
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
            case "7":
                //map.remove("eventid");
                while(itr.hasNext()){
                    String key  = (String)itr.next();
                    if(key=="eventid") {
                        itr.remove();
                        //var sql = "ALTER TABLE D_APPOINTMENT ADD column_name datatype";
                    }else{
                        sb.append(key);
                        sb.append(" " + map.get(key)[0]);
                        sb.append(",");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                sql = "ALTER TABLE D_APPOINTMENT ADD "+"( "+sb.toString()+" )";
                //System.out.println(sql);
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
            case "8":
                //map.remove("eventid");
                while(itr.hasNext()){
                    String key  = (String)itr.next();
                    if(key=="eventid") {
                        itr.remove();
                        //var sql = "ALTER TABLE D_APPOINTMENT ADD column_name datatype";
                    }else{
                        sb.append(key);
                        sb.append(" " + map.get(key)[0]);
                        sb.append(",");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                sql = "ALTER TABLE D_LOGINAPP ADD "+"( "+sb.toString()+" )";
                //System.out.println(sql);
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
            case "9":
                //map.remove("eventid");
                while(itr.hasNext()){
                    String key  = (String)itr.next();
                    if(key=="eventid") {
                        itr.remove();
                        //var sql = "ALTER TABLE D_EXITAPP ADD column_name datatype";
                    }else{
                        sb.append(key);
                        sb.append(" " + map.get(key)[0]);
                        sb.append(",");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                sql = "ALTER TABLE D_EXITAPP ADD "+"( "+sb.toString()+" )";
                //System.out.println(sql);
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
        }
    }

    @Override
    public List<String> findConf(String eventid) {
        Database db = Databases.getDb();
        List<String> list = null;
        String sql = "SELECT COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_NAME = ?";
        //= "SELECT COLUMN_NAME FROM information_schema.COLUMNS\n" + "WHERE TABLE_NAME = 'TESTCONF'";
        switch (eventid){
            case "1":
                list=db.select(sql)
                        .parameter("D_LOADRESOURCE")
                        .getAs(String.class)
                        .toList()
                        .blockingGet();
                break;
            case "2":
                list=db.select(sql)
                        .parameter("D_SHAREPAGE")
                        .getAs(String.class)
                        .toList()
                        .blockingGet();
                break;
            case "3":
                list=db.select(sql)
                        .parameter("D_COSMETOLOGIST")
                        .getAs(String.class)
                        .toList()
                        .blockingGet();
                break;
            case "4":
                list=db.select(sql)
                        .parameter("D_OPENAPP")
                        .getAs(String.class)
                        .toList()
                        .blockingGet();
                break;
            case "5":
                list=db.select(sql)
                        .parameter("D_FORWARDINGAPP")
                        .getAs(String.class)
                        .toList()
                        .blockingGet();
                break;
            case "6":
                list=db.select(sql)
                        .parameter("D_ASTERISKAPP")
                        .getAs(String.class)
                        .toList()
                        .blockingGet();
                break;
            case "7":
                list=db.select(sql)
                        .parameter("D_APPOINTMENT")
                        .getAs(String.class)
                        .toList()
                        .blockingGet();
                break;
        }
        //ArrayList<String> al = new ArrayList<String>(list);
        return list;
    }

    @Override
    public void upData(Map<String,String> map) {
        Database db = Databases.getDb();
        Iterator it = map.keySet().iterator();
        StringBuffer values = new StringBuffer();
        StringBuffer tableKey = new StringBuffer();
        while (it.hasNext()){
            String key = (String)it.next();
            tableKey.append(key).append(",");
            values.append(map.get(key)).append(",");
        }
        tableKey.deleteCharAt(tableKey.length()-1);
        values.deleteCharAt(values.length()-1);
        String sql;
        //= "INSERT INTO "+"tablename"+" VALUES( "+"values";
        String eventid = map.get("eventid");
        switch (eventid){
            case "1":
                sql = "INSERT INTO "+"D_LOADRESOURCE ("+tableKey.toString()+") "+" VALUES("+values.toString()+")";
                System.out.println(sql);
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
            case "2":
                sql = "INSERT INTO "+"D_SHAREPAGE ("+tableKey.toString()+") "+" VALUES( "+values.toString()+" )";
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
            case "3":
                sql = "INSERT INTO "+"D_COSMETOLOGIST ("+tableKey.toString()+") "+" VALUES( "+values.toString()+" )";
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
            case "4":
                sql = "INSERT INTO "+"D_OPENAPP ("+tableKey.toString()+") "+" VALUES( "+values.toString()+" )";
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
            case "5":
                sql = "INSERT INTO "+"D_FORWARDINGAPP ("+tableKey.toString()+") "+" VALUES( "+values.toString()+" )";
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
            case "6":
                sql = "INSERT INTO "+"D_ASTERISKAPP ("+tableKey.toString()+") "+" VALUES( "+values.toString()+" )";
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
            case "7":
                sql = "INSERT INTO "+"D_APPOINTMENT ("+tableKey.toString()+") "+" VALUES( "+values.toString()+" )";
                db
                        .update(sql)
                        .complete()
                        .blockingAwait();
                break;
        }
    }
}
