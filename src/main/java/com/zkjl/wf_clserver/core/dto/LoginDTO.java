package com.zkjl.wf_clserver.core.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ydw
 * Created on 2018/6/23
 */
@Data
public class LoginDTO implements Serializable{
    private static final long serialVersionUID = -3116096576862170349L;

    private Integer pageNum;
    private Integer pageSize;
    private String searchStr;
}
