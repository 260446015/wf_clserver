package com.zkjl.wf_clserver.core.entity; 

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** 车辆信息
 * 
 * */
@Document(collection = "car_infor")
@Data
public class CarInfor {
   /** 车辆信息id
    * 
    * */
   @Id
   private String id;
   /** 证件号码
    * 
    * */
   @Field(value = "id_card")
   private String idCard;
   /** 图片
    * 
    * */
   private String image;
   /** 号牌号码
    * 
    * */
   @Field(value = "plate_numb")
   private String plateNumb;
   /** 号牌种类
    * 
    * */
   @Field(value = "plate_category")
   private String plateCategory;
   /** 中文品牌
    * 
    * */
   @Field(value = "chinese_brand")
   private String chineseBrand;
   /** 车身颜色
    * 
    * */
   private String color;
   /** 车辆类型
    * 
    * */
   private String category;
   /** 制造厂名称
    * 
    * */
   @Field(value = "factory_name")
   private String factoryName;
   /** 车辆识别代号
    * 
    * */
   @Field(value = "vehicle_code")
   private String vehicleCode;
   /** 发动机号
    * 
    * */
   @Field(value = "engine_number")
   private String engineNumber;
   /** 所有人
    * 
    * */
   private String owner;

}