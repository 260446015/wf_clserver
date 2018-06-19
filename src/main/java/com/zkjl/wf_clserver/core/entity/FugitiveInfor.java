package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  fugitive_infor.java
 * Author:  Administrator
 * Purpose: Defines the Class fugitive_infor
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

/** 在逃人员信息表
 * 
 * @pdOid 7f05a7e0-0fbd-4be8-b8c1-fa48e4412100 */
@Document(collection = "fugitive_infor")
@Data
public class FugitiveInfor {
   /** 在逃人员信息id
    * 
    * @pdOid 1c864348-9986-4d35-bd25-0848b0d38177 */
   @Id
   private String id;
   /** 姓名
    * 
    * @pdOid 80e3c78c-c4d6-4ac6-b8d2-b733d80320eb */
   private String name;
   /** 別名
    * 
    * @pdOid a35a9e96-4f0e-4774-bb32-73f2b6b0f3bd */
   private String nickname;
   /** 性別
    * 
    * @pdOid 2e29c5db-b9a8-476f-89b3-1a4cc4bd7b5d */
   private String sex;
   /** 头像
    * 
    * @pdOid f587c759-39f6-444c-b464-658598ca444f */
   private String image;
   /** 出生日期
    * 
    * @pdOid 7d7efcd9-19f5-4734-aadc-3fd709ee2944 */
   private java.util.Date birth;
   /** 证件
    * 
    * @pdOid 30033a6c-16be-47a1-a737-ea5a66b9530b */
   @Field(value = "id_card")
   private String idCard;
   /** 民族
    * 
    * @pdOid 48410aaa-db17-4915-b84f-0091771626dc */
   private String race;
   /** 其他证件
    * 
    * @pdOid b21a3552-f858-4f48-bb40-5f7236764e4e */
   @Field(value = "other_identity")
   private String otherIdentity;
   /** 身高
    * 
    * @pdOid c2f266d7-ee4d-43d7-9519-1ff2d333163f */
   private String height;
   /** 口音
    * 
    * @pdOid 5fbec191-e8c4-4bba-a263-0743260544e9 */
   private String accent;
   /** 职业
    * 
    * @pdOid 23a368e0-6d64-4e0e-a203-991db7e00fba */
   private String occupation;
   /** 户籍地址
    * 
    * @pdOid 032b6784-cad0-4323-a740-705b262901ea */
   @Field(value = "permanent_address")
   private String permanentAddress;
   /** 现住地址
    * 
    * @pdOid dfb51f4c-065d-49ee-bb86-577fc0ec39e3 */
   @Field(value = "local_address")
   private String localAddress;
   /** 籍贯
    * 
    * @pdOid 8dde697e-0e4c-4f5c-b203-039f372847db */
   @Field(value = "native_place")
   private String nativePlace;
   /** 体貌特征
    * 
    * @pdOid 1af8dd0f-c728-43b2-97ee-89a397a17dcc */
   @Field(value = "physique_features")
   private String physiqueFeatures;
   /** 体表标记
    * 
    * @pdOid b112beec-417a-477a-a3bd-548385e080ba */
   @Field(value = "body_marker")
   private String bodyMarker;
   /** 案件编号
    * 
    * @pdOid 29699251-76ee-4fa8-80c4-afff83fb24c0 */
   @Field(value = "case_number")
   private String caseNumber;
   /** 案件类别
    * 
    * @pdOid 276b4aa5-d8cb-42f4-be88-80691bc1463f */
   @Field(value = "case_category")
   private String caseCategory;
   /** 简要案情及附加信息
    * 
    * @pdOid 49e271fa-0fa1-481f-b339-03b2ed549ae1 */
   @Field(value = "brief_case")
   private String briefCase;
   /** 立案单位
    * 
    * @pdOid 3f269c29-2b95-4753-933a-ef0b7629bccd */
   @Field(value = "register_unit")
   private String registerUnit;
   /** 立案单位详称
    * 
    * @pdOid 2fbb63fa-71df-4fc8-b917-9f3fdab5e238 */
   @Field(value = "register_unit_detail")
   private String registerUnitDetail;
   /** 立案日期
    * 
    * @pdOid c8c2909a-4bbe-45e2-85e5-0784e2923dca */
   @Field(value = "register_date")
   private java.util.Date registerDate;
   /** 逃跑日期
    * 
    * @pdOid 0062037f-cb5c-4069-af69-babffcbe4475 */
   @Field(value = "escape_date")
   private java.util.Date escapeDate;
   /** 逃跑方向
    * 
    * @pdOid 62b0cc71-60c2-4a8f-91c2-a93f64935480 */
   @Field(value = "escape_direction")
   private String escapeDirection;
   /** 在逃类型
    * 
    * @pdOid 1af76503-0a87-471f-b117-4925eb1428bf */
   @Field(value = "escape_type")
   private String escapeType;
   /** 备注
    * 
    * @pdOid 96fd2b90-32ca-4f8b-9350-b241734fd470 */
   private String remark;
   /** 法律文件
    * 
    * @pdOid 3e213f6e-464a-4d4e-ba6c-9fae376094b8 */
   @Field(value = "legal_file")
   private String legalFile;
   /** 通缉令
    * 
    * @pdOid 08508c63-1704-476f-a075-45add061d45b */
   @Field(value = "wanted_circular")
   private String wantedCircular;
   /** 通缉令级别
    * 
    * @pdOid 59c559e1-d780-42b8-ae3a-9bb3cedee292 */
   @Field(value = "warrant_level")
   private String warrantLevel;
   /** 奖金（元）
    * 
    * @pdOid 6ec871d4-97de-4d79-8c86-bfa3fb7996ce */
   private double bonus;
   /** 主办单位分类
    * 
    * @pdOid b5c0c87f-0b63-4c19-a5f1-0e4f1a5e0c2e */
   @Field(value = "host_unit_class")
   private String hostUnitClass;
   /** 主办单位
    * 
    * @pdOid b1e966aa-3341-41bc-a917-6a13af5cf556 */
   @Field(value = "host_unit")
   private String hostUnit;
   /** 主办人
    * 
    * @pdOid c480705b-2868-4199-8cd9-2252a6d3ffd2 */
   private String sponsor;
   /** 联系方式
    * 
    * @pdOid bc42370e-48db-4d53-aaa7-93394c514fdc */
   @Field(value = "contact_way")
   private String contactWay;
   /** 主办人2
    * 
    * @pdOid 28fe71c8-8e8c-478c-944b-8312e33c8c97 */
   @Field(value = "sponsor_two")
   private String sponsorTwo;
   /** 联系方式2
    * 
    * @pdOid dcc914ac-45f8-4fc1-893d-9aff9b53d27e */
   @Field(value = "contact_way_two")
   private String contactWayTwo;
   /** 主办单位电话
    * 
    * @pdOid 715d2901-3382-4b0e-aad4-6556b21b773a */
   @Field(value = "host_unit_tel")
   private String hostUnitTel;
   /** 上网登记审批人
    * 
    * @pdOid 426563f3-bd3d-4aac-ba37-55bb6da06994 */
   private String approver;

}