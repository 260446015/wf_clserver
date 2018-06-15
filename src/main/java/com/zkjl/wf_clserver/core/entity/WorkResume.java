package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  WorkResume.java
 * Author:  Administrator
 * Purpose: Defines the Class WorkResume
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 工作学习履历
 * 
 */
@Document(collection="work_resume")
@Data
public class WorkResume {
   /** 工作学习履历信息id
    * 
    */
   @Id
   private String id;
   /** 证件号码
    * 
    */
   @Field(value = "id_card")
   private String idCard;
   /** 信息来源
    * 
    */
   @Field(value = "source")
   private String source;
   /** 工作单位
    * 
    */
   @Field(value = "workspace")
   private String workspace;
   /** 时间
    * 
    */
   @Field(value = "work_time")
   private Date workTime;
   /** 状态
    * 
    */
   @Field(value = "work_status")
   private String workStatus;

}