package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  Train.java
 * Author:  Administrator
 * Purpose: Defines the Class Train
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** 火车
 * 
 */
@Document(collection = "train")
@Data
public class Train {
   /** 火车记录id
    * 
    */
   @Id
   private String id;
   /** 乘客姓名
    * 
    */
   @Field(value = "full_name")
   private String fullName;
   /** 乘客年龄
    * 
    */
   private int age;
   /** 乘客身份证号
    * 
    */
   @Field(value = "id_card")
   private String idCard;
   /** 日期
    * 
    */
   @Field(value = "ride_date")
   private java.util.Date rideDate;
   /** 事项
    * 
    */
   private String matter;
   /** 状态
    * 
    */
   private String status;
   /** 类别
    * 
    */
   private String category;
   /** 出发地
    * 
    */
   @Field(value = "from_address")
   private String fromAddress;
   /** 目的地
    * 
    */
   private String destination;
   /** 座位号
    * 
    */
   private String seat;
   /** 车次
    * 
    */
   @Field(value = "train_number")
   private String trainNumber;

}