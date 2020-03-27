package data.config;

import data.TimingTask.conf.TimingTaskConfig;
import data.usecase.TimingSaveData;
import data.usecase.port.ISynDataRepository;
import data.usecase.port.IWxDataGateways;
import data.usecase.port.SynParmeterRepository;

public class DependConf {
    public static TimingTaskConfig getTimingTaskConfig(){
        TimingTaskConfig timingTaskConfig= new TimingTaskConfig();
        return timingTaskConfig;
    }
    public static SynParmeterRepository getSynPerameterRepository(){
        return getTimingTaskConfig().getSynPerameterRepository();
    }
    public static IWxDataGateways getIWxDataGateways(){
        return getTimingTaskConfig().getIWxDataGateways();
    }
    public static ISynDataRepository getSynDataRepository(){
        return getTimingTaskConfig().getSynDataRepository();
    }
    public static TimingSaveData TimingSaveData(){
        return getTimingTaskConfig().TimingSaveData();
    }
}
