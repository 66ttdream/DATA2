package data.spring.controller;

import data.controller.InterfaceParameterControl;
import data.controller.modle.CancleParameterWeb;
import data.controller.modle.SynParameterWeb;
import data.usecase.exception.AccessTokenException;
import data.usecase.exception.NotExistException;
import data.usecase.exception.UserTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/syn")
@RestController
public class SynController {

    private final InterfaceParameterControl interfaceParameterControl;
    @Autowired
    public SynController(InterfaceParameterControl interfaceParameterControl) {
        this.interfaceParameterControl = interfaceParameterControl;
    }
    @GetMapping(value = "/test")
    public String test(){
        return "nihao";
    }

    @PostMapping(value = "/start")
    public String synStart(@RequestBody SynParameterWeb synParameterWeb) {
        try {
            interfaceParameterControl.start(synParameterWeb);
        } catch (AccessTokenException e) {
            e.printStackTrace();
            return e.getMsg();
        }catch (UserTypeException e){
            e.printStackTrace();
            return e.getMsg();
        }
        return "successful";

    }
    @PostMapping(value = "/cancel")
    public String synCancel(@RequestBody CancleParameterWeb appid) {
        System.out.println(appid);
        try {
            interfaceParameterControl.cancel(appid);
        } catch (NotExistException e) {
            e.printStackTrace();
            return e.getMsg();
        }
        return "successful";
    }
}
