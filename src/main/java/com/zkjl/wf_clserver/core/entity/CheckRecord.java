package com.zkjl.wf_clserver.core.entity; 
/***********************************************************************
 * Module:  check_record.java
 * Author:  Administrator
 * Purpose: Defines the Class check_record
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 核查核录记录
 * 
 * @pdOid 638c7048-45f8-4e00-94c9-8d3a20b87b21 */
@Document(collection = "check_record")
@Data
public class CheckRecord {
   /** 核查核录记录编号
    * 
    * @pdOid 9751166d-dab3-41cd-8297-6e675a5f5839 */
   @Id
   private String id;
   /** 被采集人姓名
    * 
    * @pdOid 9cba4274-954e-452f-aa2b-1f74c0b2e9f4 */
   @Field(value = "full_name")
   private String fullName;
   /** 被采集人证件号码
    * 
    * @pdOid 0c43d3e1-ccf4-4c5e-87bf-3006d1f815eb */
   @Field(value = "id_card")
   private String idCard;
   /** 民族
    * 
    * @pdOid 840a417d-2eca-4a97-8d6e-286cb96baa6a */
   private String nation;
   /** 国籍(境外人员)
    * 
    * @pdOid 5eaa7885-d81c-41d4-8d1d-073acbc7219e */
   private String nationality;
   /** 核录批次标识，关联人+车
    * 
    * @pdOid 5a3fb669-b6e0-41a7-a66b-c75808f50158 */
   @Field(value = "batch_id")
   private String batchId;
   /** 核录时间
    * 
    * @pdOid b3e08801-0049-4f28-a736-63895c7661f1 */
   @Field(value = "record_time")
   private Date recordTime;
   /** 核录人身份证号
    * 
    * @pdOid 30a8811a-da3f-4076-bf03-c00ec7a33551 */
   @Field(value = "recorder_card")
   private String recorderCard;
   /** 核录人部门
    * 
    * @pdOid 12e4d01a-de8f-4e9e-aa94-33a76f00f067 */
   private String department;
   /** 被采集人联系方式
    * 
    * @pdOid 08909a7e-3d5c-44df-ad19-050a52175761 */
   private String contact;
   /** 采集地点
    * 
    * @pdOid b89ee27c-43a2-473c-a814-589a2e30fc83 */
   private String site;
   /** 采集地点X坐标
    * 
    * @pdOid 9a1a43c0-0e6d-4b36-86d9-98bf085e4b1a */
   @Field(value = "x_axis")
   private double xAxis;
   /** 采集地点Y坐标
    * 
    * @pdOid daa4fa46-8aac-4cc4-8986-49669328e2de */
   @Field(value = "y_axis")
   private double yAxis;
   /** 备注信息
    * 
    * @pdOid a6241315-e0f6-44b1-af7a-8fa87c3c67da */
   private String remark;
   /** 核录位置-地市
    * 
    * @pdOid 18964bb8-48db-4f8e-b577-4d4b976a492c */
   private String city;
   /** 核录位置-区县
    * 
    * @pdOid 49896b16-6e86-4b19-895a-1208b7c711e3 */
   private String district;
   /** 被采集人证件类型
    * 
    * @pdOid f579a2db-4b3f-45c8-a0c3-35f32b1f20d8 */
   @Field(value = "id_type")
   private String idType;
   /** 核录位置-详细地址
    * 
    * @pdOid 214b37cd-217f-4d2c-8035-61d504b37d90 */
   @Field(value = "detail_address")
   private String detailAddress;
   /** 使用场景
    * 
    * @pdOid 9a775499-571c-480b-989a-e362dce76b83 */
   @Field(value = "use_case")
   private String useCase;
   /** 处置要求
    * 
    * @pdOid 8786a145-c7b6-4d81-a813-c61c4a1253c7 */
   @Field(value = "handle_ask")
   private String handleAsk;
   /** 处置措施
    * 
    * @pdOid 25cf03c0-b943-4cce-ab04-26f7912c681f */
   @Field(value = "handle_step")
   private String handleStep;
   /** 户籍地区划分
    * 
    * @pdOid 6121a812-8bd0-425b-a7da-f00c7dafbe36 */
   private String divide;
   /** 人员大类（关联人员表人员大类）
    * 
    * @pdOid fdc04795-d334-4a10-8270-a7473ddcdaa8 */
   @Field(value = "personnel_class")
   private String personnelClass;
   /** 人员细类（关联人员表人员细类）
    * 
    * @pdOid 9d2caaae-6a98-4e38-b953-7c63646e3317 */
   @Field(value = "personnel_fine_class")
   private String personnelFineClass;
   /** 设备归属部门
    * 
    * @pdOid 93385778-36de-41f9-a00f-10e35904c702 */
   @Field(value = "device_department")
   private String deviceDepartment;
   /** 联络人姓名
    * 
    * @pdOid 1b1b9500-3708-4d5c-a6ce-470a12ac2860 */
   @Field(value = "liaison_name")
   private String liaisonName;
   /** 联络人联系方式
    * 
    * @pdOid c0d49a4d-971e-408f-8494-ccf8e00e3a03 */
   @Field(value = "liaison_contact_mode")
   private String liaisonContactMode;

}