package com.zkjl.wf_clserver.core.entity;
/***********************************************************************
 * Module:  check_register.java
 * Author:  Administrator
 * Purpose: Defines the Class check_register
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 查获登记
 * 
 * @pdOid 26025f4e-9516-437e-8fdf-1e1a93718c7f */
@Document(collection = "check_register")
@Data
public class CheckRegister {
   /** 查获登记信息id
    * 
    * @pdOid 812a4ac7-c57d-4a43-bf92-fdf439dac993 */
   @Id
   private String id;
   /** 证件号码
    * 
    * @pdOid 325121d0-f0cd-44e7-8e74-ac4d48470de5 */
   @Field(value = "id_card")
   private String idCard;
   /** 列管状态
    * 
    * @pdOid 5ba216aa-21af-40ef-8c19-891c7b4d34de */
   @Field(value = "tube_status")
   private String tubeStatus;
   /** 开始日期
    * 
    * @pdOid 8310db23-da00-4fda-a7f0-1cdd1a04f68f */
   @Field(value = "begin_date")
   private Date beginDate;
   /** 更新时间
    * 
    * @pdOid 9e942fc3-9cca-4e29-9e65-d78df597bf18 */
   @Field(value = "update_date")
   private Date updateDate;
   /** 后续管控环节
    * 
    * @pdOid 7b0642fc-c35d-466a-b020-7efd5512557a */
   @Field(value = "follow_up_link")
   private String followUpLink;
   /** 后续接管单位
    * 
    * @pdOid a6e18e89-7e11-4ac9-a81e-2f18983f3983 */
   @Field(value = "follow_up_unit")
   private String followUpUnit;
   /** 查获日期
    * 
    * @pdOid 4fddd44b-a095-48b0-a672-b4ee6ce44fac */
   @Field(value = "seizure_date")
   private Date seizureDate;
   /** 查获地区
    * 
    * @pdOid 639f11e3-fbe7-4911-9d80-4b6c87395dee */
   @Field(value = "seizure_area")
   private String seizureArea;
   /** 查获单位
    * 
    * @pdOid 94674f80-e9d0-41e4-ba57-8bc4412fc1a4 */
   @Field(value = "seizure_work")
   private String seizureWork;
   /** 查获地点
    * 
    * @pdOid 14679e26-81f7-4a3b-8316-9ffa6e96749f */
   @Field(value = "seizure_place")
   private String seizurePlace;
   /** 查获来源
    * 
    * @pdOid 406ff020-4ff7-41a1-a852-ea4046434062 */
   @Field(value = "seizure_source")
   private String seizureSource;
   /** 吸毒场所
    * 
    * @pdOid b78be062-5acf-4770-8fec-30e1816ab640 */
   @Field(value = "drug_addicts")
   private String drugAddicts;
   /** 毒品来源
    * 
    * @pdOid e7874443-4733-44c1-a51d-127598ed5822 */
   @Field(value = "drug_source")
   private String drugSource;
   /** 查获原因
    * 
    * @pdOid 25af9fa4-f1d4-4576-ae45-2b3681f72628 */
   @Field(value = "seizure_reason")
   private String seizureReason;
   /** 滥用毒品种类
    * 
    * @pdOid d7e99c8e-45b0-4916-af38-b33102214af4 */
   @Field(value = "drug_abuse")
   private String drugAbuse;
   /** 违法事实
    * 
    * @pdOid 775f5089-f3e8-48a8-ac0a-d1a23399fa15 */
   @Field(value = "Illegal_facts")
   private String illegalFacts;
   /** 尿检结果
    * 
    * @pdOid 3a3f1a5c-6925-476e-8836-07585321da2e */
   @Field(value = "urine_analysis")
   private String urineAnalysis;
   /** 填表单位
    * 
    * @pdOid 9ac0f85a-b111-4697-b8ea-53efe5da1d82 */
   @Field(value = "filling_unit")
   private String fillingUnit;
   /** 填表人
    * 
    * @pdOid 3b9864f7-4c10-4c80-ba7b-b2c9d4521e6e */
   private String filler;
   /** 填表人联系电话
    * 
    * @pdOid 7485fb15-6d54-42d5-a5ff-75ca808db069 */
   @Field(value = "filler_contact")
   private String fillerContact;
   /** 填表审核人
    * 
    * @pdOid 21283fb8-c899-4222-a00f-08387dbc5a81 */
   private String reviewer;
   /** 备注
    * 
    * @pdOid 0b330af9-a3d0-4db0-b572-a3a1dc8bf71b */
   private String remarks;
   /** 录入单位
    * 
    * @pdOid d0b607d6-3210-4fd9-8554-1281c03e842b */
   @Field(value = "entry_unit")
   private String entryUnit;
   /** 录入人
    * 
    * @pdOid a7948409-cc12-4461-96d1-4fc586f03dfd */
   @Field(value = "input_person")
   private String inputPerson;
   /** 录入日期
    * 
    * @pdOid 6c339f8c-251f-4d44-8278-972b2989cc79 */
   @Field(value = "input_date")
   private Date inputDate;

}