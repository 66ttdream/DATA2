package data.TimingTask.conf;

import data.gateways.datagateways.WxDataGateways;
import data.repository.syndata.SynDataRepository;
import data.repository.synparameter.SynPerameterRepository;
import data.usecase.TimingCreateTask;
import data.usecase.TimingRunTask;
import data.usecase.TimingSaveData;
import data.usecase.port.ISynDataRepository;
import data.usecase.port.IWxDataGateways;
import data.usecase.port.SynParmeterRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class TimingTaskConfig {

    private SynParmeterRepository synParmeterRepository = new SynPerameterRepository();
    private IWxDataGateways iWxDataGateways = new WxDataGateways();
    private ISynDataRepository iSynDataRepository = new SynDataRepository();


    public TimingSaveData TimingSaveData(){
        return new TimingSaveData(iWxDataGateways,iSynDataRepository);
    }
    /*public TimingCreateTask TimingCreateTask(){
        return new TimingCreateTask(synParmeterRepository);
    }*/
   /* public TimingRunTask TimingRunTask(){
        return new TimingRunTask(iSynDataRepository,iSynDataRepository,);
    }*/
   public SynParmeterRepository getSynPerameterRepository(){
       return this.synParmeterRepository;
   }
   public IWxDataGateways getIWxDataGateways(){
       return this.iWxDataGateways;
   }
   public ISynDataRepository getSynDataRepository(){
       return this.iSynDataRepository;
   }
}
