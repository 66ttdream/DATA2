package data.timingtask;

import data.config.DependConf;
import data.entity.SynParameter;
import data.usecase.TimingRunTask;
import data.usecase.TimingSaveData;
import data.usecase.port.ISynDataRepository;
import data.usecase.port.SynParmeterRepository;

import java.util.List;

public class TimingCreateTask implements Runnable{

    private SynParmeterRepository synParmeterRepository = DependConf.getSynPerameterRepository();
    private TimingSaveData timingSaveData = DependConf.TimingSaveData();
    private ISynDataRepository iSynDataRepository = DependConf.getSynDataRepository();

    public TimingCreateTask() {
    }

    @Override
    public void run() {
        List<SynParameter> list = synParmeterRepository.findAllParameter();
        for(int i=0;i<list.size();i++){
            TimingRunTask timingRunTask = new TimingRunTask(list.get(i),timingSaveData,iSynDataRepository);
            timingRunTask.run();
        }
    }
}
