package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  detainees_infor.java
 * Author:  Administrator
 * Purpose: Defines the Class detainees_infor
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

/** 拘留人员信息表
 * 
 * @pdOid ca53e3be-dc49-4ea3-922a-90af217c0f3d */
@Document(collection = "detainees_infor")
@Data
public class DetaineesInfor {
   /** 拘留人员信息id
    * 
    * @pdOid cb7c9235-08b3-4faa-abbc-36b7a2fb3852 */
   @Id
   private String id;
   /** 证件号
    * 
    * @pdOid 96f59ce2-1190-4c4b-892c-929c3770f717 */
   @Field(value = "id_card")
   private String idCard;
   /** 姓名
    * 
    * @pdOid e72789c0-79d5-440d-8a51-c0c843ca6268 */
   private String name;
   /** 人员编号
    * 
    * @pdOid 48609e33-d4e2-4e12-bc88-72b1998b674d */
   @Field(value = "personnel_number")
   private String personnelNumber;
   /** 別名
    * 
    * @pdOid a986cd0f-ad4a-4d70-b544-6d8210e7ac90 */
   private String nickname;
   /** 性別
    * 
    * @pdOid bba9c90e-c670-472c-993d-8a8076f7e876 */
   private String sex;
   /** 出生日期
    * 
    * @pdOid fed5e9ca-c9ed-425f-84cd-a95098a211b9 */
   private java.util.Date birth;
   /** 民族
    * 
    * @pdOid bc6cb60e-0004-45cf-8971-e59c203c12ed */
   private String nation;
   /** 婚姻状况
    * 
    * @pdOid 9768dda6-f7d9-469a-9ba6-8fc2d7eaa63c */
   @Field(value = "marital_status")
   private String maritalStatus;
   /** 籍贯
    * 
    * @pdOid 69f82089-606a-452a-8b87-89e2280ac7d7 */
   @Field(value = "native_place")
   private String nativePlace;
   /** 户籍地
    * 
    * @pdOid 0411ff26-3166-4acc-b56e-00c8d1e4cca6 */
   @Field(value = "domicile_place")
   private String domicilePlace;
   /** 户籍地详址
    * 
    * @pdOid ce635be2-ec8a-442c-9eca-1cf33fe07eaa */
   @Field(value = "domicile_place_address")
   private String domicilePlaceAddress;
   /** 现居地
    * 
    * @pdOid 600a4613-1eca-46ac-9b93-5abc6c0769dd */
   @Field(value = "living_place")
   private String livingPlace;
   /** 现居地详址
    * 
    * @pdOid 464f75b3-a598-4c7e-85d0-f55d694fc84a */
   @Field(value = "living_place_address")
   private String livingPlaceAddress;
   /** 国籍
    * 
    * @pdOid 0f052cc5-3cb8-41de-82ac-297a91c42b1f */
   private String nationality;
   /** 文化程度
    * 
    * @pdOid 1d0ea24e-fe1a-4a7a-8b84-cef3e5249916 */
   private String edu;
   /** 专长
    * 
    * @pdOid dbce945b-82f6-429d-bc7a-1f5443997301 */
   private String specialty;
   /** 政治面貌
    * 
    * @pdOid 662aa49b-20f2-47e5-a09d-0fefa38a92d7 */
   @Field(value = "political_outlook")
   private String politicalOutlook;
   /** 身份
    * 
    * @pdOid e75832c3-ab3e-44a9-af66-8a0eb9a4889c */
   private String identity;
   /** 特护身份
    * 
    * @pdOid e821c27c-db1b-4f0f-8bcc-c92ab4f5758d */
   @Field(value = "special_protection")
   private String specialProtection;
   /** 职业
    * 
    * @pdOid 3debc61d-d28b-4290-84b3-bc522e2360b0 */
   private String job;
   /** 工作单位
    * 
    * @pdOid d019f4d4-51fa-4b4e-8918-d3dd02e3f24f */
   private String workplace;
   /** 拘室号
    * 
    * @pdOid 95aa371f-a8b4-4546-80be-cc8228b89160 */
   @Field(value = "room_number")
   private String roomNumber;
   /** 收据凭证
    * 
    * @pdOid 115f6e4c-0e72-4514-aad1-5518d34938a9 */
   private String receipt;
   /** 入所文书号
    * 
    * @pdOid f5c07d81-c6b5-41ed-b65f-5cbe48e97e9a */
   @Field(value = "text_number")
   private String textNumber;
   /** 入所原因
    * 
    * @pdOid 95825417-2f92-408c-9290-0619f1cfc3c9 */
   @Field(value = "entry_reason")
   private String entryReason;
   /** 主要案由
    * 
    * @pdOid 7f0703c5-fbb1-4582-b4d5-9595bdad6fb0 */
   @Field(value = "main_cause")
   private String mainCause;
   /** 成员类型
    * 
    * @pdOid 05040f46-0df2-4136-93cc-a51a321733fa */
   @Field(value = "member_type")
   private String memberType;
   /** 从案案由
    * 
    * @pdOid b9dd3b4d-d568-42f6-8dea-2aef08af4c51 */
   @Field(value = "case")
   private String sCase;
   /** 拘留决定机关
    * 
    * @pdOid 9a4ec100-eb03-4bef-9908-52f9cc370ade */
   @Field(value = "decision_office")
   private String decisionOffice;
   /** 入所日期
    * 
    * @pdOid 39e0842e-ccc2-4a02-98bf-fc35db31229e */
   @Field(value = "entry_date")
   private java.util.Date entryDate;
   /** 拘押日期
    * 
    * @pdOid 14fcf236-528f-4a1f-a812-f9a575d78194 */
   @Field(value = "detain_date")
   private java.util.Date detainDate;
   /** 拘留天数
    * 
    * @pdOid 0ed49210-9d0f-4d89-a678-e952f234362a */
   @Field(value = "detain_days")
   private int detainDays;
   /** 办案单位
    * 
    * @pdOid f1dec166-9966-48cf-ba0b-b630d6068c15 */
   @Field(value = "handle_unit")
   private String handleUnit;
   /** 办案单位类型
    * 
    * @pdOid f6b0d847-2926-4f9c-9f8b-839e510fc8fa */
   @Field(value = "handle_unit_type")
   private String handleUnitType;
   /** 办案人
    * 
    * @pdOid 0a4557ad-0d29-4d10-a412-41bd1ccaad46 */
   private String operator;
   /** 办案人电话
    * 
    * @pdOid 38b5b413-42bb-4e3e-93de-3cbddcaf83e2 */
   @Field(value = "operator_tel")
   private String operatorTel;
   /** 裁决书号
    * 
    * @pdOid 56f800bb-2012-4f2c-951d-0d08a841dc5d */
   @Field(value = "rule_book_number")
   private String ruleBookNumber;
   /** 口音特点
    * 
    * @pdOid 99c99f2c-2367-403a-b1fe-4c38fa1e1f03 */
   @Field(value = "accent_trait")
   private String accentTrait;
   /** 危险等级
    * 
    * @pdOid 7101c269-8d8e-42bd-bd0a-df0ebd0c936c */
   @Field(value = "danger_grade")
   private String dangerGrade;
   /** 健康状况
    * 
    * @pdOid 5ed36765-9e4e-47e8-8ae6-dfe7d3f24f8b */
   private String health;
   /** 犯罪经历
    * 
    * @pdOid e6dfe858-b342-429a-ab39-0cba97b03a54 */
   @Field(value = "criminal_live")
   private String criminalLive;
   /** 情况描述
    * 
    * @pdOid 23a971d1-26e1-4525-b603-79ab1dd9386f */
   @Field(value = "situation_describe")
   private String situationDescribe;
   /** 出所日期
    * 
    * @pdOid ac8f0a58-f9c7-4746-94e4-f264a2fc4793 */
   @Field(value = "out_place_date")
   private java.util.Date outPlaceDate;
   /** 出所原因
    * 
    * @pdOid 998c6906-2472-4c12-8571-5129e5a3ec1b */
   @Field(value = "out_place_cause")
   private String outPlaceCause;
   /** 出所去向
    * 
    * @pdOid dfe9d0bd-1b17-47c7-ba46-85889bcbdd6f */
   @Field(value = "out_place_where")
   private String out_place_where;
   /** 备注
    * 
    * @pdOid 99640be2-0360-44f3-85cf-fede8e0883b1 */
   private String remarks;

}