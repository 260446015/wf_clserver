package com.zkjl.wf_clserver.core.entity; 

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 在逃人员信息表
 * 
 * */
@Document(collection = "fugitive_infor")
@Data
public class FugitiveInfor {
   /** 在逃人员信息id
    * 
    * */
   @Id
   private String id;
   /** 姓名
    * 
    * */
   private String name;
   /** 別名
    * 
    * */
   private String nickname;
   /** 性別
    * 
    * */
   private String sex;
   /** 头像
    * 
    * */
   private String image;
   /** 出生日期
    * 
    * */
   private Date birth;
   /** 证件
    * 
    * */
   @Field(value = "id_card")
   private String idCard;
   /** 民族
    * 
    * */
   private String race;
   /** 其他证件
    * 
    * */
   @Field(value = "other_identity")
   private String otherIdentity;
   /** 身高
    * 
    * */
   private String height;
   /** 口音
    * 
    * */
   private String accent;
   /** 职业
    * 
    * */
   private String occupation;
   /** 户籍地址
    * 
    * */
   @Field(value = "permanent_address")
   private String permanentAddress;
   /** 现住地址
    * 
    * */
   @Field(value = "local_address")
   private String localAddress;
   /** 籍贯
    * 
    * */
   @Field(value = "native_place")
   private String nativePlace;
   /** 体貌特征
    * 
    * */
   @Field(value = "physique_features")
   private String physiqueFeatures;
   /** 体表标记
    * 
    * */
   @Field(value = "body_marker")
   private String bodyMarker;
   /** 案件编号
    * 
    * */
   @Field(value = "case_number")
   private String caseNumber;
   /** 案件类别
    * 
    * */
   @Field(value = "case_category")
   private String caseCategory;
   /** 简要案情及附加信息
    * 
    * */
   @Field(value = "brief_case")
   private String briefCase;
   /** 立案单位
    * 
    * */
   @Field(value = "register_unit")
   private String registerUnit;
   /** 立案单位详称
    * 
    * */
   @Field(value = "register_unit_detail")
   private String registerUnitDetail;
   /** 立案日期
    * 
    * */
   @Field(value = "register_date")
   private Date registerDate;
   /** 逃跑日期
    * 
    * */
   @Field(value = "escape_date")
   private Date escapeDate;
   /** 逃跑方向
    * 
    * */
   @Field(value = "escape_direction")
   private String escapeDirection;
   /** 在逃类型
    * 
    * */
   @Field(value = "escape_type")
   private String escapeType;
   /** 备注
    * 
    * */
   private String remark;
   /** 法律文件
    * 
    * */
   @Field(value = "legal_file")
   private String legalFile;
   /** 通缉令
    * 
    * */
   @Field(value = "wanted_circular")
   private String wantedCircular;
   /** 通缉令级别
    * 
    * */
   @Field(value = "warrant_level")
   private String warrantLevel;
   /** 奖金（元）
    * 
    * */
   private double bonus;
   /** 主办单位分类
    * 
    * */
   @Field(value = "host_unit_class")
   private String hostUnitClass;
   /** 主办单位
    * 
    * */
   @Field(value = "host_unit")
   private String hostUnit;
   /** 主办人
    * 
    * */
   private String sponsor;
   /** 联系方式
    * 
    * */
   @Field(value = "contact_way")
   private String contactWay;
   /** 主办人2
    * 
    * */
   @Field(value = "sponsor_two")
   private String sponsorTwo;
   /** 联系方式2
    * 
    * */
   @Field(value = "contact_way_two")
   private String contactWayTwo;
   /** 主办单位电话
    * 
    * */
   @Field(value = "host_unit_tel")
   private String hostUnitTel;
   /** 上网登记审批人
    * 
    * */
   private String approver;

}