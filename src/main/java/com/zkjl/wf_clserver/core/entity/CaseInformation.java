package com.zkjl.wf_clserver.core.entity; 
/***********************************************************************
 * Module:  case_information.java
 * Author:  Administrator
 * Purpose: Defines the Class case_information
 ***********************************************************************/


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 案件信息
 * 
 * @pdOid 945130f4-4617-48d8-a010-e4a66620d06c */
@Document(collection = "case_information")
@Data
public class CaseInformation {
   /** 案件信息id
    * 
    * @pdOid 841a2702-fce6-4836-89d1-bcf04b5dcbee */
   @Id
   private String id;
   /** 涉案人员证件号
    * 
    * @pdOid 1c6572d6-5277-4ad4-8d06-42b7f6338173 */
   @Field(value = "id_card")
   private String idCard;
   /** 案件编号
    * 
    * @pdOid a9df2d65-846d-4efb-97f3-f078e3e370ea */
   private String number;
   /** 警情编号
    * 
    * @pdOid b5c01706-8914-43ba-890f-5ffd954c1114 */
   @Field(value = "alarm_number")
   private String alarmNumber;
   /** 案件来源
    * 
    * @pdOid 828c8fb5-93bb-4059-aaea-883ec68d45d0 */
   private String source;
   /** 案件名称
    * 
    * @pdOid 2da85a4b-af74-4b89-9f58-949b1528ec53 */
   @Field(value = "case_name")
   private String caseName;
   /** 案件类型
    * 
    * @pdOid f1f8e9e4-c021-43ac-bec0-2132892e918c */
   @Field(value = "case_type")
   private String caseType;
   /** 案件状态
    * 
    * @pdOid b52b250f-b8fc-408d-aeeb-9a968da0ec91 */
   @Field(value = "case_status")
   private String case_status;
   /** 案由
    * 
    * @pdOid cbe15c87-9b8f-4a0e-897e-7da7706d3dee */
   @Field(value = "case")
   private String sCase;
   /** 警种类别
    * 
    * @pdOid 307754d1-f025-46a4-b772-bb81a74ee935 */
   @Field(value = "police_category")
   private String policeCategory;
   /** 发案地点
    * 
    * @pdOid c52ebb1a-ac72-4e57-bd4a-8a47cc9ade82 */
   @Field(value = "case_location")
   private String caseLocation;
   /** 地理坐标
    * 
    * @pdOid 58c537c9-b7da-4905-a605-9bd289024ead */
   private String coordinate;
   /** 是否公开
    * 
    * @pdOid b23ff57b-9f8e-4737-8092-ac0609a7330f */
   @Field(value = "if_open")
   private String ifOpen;
   /** 风险等级
    * 
    * @pdOid 867f9e71-b3e6-4e12-ae4c-4a594998eb1d */
   @Field(value = "risk_grade")
   private String riskGrade;
   /** 发案时间
    * 
    * @pdOid b8b8b849-3ec0-4b39-932a-1e0834079819 */
   @Field(value = "case_time")
   private Date caseTime;
   /** 受案时间
    * 
    * @pdOid c0ae0392-e05c-4d8f-bd26-fa73f45e842d */
   @Field(value = "subject_case_time")
   private Date subjectCaseTime;
   /** 受案单位
    * 
    * @pdOid c58382ee-bd74-4d71-b910-d9426b85076e */
   @Field(value = "receiving_unit")
   private String receivingUnit;
   /** 调解时间
    * 
    * @pdOid cbea1502-6c06-47a3-9441-f79feaad034b */
   @Field(value = "mediation_time")
   private Date mediationTime;
   /** 处罚时间
    * 
    * @pdOid c9735146-0fc5-4254-a66f-3cc639e23abe */
   @Field(value = "penalty_time")
   private Date penaltyTime;
   /** 结案时间
    * 
    * @pdOid 897a6ea0-a6a4-41b9-bf71-946587c5a3c5 */
   @Field(value = "closing_time")
   private Date closingTime;
   /** 简要案情
    * 
    * @pdOid da7d16af-5156-40fc-92af-5b814ea034a9 */
   @Field(value = "brief_case")
   private String briefCase;
   /** 主办单位
    * 
    * @pdOid d84b4195-a53e-4d12-b09e-a2e445968f9b */
   @Field(value = "host_unit")
   private String hostUnit;
   /** 协办单位
    * 
    * @pdOid 9bc9c5a6-9bd9-47de-b88a-d6296b199126 */
   @Field(value = "co_organizer")
   private String co_organizer;
   /** 主办人
    * 
    * @pdOid 06c5a420-ec96-49eb-b524-1824d941870d */
   private String sponsor;
   /** 协办人
    * 
    * @pdOid 61faf612-1c56-4aff-9a6c-9a10c4b56c33 */
   private String coordinator;
   /** 拆分情况
    * 
    * @pdOid 5b84d26c-ec8c-4c98-95f4-cb687aa77f4c */
   private String resolution;

}