package com.zkjl.wf_clserver.core.entity;

import com.zkjl.wf_clserver.core.util.DateUtils;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 用户实体类
 */
@Data
@Document(collection = "log")
public class Log {
    private String id; // 主键
    private String sysUserId; // 操作人
    private String category; // 操作类型
    private String description; // 操作描述
    private String args;//参数
    private String ip; // 操作ip
    private String name; // 操作人姓名
    private String type; //日志类型(info:入库,error:错误)
    private Date createDate;
    private String delFlag;
    private String requestUri;//请求的Uri

    public String getCreateDate() {
        return DateUtils.getFormatString(this.createDate);
    }
}
