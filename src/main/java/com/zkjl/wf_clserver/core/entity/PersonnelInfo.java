package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  PersonnelInfo.java
 * Author:  Administrator
 * Purpose: Defines the Class PersonnelInfo
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 人员基本信息表
 * 
 */
@Document(collection = "personnel_info")
@Data
public class PersonnelInfo {
   /** 人员基本信息id
    * 
    */
   private String id;
   /** 身份证
    * 
    */
   @Field(value = "id_card")
   private String idCard;
   /** 人员姓名
    * 
    */
   private String name;
   /** 头像
    * 
    */
   private String avatar;
   /** 曾用名
    * 
    */
   @Field(value = "used_name")
   private String usedName;
   /** 性别
    * 
    */
   private String sex;
   /** 民族
    * 
    */
   private String nation;
   /** 文化程度
    * 
    */
   private String education;
   /** 籍贯
    * 
    */
   @Field(value = "native_place")
   private String nativePlace;
   /** 出生日期
    * 
    */
   @Field(value = "birth_date")
   private Date birthDate;
   /** 政治面貌
    * 
    */
   @Field(value = "political_outlook")
   private String politicalOutlook;
   /** 主要成就
    * 
    */
   private String achievement;
   /** 信仰
    * 
    */
   private String faith;
   /** 初领身份证地址
    * 
    */
   @Field(value = "initial_address")
   private String initialAddress;
   /** 住所详细地址
    * 
    */
   @Field(value = "residence_address")
   private String residenceAddress;
   /** 婚姻状况
    * 
    */
   @Field(value = "marital_status")
   private String maritalStatus;
   /** 工作单位
    *
    */
   private String workplace;
   /** 人员标签
    * 
    */
   private String tag;
   /** 户籍所在地派出所
    * 
    */
   @Field(value = "local_police")
   private String local_police;

}