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
 * @pdOid 2a1c2d81-091f-4743-bc1d-deda77d6e5a8 */
@Document(collection = "train")
@Data
public class Train {
   /** 火车记录id
    * 
    * @pdOid b94f3218-907f-47d1-be02-62f2a3c6fa82 */
   @Id
   public String id;
   /** 乘客姓名
    * 
    * @pdOid b0cc2a77-54eb-427b-904e-d6ebed8fb1cc */
   @Field(value = "full_name")
   public String fullName;
   /** 乘客年龄
    * 
    * @pdOid d09f90b2-e8cd-47c7-b07d-fcecc1627e6e */
   public int age;
   /** 乘客身份证号
    * 
    * @pdOid f3c8b6b0-80be-4ef4-9854-b42b5498c2a8 */
   @Field(value = "id_card")
   public String idCard;
   /** 日期
    * 
    * @pdOid 32b68c9c-0f0d-41d7-a766-1ccff72737c8 */
   @Field(value = "ride_date")
   public java.util.Date rideDate;
   /** 事项
    * 
    * @pdOid b5398b98-ecde-4a1a-b169-77e6a7342b5a */
   public String matter;
   /** 状态
    * 
    * @pdOid 722a6118-0bb7-42a7-8335-5a189a7d8107 */
   public String status;
   /** 类别
    * 
    * @pdOid 39347ac3-1268-43eb-a9b8-1e3fbc8cbbf0 */
   public String category;
   /** 出发地
    * 
    * @pdOid 5b75154d-ffc1-459b-b6fa-229e07efd1bd */
   @Field(value = "from_address")
   public String fromAddress;
   /** 目的地
    * 
    * @pdOid 6404e687-4222-4e64-acd9-958026bb3f3a */
   public String destination;
   /** 座位号
    * 
    * @pdOid 7f5ed49b-c67b-426c-9cb8-640e6189c437 */
   public String seat;
   /** 车次
    * 
    * @pdOid ead82974-b8eb-441e-ac21-ecbb88d6c9f1 */
   @Field(value = "train_number")
   public String trainNumber;

}