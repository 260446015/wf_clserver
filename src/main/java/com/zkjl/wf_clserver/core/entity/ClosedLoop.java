package com.zkjl.wf_clserver.core.entity;
/***********************************************************************
 * Module:  closed_loop.java
 * Author:  Administrator
 * Purpose: Defines the Class closed_loop
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 闭环系统信息
 * 
 * @pdOid 6d49136d-c569-48bd-be6a-73577f6240f1 */
@Document(collection = "closed_loop")
@Data
public class ClosedLoop {
   /** 闭环系统信息id
    * 
    * @pdOid 98695ae4-1b34-40ff-8321-0a14c7e24a62 */
   @Id
   private String id;
   /** 证件号码
    * 
    * @pdOid 43d9a017-3483-4424-8501-11d442bf1fee */
   @Field(value = "id_card")
   private String idCard;
   /** 接警单位
    * 
    * @pdOid 703f82a0-41a9-4bf4-a5c9-5c005972c41e */
   @Field(value = "receiving_unit")
   private String receivingUnit;
   /** 接警人
    * 
    * @pdOid 5a6fd835-5ed5-4ef9-b387-d473b66aabf3 */
   private String police;
   /** 接警时间
    * 
    * @pdOid 9caef369-87ab-40cc-b863-7b5d8596377b */
   @Field(value = "receive_time")
   private Date receiveTime;
   /** 报警方式
    * 
    * @pdOid 7500defe-9c99-49e5-8fe1-240da95d5c9b */
   @Field(value = "receive_mode")
   private String receiveMode;
   /** 录音号
    * 
    * @pdOid c519d4e8-558a-40c6-8b02-6f3eddfa94f5 */
   @Field(value = "tape_number")
   private String tapeNumber;
   /** 报警电话
    * 
    * @pdOid 621f226a-67b3-4e46-b6ab-927dc3805651 */
   @Field(value = "alarm_phone")
   private String alarmPhone;
   /** 用户姓名
    * 
    * @pdOid 398bbbe3-2de0-40eb-9937-e13462fce61a */
   private String name;
   /** 装机地址
    * 
    * @pdOid fc070a5c-ecff-42b9-9834-617a7f410043 */
   @Field(value = "installed_address")
   private String installedAddress;
   /** 报警人
    * 
    * @pdOid 9680d68d-ef2c-46e9-8f5a-2cb4545ec958 */
   @Field(value = "alarm_person")
   private String alarmPerson;
   /** 性别
    * 
    * @pdOid a8b7be87-ad77-4924-8c9e-539afd2f3740 */
   private String sex;
   /** 联系电话
    * 
    * @pdOid 91970101-df79-484b-a53d-ffab117e3d7a */
   private String phone;
   /** 联系地址
    * 
    * @pdOid 11f1109e-d7bb-4bed-bb48-aa3bda65fd93 */
   private String address;
   /** 事发地址
    * 
    * @pdOid 0c7c300f-5542-4d71-8b19-717b4ac5f895 */
   @Field(value = "incident_address")
   private String incidentAddress;
   /** 所属分局
    * 
    * @pdOid 6c078099-60c9-4285-b380-5c7ade6cf320 */
   private String branches;
   /** 辖区单位
    * 
    * @pdOid 92c983c0-ebf4-4156-a4b3-c4734c0cee4e */
   @Field(value = "district_unit")
   private String districtUnit;
   /** 报警类别
    * 
    * @pdOid 4f96c3b9-18c7-4b9f-87cb-4647a4237f48 */
   private String category;
   /** 报警类型
    * 
    * @pdOid f6cbe0fa-25af-4149-be4b-aedb67268e46 */
   private String type;
   /** 报警细类
    * 
    * @pdOid dbfe557b-bc6e-48ca-a624-419d9f950d16 */
   @Field(value = "fine_class")
   private String fineClass;
   /** 警情级别
    * 
    * @pdOid 70e58522-3189-4143-a82d-9f5e90cf1110 */
   private String level;
   /** 报警内容
    * 
    * @pdOid a74ad3e1-d09a-4220-9a06-1ad3941da3cb */
   private String content;
   /** 处警意见
    * 
    * @pdOid 5c6750ac-9e32-489b-9dfb-7998f0f24e85 */
   @Field(value = "police_opinion")
   private String policeOpinion;
   /** 反馈情况
    * 
    * @pdOid a3fe3daa-2134-40de-94db-fd62bffe9dee */
   private String feedback;

}