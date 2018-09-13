package com.zkjl.wf_clserver.core.dto;

import lombok.Data;

import java.util.List;

@Data
public class TrackDto {
    private String name;
    private String address;
    private String stayDate;
    private List dataList;
    private List columns;
    private String mark;
}
