package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  StabilityPoint.java
 * Author:  Administrator
 * Purpose: Defines the Class StabilityPoint
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 维稳重点人信息
 * 
 */
@Document(collection = "stability_point")
@Data
public class StabilityPoint {
   /** 维稳重点人信息id
    * 
    */
   @Id
   private String id;
   /** 证件号码
    * 
    */
   @Field(value = "id_card")
   private String id_card;
   /** 照片
    * 
    */
   private String photo;
   /** 证件类型
    * 
    */
   @Field(value = "card_type")
   private String cardType;
   /** 姓名
    * 
    */
   private String name;
   /** 别名
    * 
    */
   private String nickname;
   /** 性别
    * 
    */
   private String sex;
   /** 曾用名
    * 
    */
   @Field(value = "used_name")
   private String usedName;
   /** 出生日期
    * 
    */
   @Field(value = "birth_date")
   private Date birthDate;
   /** 绰号
    * 
    */
   private String epithet;
   /** 联系电话
    * 
    */
   private String phone;
   /** 国籍
    * 
    */
   private String nationality;
   /** 户籍地
    * 
    */
   @Field(value = "domicile_place")
   private String domicilePlace;
   /** 民族
    * 
    */
   private String nation;
   /** 现住址
    * 
    */
   @Field(value = "present_address")
   private String presentAddress;
   /** 政治面貌
    * 
    */
   @Field(value = "political_outlook")
   private String politicalOutlook;
   /** 工作单位
    * 
    */
   private String workspace;
   /** 文化程度
    * 
    */
   private String education;
   /** 案由
    * 
    */
   @Field(value = "case")
   private String cases;
   /** 特殊群体
    * 
    */
   @Field(value = "special_group")
   private String specialGroup;
   /** 是否到案
    * 
    */
   @Field(value = "is_appear")
   private String isAppear;

}