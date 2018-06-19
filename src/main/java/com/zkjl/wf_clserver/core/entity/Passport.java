package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  Passport.java
 * Author:  Administrator
 * Purpose: Defines the Class Passport
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 护照信息
 * 
 */
@Document(collection = "passport")
@Data
public class Passport {
   /** 护照信息id
    * 
    */
   private String id;
   /** 护照类型
    * 
    */
   private String type;
   /** 国家码
    * 
    */
   @Field(value = "country_code")
   private String countryCode;
   /** 护照号码
    * 
    */
   private String number;
   /** 姓名
    * 
    */
   private String name;
   /** 性别
    * 
    */
   private String sex;
   /** 国籍
    * 
    */
   private String nationality;
   /** 出生日期
    * 
    */
   @Field(value = "birth_date")
   private Date birthDate;
   /** 出生地点
    * 
    */
   @Field(value = "birth_place")
   private String birthPlace;
   /** 签发日期
    * 
    */
   @Field(value = "issue_date")
   private Date issueDate;
   /** 签发地点
    * 
    */
   @Field(value = "issue_place")
   private String issuePlace;
   /** 有效期至
    * 
    */
   @Field(value = "expiry_date")
   private Date expiryDate;
   /** 签发机关
    * 
    */
   private String authority;

}