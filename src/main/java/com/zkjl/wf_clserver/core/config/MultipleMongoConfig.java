package com.zkjl.wf_clserver.core.config;

import com.mongodb.MongoClient;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import javax.annotation.Resource;

/**
 * @author ydw
 * Created on 2018/6/23
 */
@Configuration
public class MultipleMongoConfig {
    @Resource
    private MultipleMongoProperties multipleMongoProperties;

    @Resource(name = "kklcMongoProperties")
    private MongoProperties kklcMongoProperties;

    @Primary
    @Bean(name = KklcMongoConfig.MONGO_TEMPLATE)
    public MongoTemplate primaryMongoTemplate() throws Exception {
        return new MongoTemplate(primaryFactory());
    }

    @Bean
    @Primary
    public MongoDbFactory primaryFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(kklcMongoProperties.getHost(), kklcMongoProperties.getPort()),
                kklcMongoProperties.getDatabase());
    }

}
