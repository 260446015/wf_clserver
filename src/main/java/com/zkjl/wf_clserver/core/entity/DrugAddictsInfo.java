package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** 吸毒人员信息表
 * 
 * */
@Document(collection = "drug_addicts_info")
@Data
public class DrugAddictsInfo {
   /** 吸毒人员信息id
    * 
    * */
   @Id
   private String id;
   /** 姓名
    * 
    * */
   @Field(value = "full_name")
   private String fullName;
   /** 证件号码
    * 
    * */
   @Field(value = "id_card")
   private String idCard;
   /** 头像
    * 
    * */
   @Field(value = "avatar")
   private String avatar;
   /** 证件种类
    * 
    * */
   @Field(value = "id_type")
   private String idType;
   /** 绰号/别名
    * 
    * */
   private String alias;
   /** 性别
    * 
    * */
   private String sex;
   /** 民族
    * 
    * */
   private String nation;
   /** 出生日期
    * 
    * */
   @Field(value = "birth_date")
   private java.util.Date birthDate;
   /** 身高(cm)
    * 
    * */
   private int height;
   /** 国籍
    * 
    * */
   private String nationality;
   /** 婚姻状况
    * 
    * */
   @Field(value = "marital_status")
   private String maritalStatus;
   /** 文化程度
    * 
    * */
   private String education;
   /** 从业状况
    * 
    * */
   @Field(value = "job_status")
   private String jobStatus;
   /** 指纹编号
    * 
    * */
   @Field(value = "fingerprint_number")
   private String fingerprintNumber;
   /** DNA编号
    * 
    * */
   @Field(value = "dna_number")
   private String dnaNumber;
   /** 户籍地
    * 
    * */
   @Field(value = "domicile_place")
   private String domicilePlace;
   /** 户籍地详址
    * 
    * */
   @Field(value = "domicile_address")
   private String domicileAddress;
   /** 户籍地派出所
    * 
    * */
   @Field(value = "domicile_police")
   private String domicilePolice;
   /** 居住地
    * 
    * */
   @Field(value = "live_place")
   private String livePlace;
   /** 居住地详址
    * 
    * */
   @Field(value = "live_address")
   private String liveAddress;
   /** 居住地派出所
    * 
    * */
   @Field(value = "live_police")
   private String livePolice;
   /** 工作单位
    * 
    * */
   @Field(value = "work_unit")
   private String workUnit;
   /** 吸毒人员来源
    * 
    * */
   private String source;
   /** 初次发现单位
    * 
    * */
   @Field(value = "find_unit")
   private String findUnit;
   /** 初次发现日期
    * 
    * */
   @Field(value = "find_date")
   private java.util.Date findDate;
   /** 初次录入单位
    * 
    * */
   @Field(value = "entry_unit")
   private String entryUnit;
   /** 初次录入日期
    * 
    * */
   @Field(value = "record_date")
   private java.util.Date recordDate;
   /** 脱失次数
    * 
    * */
   @Field(value = "deletion_count")
   private int deletionCount;
   /** 滥用毒品优先级
    * 
    * */
   @Field(value = "drug_abuse_priority")
   private String drugAbusePriority;
   /** 滥用毒品种类
    * 
    * */
   @Field(value = "drug_abuse_class")
   private String drugAbuseClass;
   /** 当前管控现状
    * 
    * */
   @Field(value = "charge_status")
   private String chargeStatus;
   /** 当前管控记录
    * 
    * */
   @Field(value = "charge_record")
   private String chargeRecord;
   /** 当前管控地区
    * 
    * */
   @Field(value = "charge_area")
   private String chargeArea;
   /** 当前管控填表单位
    * 
    * */
   @Field(value = "charge_filling_unit")
   private String chargeFillingUnit;
   /** 安置状态
    * 
    * */
   @Field(value = "resettlement_state")
   private String resettlementState;
   /** 是否纳入低保
    * 
    * */
   @Field(value = "if_low_insurance")
   private String ifLowInsurance;
}