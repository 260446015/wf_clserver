package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 资源库
 * 
 */
@Document(collection = "resource_library")
@Data
public class ResourceLibrary {
   /** 资源库id
    * 
    */
   @Id
   private String id;
   /** 用户id
    * 
    */
   @Field(value = "user_id")
   private String userId;
   /** 用户名
    * 
    */
   @Field(value = "user_name")
   private String userName;
   /** 标题
    * 
    */
   private String title;
   /** 大小
    * 
    */
   private String size;
   /** 类别
    * 
    */
   private String category;
   /** 转码状态
    * 
    */
   private String state;
   /** 创建时间
    * 
    */
   @Field(value = "create_date")
   private Date createDate;
   /** 更新时间
    * 
    */
   @Field(value = "update_date")
   private Date update_date;

}