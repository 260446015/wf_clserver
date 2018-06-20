package com.zkjl.wf_clserver.core.entity; 

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 案件信息
 * 
 * */
@Document(collection = "case_information")
@Data
public class CaseInformation {
   /** 案件信息id
    * 
    * */
   @Id
   private String id;
   /** 涉案人员证件号
    * 
    * */
   @Field(value = "id_card")
   private String idCard;
   /** 案件编号
    * 
    * */
   private String number;
   /** 警情编号
    * 
    * */
   @Field(value = "alarm_number")
   private String alarmNumber;
   /** 案件来源
    * 
    * */
   private String source;
   /** 案件名称
    * 
    * */
   @Field(value = "case_name")
   private String caseName;
   /** 案件类型
    * 
    * */
   @Field(value = "case_type")
   private String caseType;
   /** 案件状态
    * 
    * */
   @Field(value = "case_status")
   private String caseStatus;
   /** 案由
    * 
    * */
   @Field(value = "case")
   private String sCase;
   /** 警种类别
    * 
    * */
   @Field(value = "police_category")
   private String policeCategory;
   /** 发案地点
    * 
    * */
   @Field(value = "case_location")
   private String caseLocation;
   /** 地理坐标
    * 
    * */
   private String coordinate;
   /** 是否公开
    * 
    * */
   @Field(value = "if_open")
   private String ifOpen;
   /** 风险等级
    * 
    * */
   @Field(value = "risk_grade")
   private String riskGrade;
   /** 发案时间
    * 
    * */
   @Field(value = "case_time")
   private Date caseTime;
   /** 受案时间
    * 
    * */
   @Field(value = "subject_case_time")
   private Date subjectCaseTime;
   /** 受案单位
    * 
    * */
   @Field(value = "receiving_unit")
   private String receivingUnit;
   /** 调解时间
    * 
    * */
   @Field(value = "mediation_time")
   private Date mediationTime;
   /** 处罚时间
    * 
    * */
   @Field(value = "penalty_time")
   private Date penaltyTime;
   /** 结案时间
    * 
    * */
   @Field(value = "closing_time")
   private Date closingTime;
   /** 简要案情
    * 
    * */
   @Field(value = "brief_case")
   private String briefCase;
   /** 主办单位
    * 
    * */
   @Field(value = "host_unit")
   private String hostUnit;
   /** 协办单位
    * 
    * */
   @Field(value = "co_organizer")
   private String coOrganizer;
   /** 主办人
    * 
    * */
   private String sponsor;
   /** 协办人
    * 
    * */
   private String coordinator;
   /** 拆分情况
    * 
    * */
   private String resolution;

}