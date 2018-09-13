package com.zkjl.wf_clserver.core.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LinkDTO implements Serializable {
    private static final long serialVersionUID = -2757383688408447394L;

    private String name;
    private String linkType;
    private Integer pageNum;
    private Integer pageSize;
}
