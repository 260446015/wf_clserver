package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  SocialInformation.java
 * Author:  Administrator
 * Purpose: Defines the Class SocialInformation
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 社会信息表
 * 
 */
@Document(collection = "social_information")
@Data
public class SocialInformation {
   /** 社会信息id
    * 
    */
   @Id
   private String id;
   /** 上传人用户id
    * 
    */
   @Field(value = "user_id")
   private String userId;
   /** 上传文件
    * 
    */
   private String file;
   /** 创建时间
    * 
    */
   @Field(value = "create_date")
   private Date create_date;

}