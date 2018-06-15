package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  driver_info.java
 * Author:  Administrator
 * Purpose: Defines the Class driver_info
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

/** 驾驶证信息
 * 
 * @pdOid 4c34861e-fcc1-4641-b2fc-7973c17ddf41 */
@Document(collection = "driver_info")
@Data
public class driver_info {
   /** 驾驶证信息id
    * 
    * @pdOid 759a69f4-f471-4c4b-9709-8fc853f73b23 */
   @Id
   private String id;
   /** 身份证号
    * 
    * @pdOid 1c081623-f19c-4275-b91a-d86582013f87 */
   @Field(value = "id_card")
   private String idCard;
   /** 姓名
    * 
    * @pdOid b763ff37-a52f-44f2-b297-80ca95a9860c */
   private String name;
   /** 有效期始
    * 
    * @pdOid 782fd8e4-472b-45b1-9435-a8d1ba526241 */
   @Field(value = "begin_date")
   private java.util.Date beginDate;
   /** 有效期止
    * 
    * @pdOid d5915471-8ce9-46e7-8f09-f9c681ec54eb */
   @Field(value = "end_date")
   private java.util.Date endDate;
   /** 准驾车型
    * 
    * @pdOid 2a003381-c807-4d8e-b2d8-611b05c875d0 */
   @Field(value = "car_type")
   private String carType;
   /** 联系电话
    * 
    * @pdOid 84c5cf58-814a-4ec0-a8ed-486936287a3d */
   private String phone;
   /** 驾照状态
    * 
    * @pdOid ea04f578-47b9-4583-ac02-f72bc993e23e */
   @Field(value = "license_status")
   private String licenseStatus;
   /** 档案号
    * 
    * @pdOid 79e737b7-db11-4caf-ab42-ded741f7a8d5 */
   @Field(value = "file_number")
   private String fileNumber;

}