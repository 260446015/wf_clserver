package com.zkjl.wf_clserver.core.dto.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class SysuserVO {
    /** 用户id
     *
     */
    private String id;
    /** 姓名
     *
     */
    private String name;
    /** 用户名
     *
     */
    private String username;
    /** 警号
     *
     */
    private String policeNumber;
    /**
     *是否系统管理员
     */
    private Boolean ifAdmin;
    /**
     * 上传头像
     * @return
     */
    private String image;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
