package com.zkjl.wf_clserver.core.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public abstract class AbstractPageRQ implements Serializable {

    private int pageNum = 1;

    private int pageSize = 10;

    @ApiModelProperty(value="第几页", example="1")
    public int getPageNum()
    {
        return this.pageNum;
    }

    public void setPageNum(int pageNum)
    {
        this.pageNum = pageNum;
    }

    @ApiModelProperty(value="每页多少条记录", example="10")
    public int getPageSize()
    {
        return this.pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }
}
