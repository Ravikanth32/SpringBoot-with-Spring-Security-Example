package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.cgsinc.consumer.controller","demo"})

public class ResourceServiceAppConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceServiceAppConsumerApplication.class, args);
    }
   
}
