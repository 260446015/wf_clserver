package com.zkjl.wf_clserver.core.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ydw
 * Created on 2018/6/28
 */
@Data
public class CollDatasInnerInner implements Serializable{
    private static final long serialVersionUID = -7785922579280774125L;
    private String[] column;
    private String[][] data;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
