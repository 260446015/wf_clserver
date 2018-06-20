package com.zkjl.wf_clserver.core.entity; 

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 核查核录记录
 * 
 * */
@Document(collection = "check_record")
@Data
public class CheckRecord {
   /** 核查核录记录编号
    * 
    * */
   @Id
   private String id;
   /** 被采集人姓名
    * 
    * */
   @Field(value = "full_name")
   private String fullName;
   /** 被采集人证件号码
    * 
    * */
   @Field(value = "id_card")
   private String idCard;
   /** 民族
    * 
    * */
   private String nation;
   /** 国籍(境外人员)
    * 
    * */
   private String nationality;
   /** 核录批次标识，关联人+车
    * 
    * */
   @Field(value = "batch_id")
   private String batchId;
   /** 核录时间
    * 
    * */
   @Field(value = "record_time")
   private Date recordTime;
   /** 核录人身份证号
    * 
    * */
   @Field(value = "recorder_card")
   private String recorderCard;
   /** 核录人部门
    * 
    * */
   private String department;
   /** 被采集人联系方式
    * 
    * */
   private String contact;
   /** 采集地点
    * 
    * */
   private String site;
   /** 采集地点X坐标
    * 
    * */
   @Field(value = "x_axis")
   private double xAxis;
   /** 采集地点Y坐标
    * 
    * */
   @Field(value = "y_axis")
   private double yAxis;
   /** 备注信息
    * 
    * */
   private String remark;
   /** 核录位置-地市
    * 
    * */
   private String city;
   /** 核录位置-区县
    * 
    * */
   private String district;
   /** 被采集人证件类型
    * 
    * */
   @Field(value = "id_type")
   private String idType;
   /** 核录位置-详细地址
    * 
    * */
   @Field(value = "detail_address")
   private String detailAddress;
   /** 使用场景
    * 
    * */
   @Field(value = "use_case")
   private String useCase;
   /** 处置要求
    * 
    * */
   @Field(value = "handle_ask")
   private String handleAsk;
   /** 处置措施
    * 
    * */
   @Field(value = "handle_step")
   private String handleStep;
   /** 户籍地区划分
    * 
    * */
   private String divide;
   /** 人员大类（关联人员表人员大类）
    * 
    * */
   @Field(value = "personnel_class")
   private String personnelClass;
   /** 人员细类（关联人员表人员细类）
    * 
    * */
   @Field(value = "personnel_fine_class")
   private String personnelFineClass;
   /** 设备归属部门
    * 
    * */
   @Field(value = "device_department")
   private String deviceDepartment;
   /** 联络人姓名
    * 
    * */
   @Field(value = "liaison_name")
   private String liaisonName;
   /** 联络人联系方式
    * 
    * */
   @Field(value = "liaison_contact_mode")
   private String liaisonContactMode;

}