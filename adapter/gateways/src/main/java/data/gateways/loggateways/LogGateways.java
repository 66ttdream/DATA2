package data.gateways.loggateways;

import data.usecase.port.ILogGateways;
import org.apache.log4j.Logger;
import java.util.LinkedList;

public class LogGateways implements ILogGateways {
    private static Logger logger = Logger.getLogger(LogGateways.class);
    @Override
    public void printLog(LinkedList<String> al,String eventid) {
        StringBuffer sb = new StringBuffer();
        sb.append("|");
        sb.append(eventid);
        for(String str:al){
            sb.append(str);
            sb.append("|");
        }
        logger.info(sb);
    }
}
