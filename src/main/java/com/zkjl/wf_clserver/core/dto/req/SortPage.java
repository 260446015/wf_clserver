package com.zkjl.wf_clserver.core.dto.req;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;


@Data
public class SortPage extends AbstractPageRQ{

    private JSONObject data;

    private Integer sortType;

    private String sortMsg;

    private boolean isPage;
}
