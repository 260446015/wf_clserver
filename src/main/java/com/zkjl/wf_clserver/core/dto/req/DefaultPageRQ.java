package com.zkjl.wf_clserver.core.dto.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@ApiModel
@Data
public class DefaultPageRQ extends AbstractPageRQ{
    private static final long serialVersionUID = -4045422720156943459L;
    private String name;
    private Date beginDate;
    private Date endDate;
}
