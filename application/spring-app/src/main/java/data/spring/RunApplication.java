package data.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration
//@ComponentScan(value = {"data/spring/config"})
@SpringBootApplication
public class RunApplication {
        public static void main(String[] args) {
        SpringApplication.run(RunApplication.class, args);
    }

}

