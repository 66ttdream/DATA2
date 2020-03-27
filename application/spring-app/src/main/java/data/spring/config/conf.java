package data.spring.config;

import data.controller.InterfaceParameterControl;
import data.spring.conf.SpringConf;
import data.usecase.DeleteSynParameter;
import data.usecase.SaveSynParameter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class conf {
    private final SpringConf config = new SpringConf();

    @Bean
    public  SaveSynParameter getSaveSynParameter(){
        return config.saveSynParameter();
    }
    @Bean
    public DeleteSynParameter  getDeleteSynParameter(){
        return config.deleteSynParameter();
    }

    @Bean
    public InterfaceParameterControl getTimerSynDataControl(){
        return new InterfaceParameterControl(getSaveSynParameter(),getDeleteSynParameter());
    }


}
