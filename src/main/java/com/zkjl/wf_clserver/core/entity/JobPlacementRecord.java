package com.zkjl.wf_clserver.core.entity; 

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 就业安置记录
 * 
 * */
@Document(collection = "job_placement_record")
@Data
public class JobPlacementRecord {
   /** 就业安置记录id
    * 
    * */
   @Id
   private String id;
   /** 安置人证件号码
    * 
    * */
   @Field(value = "id_card")
   private String idCard;
   /** 安置类型
    * 
    * */
   @Field(value = "placement_type")
   private String placementType;
   /** 就业安置地区
    * 
    * */
   @Field(value = "job_area")
   private String jobArea;
   /** 从业状况
    * 
    * */
   @Field(value = "job_situation")
   private String jobSituation;
   /** 是否纳入低保
    * 
    * */
   @Field(value = "if_low_insurance")
   private String ifLowInsurance;
   /** 安置单位名称
    * 
    * */
   @Field(value = "unit_name")
   private String unitName;
   /** 安置时间
    * 
    * */
   @Field(value = "placement_date")
   private Date placementDate;
   /** 安置结束原因
    * 
    * */
   @Field(value = "end_reason")
   private String endReason;
   /** 安置结束时间
    * 
    * */
   @Field(value = "end_time")
   private Date endTime;
   /** 填表人
    * 
    * */
   private String preparer;
   /** 填表单位
    * 
    * */
   @Field(value = "filling_unit")
   private String fillingUnit;
   /** 填表人联系电话
    * 
    * */
   @Field(value = "preparer_tel")
   private String preparerTel;
   /** 填表审核人
    * 
    * */
   @Field(value = "filling_auditor")
   private String fillingAuditor;
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
   /** 管控单位
    * 
    * */
   @Field(value = "control_unit")
   private String controlUnit;
   /** 是否办理失业登记
    * 
    * */
   @Field(value = "if_handle")
   private String ifHandle;
   /** 是否参加职业技能培训
    * 
    * */
   @Field(value = "if_join")
   private String ifJoin;
   /** 职业资格
    * 
    * */
   private String qualification;
   /** 就业安置单位工商注册或民政登记号
    * 
    * */
   private String number;
   /** 就业安置单位法人代表
    * 
    * */
   private String legal;
   /** 安置规模
    * 
    * */
   private String scale;
   /** 参加社会保险类型
    * 
    * */
   @Field(value = "insurance_type")
   private String insuranceType;
   /** 享受社会救助类型
    * 
    * */
   @Field(value = "assistance_type")
   private String assistanceType;
   /** 备注
    * 
    * */
   private String remarks;

}