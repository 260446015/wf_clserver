package com.zkjl.wf_clserver.core.entity; 

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 拘留人员信息表
 * 
 * */
@Document(collection = "detainees_infor")
@Data
public class DetaineesInfor {
   /** 拘留人员信息id
    * 
    * */
   @Id
   private String id;
   /** 证件号
    * 
    * */
   @Field(value = "id_card")
   private String idCard;
   /** 姓名
    * 
    * */
   private String name;
   /** 人员编号
    * 
    * */
   @Field(value = "personnel_number")
   private String personnelNumber;
   /** 別名
    * 
    * */
   private String nickname;
   /** 性別
    * 
    * */
   private String sex;
   /** 出生日期
    * 
    * */
   private Date birth;
   /** 民族
    * 
    * */
   private String nation;
   /** 婚姻状况
    * 
    * */
   @Field(value = "marital_status")
   private String maritalStatus;
   /** 籍贯
    * 
    * */
   @Field(value = "native_place")
   private String nativePlace;
   /** 户籍地
    * 
    * */
   @Field(value = "domicile_place")
   private String domicilePlace;
   /** 户籍地详址
    * 
    * */
   @Field(value = "domicile_place_address")
   private String domicilePlaceAddress;
   /** 现居地
    * 
    * */
   @Field(value = "living_place")
   private String livingPlace;
   /** 现居地详址
    * 
    * */
   @Field(value = "living_place_address")
   private String livingPlaceAddress;
   /** 国籍
    * 
    * */
   private String nationality;
   /** 文化程度
    * 
    * */
   private String edu;
   /** 专长
    * 
    * */
   private String specialty;
   /** 政治面貌
    * 
    * */
   @Field(value = "political_outlook")
   private String politicalOutlook;
   /** 身份
    * 
    * */
   private String identity;
   /** 特护身份
    * 
    * */
   @Field(value = "special_protection")
   private String specialProtection;
   /** 职业
    * 
    * */
   private String job;
   /** 工作单位
    * 
    * */
   private String workplace;
   /** 拘室号
    * 
    * */
   @Field(value = "room_number")
   private String roomNumber;
   /** 收据凭证
    * 
    * */
   private String receipt;
   /** 入所文书号
    * 
    * */
   @Field(value = "text_number")
   private String textNumber;
   /** 入所原因
    * 
    * */
   @Field(value = "entry_reason")
   private String entryReason;
   /** 主要案由
    * 
    * */
   @Field(value = "main_cause")
   private String mainCause;
   /** 成员类型
    * 
    * */
   @Field(value = "member_type")
   private String memberType;
   /** 从案案由
    * 
    * */
   @Field(value = "case")
   private String sCase;
   /** 拘留决定机关
    * 
    * */
   @Field(value = "decision_office")
   private String decisionOffice;
   /** 入所日期
    * 
    * */
   @Field(value = "entry_date")
   private Date entryDate;
   /** 拘押日期
    * 
    * */
   @Field(value = "detain_date")
   private Date detainDate;
   /** 拘留天数
    * 
    * */
   @Field(value = "detain_days")
   private int detainDays;
   /** 办案单位
    * 
    * */
   @Field(value = "handle_unit")
   private String handleUnit;
   /** 办案单位类型
    * 
    * */
   @Field(value = "handle_unit_type")
   private String handleUnitType;
   /** 办案人
    * 
    * */
   private String operator;
   /** 办案人电话
    * 
    * */
   @Field(value = "operator_tel")
   private String operatorTel;
   /** 裁决书号
    * 
    * */
   @Field(value = "rule_book_number")
   private String ruleBookNumber;
   /** 口音特点
    * 
    * */
   @Field(value = "accent_trait")
   private String accentTrait;
   /** 危险等级
    * 
    * */
   @Field(value = "danger_grade")
   private String dangerGrade;
   /** 健康状况
    * 
    * */
   private String health;
   /** 犯罪经历
    * 
    * */
   @Field(value = "criminal_live")
   private String criminalLive;
   /** 情况描述
    * 
    * */
   @Field(value = "situation_describe")
   private String situationDescribe;
   /** 出所日期
    * 
    * */
   @Field(value = "out_place_date")
   private Date outPlaceDate;
   /** 出所原因
    * 
    * */
   @Field(value = "out_place_cause")
   private String outPlaceCause;
   /** 出所去向
    * 
    * */
   @Field(value = "out_place_where")
   private String outPlaceWhere;
   /** 备注
    * 
    * */
   private String remarks;

}