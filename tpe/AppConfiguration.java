package com.tpe;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.awt.*;
import java.util.Properties;

@Configuration
@ComponentScan("com.tpe") // default com.tpe
@PropertySource("classpath:application.properties")
public class AppConfiguration {
    @Autowired
    Environment environment;

    @Bean
    public Point point(){
        return new Point(56,45);
    }

    @Bean
    public Properties properties(){
        Properties properties = new Properties();
        properties.put("email", environment.getProperty("app.email"));
        properties.put("MYJAVA_HOME", environment.getProperty("JAVA_HOME"));
        return properties;
    }


}
