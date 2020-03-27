package data.spring.conf;

import data.gateways.loggateways.LogGateways;
import data.repository.log.LogRepository;
import data.usecase.PrintLog;
import data.usecase.SaveLog;
import data.usecase.SaveLogConfig;
import data.usecase.port.ILogGateways;
import data.usecase.port.ILogRepository;
import org.davidmoten.rx.jdbc.Database;
import org.davidmoten.rx.jdbc.pool.Pools;

public class LogSpringConf {
   /*private final SaveLogConfig saveLogConfig = new SaveLogConfig();
   private final SaveLog saveLog = new SaveLog();
   private final PrintLog printLog = new PrintLog();
   private final DB databases = new DB();*/
   private final ILogGateways iLogGateways = new LogGateways();
   private final ILogRepository iLogRepository = new LogRepository();
   public SaveLogConfig getSaveLogConfig(){
       return new SaveLogConfig(iLogRepository);
   }
   public SaveLog getSaveLog(){
       return new SaveLog(iLogRepository);
   }
   public PrintLog getPrintLog(){
       return new PrintLog(iLogGateways,iLogRepository);
   }

}
