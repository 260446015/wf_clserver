package com.zkjl.wf_clserver.core.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author ydw
 * Created on 2018/6/23
 */
@Data
@ConfigurationProperties(prefix = "mongodb")
@Component
public class MultipleMongoProperties {

    @Bean(name = "kklcMongoProperties")
    @Primary
    @ConfigurationProperties(prefix="spring.data.mongodb.primary")
    public MongoProperties kklcMongoProperties() {
        System.out.println("-------------------- kklcMongoProperties init ---------------------");
        return new MongoProperties();
    }

    @Bean
    @ConfigurationProperties(prefix="spring.data.mongodb.secondary")
    public MongoProperties ploverMongoProperties() {
        System.out.println("-------------------- ploverMongoProperties init ---------------------");
        return new MongoProperties();
    }

}
