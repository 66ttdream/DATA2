package data.usecase;

import data.entity.SynParameter;
import data.usecase.port.ISynDataRepository;
import data.usecase.port.SynParmeterRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Deprecated
public class TimingCreateTask implements Runnable{
    private SynParmeterRepository synParmeterRepository;
    private TimingSaveData timingSaveData;
    private ISynDataRepository iSynDataRepository;

    @Override
    public void run() {
        List<SynParameter> list = synParmeterRepository.findAllParameter();
        for(int i=0;i<list.size();i++){
            TimingRunTask timingRunTask = new TimingRunTask(list.get(i),timingSaveData,iSynDataRepository);
            timingRunTask.run();
        }
    }
}
