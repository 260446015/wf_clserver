package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** 违法犯罪人员信息表
 * 
 * */
@Document(collection = "crime_infor")
@Data
public class CrimeInfor {
   /** 违法犯罪人员id
    * 
    * */
   @Id
   private String id;
   /** 姓名
    * 
    * */
   private String name;
   /** 头像
    * 
    * */
   private String image;
   /** 性別
    * 
    * */
   private String sex;
   /** 別名
    * 
    * */
   private String nickname;
   /** 民族
    * 
    * */
   private String race;
   /** 出生日期
    * 
    * */
   private java.util.Date birth;
   /** 身份证号
    * 
    * */
   @Field(value = "id_card")
   private String idCard;
   /** 身高
    * 
    * */
   private int height;
   /** 足长
    * 
    * */
   @Field(value = "foot_length")
   private int footLength;
   /** 专长
    * 
    * */
   private String expertise;
   /** 体表标记
    * 
    * */
   @Field(value = "body_marker")
   private String bodyMarker;
   /** 人员编号
    * 
    * */
   @Field(value = "personnel_numb")
   private String personnelNumb;
   /** 教育程度
    * 
    * */
   private String edu;
   /** 身份
    * 
    * */
   private String identity;
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
   /** 入所日期
    * 
    * */
   @Field(value = "entry_date")
   private java.util.Date entryDate;
   /** 案件类别
    * 
    * */
   @Field(value = "case_category")
   private String caseCategory;
   /** 入所原因
    * 
    * */
   @Field(value = "entry_cause")
   private String entryCause;
   /** 办案单位
    * 
    * */
   @Field(value = "case_handling_unit")
   private String caseHandlingUnit;
   /** 刑期
    * 
    * */
   @Field(value = "prison_term")
   private String prisonTerm;
   /** 司法处理结果
    * 
    * */
   @Field(value = "handle_result")
   private String handleResult;
   /** 法律文书号
    * 
    * */
   @Field(value = "legal_number")
   private String legalNumber;
   /** 出所原因
    * 
    * */
   @Field(value = "out_place_cause")
   private String outPlaceCause;
   /** 出所日期
    * 
    * */
   @Field(value = "out_place_date")
   private java.util.Date outPlaceDate;
   /** 出所去向
    * 
    * */
   @Field(value = "out_place_where")
   private String outPlaceWhere;
   /** 简要案情
    * 
    * */
   @Field(value = "brief_case")
   private String briefCase;

}