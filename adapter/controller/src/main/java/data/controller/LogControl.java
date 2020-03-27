package data.controller;

import data.usecase.PrintLog;
import data.usecase.SaveLog;
import data.usecase.SaveLogConfig;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class LogControl {
    private SaveLogConfig saveLogConfig;
    private SaveLog saveLog;
    private PrintLog printLog;

    public List<String> setConf(Map<String, String[]> map) {
        return saveLogConfig.execut(map);
    }
    public void proccess(Map<String,String[]> map){
        printLog.execut(map);
        saveLog.execut(map);
    }
}
