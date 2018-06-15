package com.zkjl.wf_clserver.core.entity; 
/***********************************************************************
 * Module:  car_infor.java
 * Author:  Administrator
 * Purpose: Defines the Class car_infor
 ***********************************************************************/


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** 车辆信息
 * 
 * @pdOid 7716355e-d920-4e07-9d6e-d6f8a8779d21 */
@Document(collection = "car_infor")
@Data
public class CarInfor {
   /** 车辆信息id
    * 
    * @pdOid 9ff17b24-f715-4df0-8c69-3791eb13a474 */
   @Id
   private String id;
   /** 证件号码
    * 
    * @pdOid fa47c3fd-0866-4f60-ac84-136b22ec03a8 */
   @Field(value = "id_card")
   private String idCard;
   /** 图片
    * 
    * @pdOid 63b223c6-848a-4e87-88e5-693bed000d91 */
   private String image;
   /** 号牌号码
    * 
    * @pdOid 06f9ad89-d54d-468c-b46f-16e42858feb8 */
   @Field(value = "plate_numb")
   private String plateNumb;
   /** 号牌种类
    * 
    * @pdOid 3edf25f2-9c41-460b-8cf0-5598cc19c1e2 */
   @Field(value = "plate_category")
   private String plateCategory;
   /** 中文品牌
    * 
    * @pdOid b6f9bbaa-3f84-4539-a8cc-8a333a1c6d0f */
   @Field(value = "chinese_brand")
   private String chineseBrand;
   /** 车身颜色
    * 
    * @pdOid 48bdad6f-e1cb-4e1c-a3af-8f778ce1dbeb */
   private String color;
   /** 车辆类型
    * 
    * @pdOid 37159cb4-addf-41ed-a005-76e6fc33c1ec */
   private String category;
   /** 制造厂名称
    * 
    * @pdOid e47fe778-003f-4898-a8ed-f176a3eeb5c0 */
   @Field(value = "factory_name")
   private String factoryName;
   /** 车辆识别代号
    * 
    * @pdOid 9d3fdc20-c032-41c8-9c52-38aa3fe53396 */
   @Field(value = "vehicle_code")
   private String vehicleCode;
   /** 发动机号
    * 
    * @pdOid 6a354dbb-80a9-45bc-8c2d-97f5840a9800 */
   @Field(value = "engine_number")
   private String engineNumber;
   /** 所有人
    * 
    * @pdOid 87174d3c-414d-4ba9-aca5-dbda3eeb335d */
   private String owner;

}