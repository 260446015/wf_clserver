package com.zkjl.wf_clserver.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author ydw
 * Created on 2018/6/23
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.zkjl.wf_clserver.core.repository.kklc",
        mongoTemplateRef = KklcMongoConfig.MONGO_TEMPLATE)
public class KklcMongoConfig {
        protected static final String MONGO_TEMPLATE = "primaryMongoTemplate";
}
