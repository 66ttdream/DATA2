package data.usecase;

import data.entity.SynLog;
import data.entity.SynParameter;
import data.usecase.exception.ApplicationException;
import data.usecase.port.ISynDataRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TimingRunTask implements Runnable{
    private SynParameter synParameter;
    private TimingSaveData timingSaveData;
    private ISynDataRepository iSynDataRepository;
    private Lock lock = new ReentrantLock();
    public TimingRunTask(SynParameter synParameter,TimingSaveData timingSaveData,ISynDataRepository iSynDataRepository) {
        this.synParameter=synParameter;
        this.timingSaveData=timingSaveData;
        this.iSynDataRepository=iSynDataRepository;
    }

    @Override
    public void run() {
        //TimingSaveData timingSaveData = new TimingSaveData();
        lock.lock();
        int i=6;
        int executNum = 0;
        boolean status= true;
        boolean executStatus = true;
        try {
            timingSaveData.execut(synParameter);
        } catch (ApplicationException e) {
            e.printStackTrace();
            while(executNum<i&&status){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                this.run();
                executNum++;
                if(executNum==i){
                    executStatus = status;
                    status=false;
                }
            }
            //Thread.sleep();
        }
        SynLog synLog  = SynLog.builder()
                .appid(synParameter.getSynParameterId())
                .dataTime(new Date())
                .excutContent("数据同步")
                .executTime(executNum)
                .status(executStatus)
                .build();
        iSynDataRepository.insertSynLog(synLog);
        lock.unlock();

    }

}
