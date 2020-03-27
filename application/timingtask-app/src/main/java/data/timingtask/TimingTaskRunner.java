package data.timingtask;

import util.Time;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimingTaskRunner {
    public static void main(String[] args){
        TimingCreateTask worker = new TimingCreateTask();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.scheduleAtFixedRate(worker, Time.getTomorrowBegin(),1, TimeUnit.DAYS);
    }
}
