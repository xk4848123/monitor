package cn.chendi.monitorclient;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "monitor",name = "enable",havingValue = "true")
@ComponentScan("cn.chendi.monitorclient")
public class AutoConfigrutionClass {



}

