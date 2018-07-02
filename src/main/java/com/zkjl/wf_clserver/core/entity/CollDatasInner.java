package com.zkjl.wf_clserver.core.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ydw
 * Created on 2018/6/28
 */
@Data
public class CollDatasInner implements Serializable {
    private static final long serialVersionUID = 924715252047104140L;

    private CollDatasInnerInner data;
    private String label;
    private String format;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
