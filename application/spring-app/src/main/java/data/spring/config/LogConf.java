package data.spring.config;

import data.controller.LogControl;
import data.spring.conf.LogSpringConf;
import data.usecase.PrintLog;
import data.usecase.SaveLog;
import data.usecase.SaveLogConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConf {
    private final LogSpringConf logSpringConf = new LogSpringConf();
    @Bean
    public SaveLogConfig saveLogConfig(){
        return logSpringConf.getSaveLogConfig();
    }
    @Bean
    public SaveLog saveLog(){
        return logSpringConf.getSaveLog();
    }
    @Bean
    public PrintLog printLog(){
        return logSpringConf.getPrintLog();
    }
    @Bean
    public LogControl logControl(){
        return new LogControl(saveLogConfig(),saveLog(),printLog());
    }

}
