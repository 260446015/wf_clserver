package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  SysLog.java
 * Author:  Administrator
 * Purpose: Defines the Class SysLog
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 操作日志表
 * 
 */
@Document(collection = "sys_log")
@Data
public class SysLog {
   /** 日志id
    * 
    */
   @Id
   private String id;
   /** 操作人
    * 
    */
   @Field(value = "sys_user_id")
   private String sys_user_id;
   /** 操作类型
    * 
    */
   private String category;
   /** 操作描述
    * 
    */
   private String description;
   /** 操作ip
    * 
    */
   private String ip;
   /** 操作人姓名
    * 
    */
   private String username;
   /** 创建时间
    * 
    */
   @Field(value = "create_date")
   private Date createDate;
   /** 是否删除
    * 
    */
   @Field(value = "del_flag")
   private String del_flag;

}