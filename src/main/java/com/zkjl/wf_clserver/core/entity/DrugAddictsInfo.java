package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  drug_addicts_info.java
 * Author:  Administrator
 * Purpose: Defines the Class drug_addicts_info
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

/** 吸毒人员信息表
 * 
 * @pdOid 57504b4f-75ee-4fc5-8535-c36be9f09dce */
@Document(collection = "drug_addicts_info")
@Data
public class DrugAddictsInfo {
   /** 吸毒人员信息id
    * 
    * @pdOid 2cb2ff07-20c1-47fa-a86b-73dca68ba7c2 */
   @Id
   private String id;
   /** 姓名
    * 
    * @pdOid 89b0d682-bc48-4688-bb5d-930714d4ca3e */
   @Field(value = "full_name")
   private String full_name;
   /** 证件号码
    * 
    * @pdOid e79b86a2-90de-4dbb-bd56-8581b7434ccd */
   @Field(value = "id_card")
   private String idCard;
   /** 头像
    * 
    * @pdOid 11907b99-a475-4a57-9cd7-63182bdc5bde */
   @Field(value = "avatar")
   private String avatar;
   /** 证件种类
    * 
    * @pdOid 37c9f214-d228-49fe-b651-ec5e28c1eb77 */
   @Field(value = "id_type")
   private String idType;
   /** 绰号/别名
    * 
    * @pdOid 841c21f5-7f95-4151-b9b2-e214f86c9d7e */
   private String alias;
   /** 性别
    * 
    * @pdOid 3fa023b6-df1a-4230-8a61-b0a70b2e8d94 */
   private String sex;
   /** 民族
    * 
    * @pdOid 5673d10c-0656-48a4-84b9-36b78aeef675 */
   private String nation;
   /** 出生日期
    * 
    * @pdOid 538d7348-ae18-4406-bffb-3d62789beeb2 */
   @Field(value = "birth_date")
   private java.util.Date birthDate;
   /** 身高(cm)
    * 
    * @pdOid c8edd403-ccee-4e50-a34b-dd7670b7040f */
   private int height;
   /** 国籍
    * 
    * @pdOid d8679c42-eef7-46e3-bfc5-ec9c06e47735 */
   private String nationality;
   /** 婚姻状况
    * 
    * @pdOid be27572c-e811-48ad-a5b0-119447ee2b69 */
   @Field(value = "marital_status")
   private String maritalStatus;
   /** 文化程度
    * 
    * @pdOid fb166f1c-235c-4b28-8282-145fe50f8a60 */
   private String education;
   /** 从业状况
    * 
    * @pdOid ddbf2f85-5dd9-4f02-bac0-f38d43faeeb6 */
   @Field(value = "job_status")
   private String jobStatus;
   /** 指纹编号
    * 
    * @pdOid 4e6b3df1-0f68-4508-b0be-42b373ecb7d5 */
   @Field(value = "fingerprint_number")
   private String fingerprintNumber;
   /** DNA编号
    * 
    * @pdOid 6b11bae9-047f-43e8-8dac-827eb8c2598f */
   @Field(value = "dna_number")
   private String dnaNumber;
   /** 户籍地
    * 
    * @pdOid dccba1de-b1fd-48d4-9c91-c31bc9a7bb17 */
   @Field(value = "domicile_place")
   private String domicilePlace;
   /** 户籍地详址
    * 
    * @pdOid b2f0b9f1-ffd8-4282-9b48-ff43a6df9ebd */
   @Field(value = "domicile_address")
   private String domicileAddress;
   /** 户籍地派出所
    * 
    * @pdOid 48ff8ad4-7afd-471d-8de2-bce9839a85b3 */
   @Field(value = "domicile_police")
   private String domicilePolice;
   /** 居住地
    * 
    * @pdOid fb5024ec-3a38-4e9d-a65c-011c6aeab6a5 */
   @Field(value = "live_place")
   private String livePlace;
   /** 居住地详址
    * 
    * @pdOid 471a6ef8-50eb-4fff-9ea2-a04b4fd939ea */
   @Field(value = "live_address")
   private String liveAddress;
   /** 居住地派出所
    * 
    * @pdOid 58cefb0f-2424-4ce6-97b0-09043180da84 */
   @Field(value = "live_police")
   private String livePolice;
   /** 工作单位
    * 
    * @pdOid b3e8996c-ce46-4f7f-aa01-2ed76bbb0b11 */
   @Field(value = "work_unit")
   private String workUnit;
   /** 吸毒人员来源
    * 
    * @pdOid 45902606-3da8-4984-b5f5-76cf930a1415 */
   private String source;
   /** 初次发现单位
    * 
    * @pdOid ef2c39fd-487f-445a-990f-1d9597c67727 */
   @Field(value = "find_unit")
   private String findUnit;
   /** 初次发现日期
    * 
    * @pdOid 67136dc6-8c7a-4c4a-9645-13602f8af7bb */
   @Field(value = "find_date")
   private java.util.Date findDate;
   /** 初次录入单位
    * 
    * @pdOid e0fde7d7-641f-4265-8b11-6720e8d5ee5b */
   @Field(value = "entry_unit")
   private String entryUnit;
   /** 初次录入日期
    * 
    * @pdOid 71e167aa-f6e5-4e71-af31-e59c27e2ada3 */
   @Field(value = "record_date")
   private java.util.Date recordDate;
   /** 脱失次数
    * 
    * @pdOid 9330cf70-2cab-4fc1-81d1-e79e27dc338e */
   @Field(value = "deletion_count")
   private int deletionCount;
   /** 滥用毒品优先级
    * 
    * @pdOid ee0424f7-1448-4765-b8b0-fb636ef46dbb */
   @Field(value = "drug_abuse_priority")
   private String drugAbusePriority;
   /** 滥用毒品种类
    * 
    * @pdOid 1a48e8be-6b36-4de7-a80b-49a88b3cac92 */
   @Field(value = "drug_abuse_class")
   private String drugAbuseClass;
   /** 当前管控现状
    * 
    * @pdOid f7d2c06f-2a2e-4dde-accd-8cd7a57da82e */
   @Field(value = "charge_status")
   private String chargeStatus;
   /** 当前管控记录
    * 
    * @pdOid df0555ed-8311-4b65-9795-97275ee4b5ed */
   @Field(value = "charge_record")
   private String chargeRecord;
   /** 当前管控地区
    * 
    * @pdOid 44f8f551-abe8-445f-9a24-8dba44ca7e58 */
   @Field(value = "charge_area")
   private String chargeArea;
   /** 当前管控填表单位
    * 
    * @pdOid fe333bd0-f168-4ee0-b120-d358e9d5785d */
   @Field(value = "charge_filling_unit")
   private String chargeFillingUnit;
   /** 安置状态
    * 
    * @pdOid dc3a69f2-8b14-4932-a7d7-f73196d0aecd */
   @Field(value = "resettlement_state")
   private String resettlementState;
   /** 是否纳入低保
    * 
    * @pdOid 57477cd5-0eef-43cf-8d4e-f68445055854 */
   @Field(value = "if_low_insurance")
   private String if_low_insurance;

}