package com.zkjl.wf_clserver.core.entity; 

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 驾驶证信息
 * 
 * */
@Document(collection = "driver_info")
@Data
public class DriverInfo {
   /** 驾驶证信息id
    * 
    * */
   @Id
   private String id;
   /** 身份证号
    * 
    * */
   @Field(value = "id_card")
   private String idCard;
   /** 姓名
    * 
    * */
   private String name;
   /** 有效期始
    * 
    * */
   @Field(value = "begin_date")
   private Date beginDate;
   /** 有效期止
    * 
    * */
   @Field(value = "end_date")
   private Date endDate;
   /** 准驾车型
    * 
    * */
   @Field(value = "car_type")
   private String carType;
   /** 联系电话
    * 
    * */
   private String phone;
   /** 驾照状态
    * 
    * */
   @Field(value = "license_status")
   private String licenseStatus;
   /** 档案号
    * 
    * */
   @Field(value = "file_number")
   private String fileNumber;

}