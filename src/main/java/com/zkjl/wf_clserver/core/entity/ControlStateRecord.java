package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

/** 管控状态记录
 * 
 * */
@Document(collection = "control_state_record")
@Data
public class ControlStateRecord {
   /** 管控状态记录id
    * 
    * */
   @Id
   private String id;
   /** 证件号码
    * 
    * */
   @Field(value = "id_card")
   private String idCard;
   /** 管控状态
    * 
    * */
   private String state;
   /** 管控记录
    * 
    * */
   private String record;
   /** 管控地区
    * 
    * */
   private String area;
   /** 管控单位详称
    * 
    * */
   @Field(value = "unit_detail_name")
   private String unitDetailName;
   /** 开始日期
    * 
    * */
   @Field(value = "begin_date")
   private Date beginDate;
   /** 更新时间
    * 
    * */
   @Field(value = "update_date")
   private Date updateDate;
   /** 后续管控环节
    * 
    * */
   @Field(value = "follow_up_link")
   private String followUpLink;
   /** 后续接管单位
    * 
    * */
   @Field(value = "follow_up_unit")
   private String follow_up_unit;

}