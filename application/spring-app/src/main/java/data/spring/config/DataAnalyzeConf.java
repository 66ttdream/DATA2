package data.spring.config;

import data.controller.ContentAnalyzeControl;
import data.controller.UserAnalyzeControl;
import data.spring.conf.DataAnalyzeSpringConf;
import data.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataAnalyzeConf {
    private final DataAnalyzeSpringConf dataAnalyzeSpringConf  = new DataAnalyzeSpringConf();
    @Bean
    public ManagerFindActiveUser  getManagerFindActiveUser (){
        return dataAnalyzeSpringConf.getManagerFindActiveUser();
    }
    @Bean
    public ManagerFindHeatwork getManagerFindHeatwork(){
        return dataAnalyzeSpringConf.getManagerFindHeatwork();
    }
    @Bean
    public ManagerFindShareNum getManagerFindShareNum(){
        return dataAnalyzeSpringConf.getManagerFindShareNum();
    }
    @Bean
    public ManagerFindShareRate getManagerFindShareRate(){
        return dataAnalyzeSpringConf.getManagerFindShareRate();
    }
    @Bean
    public ManagerFindUser getManagerFindUser(){
        return dataAnalyzeSpringConf.getManagerFindUser();
    }
    @Bean
    public ManagerFindUseTimeFrame getManagerFindUseTimeFrame() {
        return dataAnalyzeSpringConf.getManagerFindUseTimeFrame() ;
    }
    @Bean
    public ManagerFinNewAddUser  getManagerFinNewAddUser() {
        return dataAnalyzeSpringConf.getManagerFinNewAddUser();
    }
    @Bean
    public ManagerFindTwiceShareRate getManagerFindTwiceShareRate(){
        return dataAnalyzeSpringConf.getManagerFindTwiceShareRate();
    }
    @Bean
    public PractitionerFindActiveUser getPractitionerFindActiveUser() {
        return dataAnalyzeSpringConf.getPractitionerFindActiveUser();
    }
    @Bean
    public PractitionerFindHeatwork getPractitionerFindHeatwork() {
        return dataAnalyzeSpringConf.getPractitionerFindHeatwork();
    }
    @Bean
    public PractitionerFindNewAddUser getPractitionerFindNewAddUser() {
        return dataAnalyzeSpringConf.getPractitionerFindNewAddUser();
    }
    @Bean
    public PractitionerFindShareNum getPractitionerFindShareNum() {
        return dataAnalyzeSpringConf.getPractitionerFindShareNum();
    }
    @Bean
    public PractitionerFindShareRate getPractitionerFindShareRate() {
        return dataAnalyzeSpringConf.getPractitionerFindShareRate();
    }
    @Bean
    public PractitionerFindUser getPractitionerFindUser() {
        return dataAnalyzeSpringConf.getPractitionerFindUser();
    }
    @Bean
    public PractitionerFindUseTimeFrame getPractitionerFindUseTimeFrame() {
        return dataAnalyzeSpringConf.getPractitionerFindUseTimeFrame();
    }
    @Bean
    public PractitionerFindTwiceShareRate getPractitionerFindTwiceShareRate(){
        return dataAnalyzeSpringConf.getPractitionerFindTwiceShareRate();
    }
    @Bean
    public ManagerFindAppointmentNum getManagerFindAppointmentNum(){
        return dataAnalyzeSpringConf.getManagerFindAppointmentNum();
    }
    @Bean
    public PractitionerFindAppointmentNum getPractitionerFindAppointmentNum(){
        return dataAnalyzeSpringConf.getPractitionerFindAppointmentNum();
    }
    @Bean
    public ManagerFindAppointmentSum getManagerFindAppointmentSum(){
        return dataAnalyzeSpringConf.getManagerFindAppointmentSum();
    }
    @Bean
    public PractitionerFindAppointmentSum getPractitionerFindAppointmentSum(){
        return dataAnalyzeSpringConf.getPractitionerFindAppointmentSum();
    }

    @Bean
    public ManagerFindNewAddIp getManagerFindNewAddIp(){
        return dataAnalyzeSpringConf.getManagerFindNewAddIp();
    }
    @Bean
    public PractitionerFindNewAddIp getPractitionerFindNewAddIp(){
        return dataAnalyzeSpringConf.getPractitionerFindNewAddIp();
    }
    @Bean
    public ManagerFindTerminal getManagerFindTerminal(){
        return dataAnalyzeSpringConf.getManagerFindTerminal();
    }
    @Bean
    public PractitionerFindTerminal getPractitionerFindTerminal(){
        return dataAnalyzeSpringConf.getPractitionerFindTerminal();
    }
    @Bean
    public ManagerFindDistrict getManagerFindDistrict(){
        return dataAnalyzeSpringConf.getManagerFindDistrict();
    }
    @Bean
    public PractiotionerFindDistrict getPractiotionerFindDistrict(){
        return dataAnalyzeSpringConf.getPractiotionerFindDistrict();
    }
    @Bean
    public ContentAnalyzeControl getContentAnalyzeControl(){
        return new ContentAnalyzeControl(getPractitionerFindHeatwork(),getManagerFindHeatwork(),getManagerFindShareNum(),getPractitionerFindShareNum(),getManagerFindShareRate(),getPractitionerFindShareRate(),getManagerFindTwiceShareRate(),getPractitionerFindTwiceShareRate());
    }
    @Bean
    public UserAnalyzeControl  getUserAnalyzeControl(){
        return new UserAnalyzeControl(getManagerFindUser(),getPractitionerFindUser(),getManagerFinNewAddUser(),getPractitionerFindNewAddUser(),getManagerFindActiveUser(),getPractitionerFindActiveUser(),getManagerFindUseTimeFrame(),getPractitionerFindUseTimeFrame(),getManagerFindAppointmentNum(),getPractitionerFindAppointmentNum(),getManagerFindAppointmentSum(),getPractitionerFindAppointmentSum(),getManagerFindNewAddIp(),getPractitionerFindNewAddIp(),getManagerFindTerminal(),getPractitionerFindTerminal(),getManagerFindDistrict(),getPractiotionerFindDistrict());
    }

}
