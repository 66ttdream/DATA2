package data.usecase.port;

import java.util.List;
import java.util.Map;

public interface ILogRepository {
    public void insert(Map<String,String[]> map);
    public List<String> findConf(String eventid);
    public void upData(Map<String,String> map);
}
