package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 社保信息表
 * 
 */
@Document(collection = "social_security_info")
@Data
public class SocialSecurityInfo {
   /** 社保信息id
    * 
    */
   @Id
   private String id;
   /** 姓名
    * 
    */
   private String name;
   /** 公民身份证号
    * 
    */
   @Field(value = "id_card")
   private String idCard;
   /** 社会保障号码
    * 
    */
   private String number;
   /** 性别
    * 
    */
   private String sex;
   /** 民族
    * 
    */
   private String nation;
   /** 证件类型
    * 
    */
   @Field(value = "card_type")
   private String cardType;
   /** 个人身份
    * 
    */
   private String identity;
   /** 工伤保险参保状态
    * 
    */
   @Field(value = "industrial_status")
   private String industrialStatus;
   /** 生存状态
    * 
    */
   @Field(value = "live_status")
   private String liveStatus;
   /** 生育保险参保状态
    * 
    */
   @Field(value = "birth_insurance_status")
   private String birthInsuranceStatus;
   /** 上报市
    * 
    */
   @Field(value = "states_city")
   private String statesCity;
   /** 医疗保险参保状态
    * 
    */
   @Field(value = "medical_insurance_status")
   private String medicalInsuranceStatus;
   /** 养老保险状态
    * 
    */
   @Field(value = "pension_insurance_status")
   private String pensionInsuranceStatus;
   /** 出生日期
    * 
    */
   private Date birth;
   /** 常住所在地地址
    * 
    */
   @Field(value = "usual_address")
   private String usualAddress;
   /** 常住所在地邮编
    * 
    */
   @Field(value = "usual_place_zip_cood")
   private String usualPlaceZipCood;
   /** 户籍类型
    * 
    */
   @Field(value = "household_type")
   private String householdType;
   /** 户口所在地
    * 
    */
   @Field(value = "residence_place")
   private String residencePlace;
   /** 离退休标志
    * 
    */
   @Field(value = "retirement_sign")
   private String retirementSign;
   /** 联系方式
    * 
    */
   private String contact;
   /** 手机号码
    * 
    */
   private String mobile;

}