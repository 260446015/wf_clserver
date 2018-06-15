package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  VehicleDropRegister.java
 * Author:  Administrator
 * Purpose: Defines the Class VehicleDropRegister
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 被盗抢骗机动车登记表
 * 
 */
@Document(collection="vehicle_drop_register")
@Data
public class VehicleDropRegister {
   /** 被盗抢骗机动车登记id
    * 
    */
   @Id
   private String id;
   /** 车辆所有人证件号
    * 
    */
   @Field(value = "id_card")
   private String idCard;
   /** 车辆所有人
    * 
    */
   @Field(value = "car_owner")
   private String carOwner;
   /** 涉案物品编号
    * 
    */
   @Field(value = "number")
   private String number;
   /** 车辆类型
    * 
    */
   @Field(value = "car_type")
   private String carType;
   /** 车身颜色
    * 
    */
   @Field(value = "color")
   private String color;
   /** 号牌种类
    * 
    */
   @Field(value = "plate_type")
   private String plateType;
   /** 发动机号
    * 
    */
   @Field(value = "engine_number")
   private String engineNumber;
   /** 车辆品牌型号
    * 
    */
   @Field(value = "brand_model")
   private String brandModel;
   /** 初登日期
    * 
    */
   @Field(value = "initial_date")
   private Date initialDate;
   /** 号牌号码
    * 
    */
   @Field(value = "plate_number")
   private String plateNumber;
   /** 车辆识别代码
    * 
    */
   @Field(value = "id_code")
   private String idCode;
   /** 是否参加被盗抢险
    * 
    */
   @Field(value = "if_join_insurance")
   private String ifJoinInsurance;
   /** 报案人信息
    * 
    */
   @Field(value = "information")
   private String information;
   /** 登记单位
    * 
    */
   @Field(value = "register_unit")
   private String registerUnit;
   /** 登记人
    * 
    */
   @Field(value = "registrant")
   private String registrant;

}