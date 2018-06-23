package com.zkjl.wf_clserver.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author ydw
 * Created on 2018/6/23
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.zkjl.wf_clserver.core.repository.plover",
        mongoTemplateRef = PloverMongoConfig.MONGO_TEMPLATE)
public class PloverMongoConfig {
    protected static final String MONGO_TEMPLATE = "secondaryMongoTemplate";
}
