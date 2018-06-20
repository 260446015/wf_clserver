package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 查获登记
 * 
 * */
@Document(collection = "check_register")
@Data
public class CheckRegister {
   /** 查获登记信息id
    * 
    * */
   @Id
   private String id;
   /** 证件号码
    * 
    * */
   @Field(value = "id_card")
   private String idCard;
   /** 列管状态
    * 
    * */
   @Field(value = "tube_status")
   private String tubeStatus;
   /** 开始日期
    * 
    * */
   @Field(value = "begin_date")
   private Date beginDate;
   /** 更新时间
    * 
    * */
   @Field(value = "update_date")
   private Date updateDate;
   /** 后续管控环节
    * 
    * */
   @Field(value = "follow_up_link")
   private String followUpLink;
   /** 后续接管单位
    * 
    * */
   @Field(value = "follow_up_unit")
   private String followUpUnit;
   /** 查获日期
    * 
    * */
   @Field(value = "seizure_date")
   private Date seizureDate;
   /** 查获地区
    * 
    * */
   @Field(value = "seizure_area")
   private String seizureArea;
   /** 查获单位
    * 
    * */
   @Field(value = "seizure_work")
   private String seizureWork;
   /** 查获地点
    * 
    * */
   @Field(value = "seizure_place")
   private String seizurePlace;
   /** 查获来源
    * 
    * */
   @Field(value = "seizure_source")
   private String seizureSource;
   /** 吸毒场所
    * 
    * */
   @Field(value = "drug_addicts")
   private String drugAddicts;
   /** 毒品来源
    * 
    * */
   @Field(value = "drug_source")
   private String drugSource;
   /** 查获原因
    * 
    * */
   @Field(value = "seizure_reason")
   private String seizureReason;
   /** 滥用毒品种类
    * 
    * */
   @Field(value = "drug_abuse")
   private String drugAbuse;
   /** 违法事实
    * 
    * */
   @Field(value = "Illegal_facts")
   private String illegalFacts;
   /** 尿检结果
    * 
    * */
   @Field(value = "urine_analysis")
   private String urineAnalysis;
   /** 填表单位
    * 
    * */
   @Field(value = "filling_unit")
   private String fillingUnit;
   /** 填表人
    * 
    * */
   private String filler;
   /** 填表人联系电话
    * 
    * */
   @Field(value = "filler_contact")
   private String fillerContact;
   /** 填表审核人
    * 
    * */
   private String reviewer;
   /** 备注
    * 
    * */
   private String remarks;
   /** 录入单位
    * 
    * */
   @Field(value = "entry_unit")
   private String entryUnit;
   /** 录入人
    * 
    * */
   @Field(value = "input_person")
   private String inputPerson;
   /** 录入日期
    * 
    * */
   @Field(value = "input_date")
   private Date inputDate;

}