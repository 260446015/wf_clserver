package com.zkjl.wf_clserver.core.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

/**
 * @author ydw
 * Created on 2018/6/28
 */
@Document(collection = "coll_datas")
@Data
public class CollDatas implements Serializable {
    private static final long serialVersionUID = -8993546418761048850L;

    @Id
    @Field(value = "_id")
    private String id;

    private List<CollDatasInner> data;
    private String word;
    private String wordtype;
    private String jobid;
    private String resid;
    private Integer jobtype;
    private Integer code;
    private String msg;
    private Integer exetime;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
