package data.usecase.port;

import java.util.LinkedList;


public interface ILogGateways {
    public void printLog(LinkedList<String> al,String eventid);
}
