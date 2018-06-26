package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ydw
 * Created on 2018/6/24
 */
@Data
@Document(collection = "log_count")
public class LoginCount implements Serializable{
    private static final long serialVersionUID = 45500933021265254L;
    @Id
    private String id;
    /**登录时间*/
    private Date createTime;
    /**登录ip*/
    private String ip;
    /**登录用户名*/
    private String name;
}
