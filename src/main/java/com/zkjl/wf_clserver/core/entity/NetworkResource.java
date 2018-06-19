package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  NetworkResource.java
 * Author:  Administrator
 * Purpose: Defines the Class NetworkResource
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 网络资源表
 * 
 * @pdOid 1b113b57-8587-4c34-aeb9-86e4c7aff5c3 */
@Document(collection = "network_resource")
@Data
public class NetworkResource {
   /** 网络资源id
    * 
    */
   @Id
   private String id;
   /** 用户id
    * 
    */
   @Field(value = "user_id")
   private String userId;
   /** 名称
    * 
    */
   private String name;
   /** 分类
    * 
    */
   private String classify;
   /** 网址
    * 
    */
   private String website;
   /** 网址详情
    * 
    */
   @Field(value = "website_descirption")
   private String websiteDescirption;
   /** 照片
    * 
    */
   private String photo;
   /** 创建时间
    * 
    */
   @Field(value = "create_date")
   private Date createDate;
   /** 更新时间
    * 
    */
   @Field(value = "update_date")
   private Date updateDate;

}