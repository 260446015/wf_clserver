package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "coll_confs")
@Data
public class Confs {

    @Id
    private String _id;

    private String id;

    private String systemuser;

    private String username;

    private String password;

    @Field(value = "platform_name")
    private String platformName;

    @Field(value = "create_date")
    private Date createDate;

}
