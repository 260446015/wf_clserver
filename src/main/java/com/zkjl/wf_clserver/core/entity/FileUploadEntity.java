package com.zkjl.wf_clserver.core.entity;

import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.util.MD5Util;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ydw
 * Created on 2018/6/30
 */
@Document(indexName = "file_upload", type = "entity")
@Data
public class FileUploadEntity implements Serializable {
    private static final long serialVersionUID = -3707929438516060096L;
    @Id
    private String id;
    private String content;
    private String source;
    private String username;
    private String contentType;
    private Date createTime;
    private Date updateTime;
    private String policeNumber;


    public void generatId() {
        this.id = MD5Util.encrypt(this.content);
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
