package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 闭环系统信息
 * 
 * */
@Document(collection = "closed_loop")
@Data
public class ClosedLoop {
   /** 闭环系统信息id
    * 
    * */
   @Id
   private String id;
   /** 证件号码
    * 
    * */
   @Field(value = "id_card")
   private String idCard;
   /** 接警单位
    * 
    * */
   @Field(value = "receiving_unit")
   private String receivingUnit;
   /** 接警人
    * 
    * */
   private String police;
   /** 接警时间
    * 
    * */
   @Field(value = "receive_time")
   private Date receiveTime;
   /** 报警方式
    * 
    * */
   @Field(value = "receive_mode")
   private String receiveMode;
   /** 录音号
    * 
    * */
   @Field(value = "tape_number")
   private String tapeNumber;
   /** 报警电话
    * 
    * */
   @Field(value = "alarm_phone")
   private String alarmPhone;
   /** 用户姓名
    * 
    * */
   private String name;
   /** 装机地址
    * 
    * */
   @Field(value = "installed_address")
   private String installedAddress;
   /** 报警人
    * 
    * */
   @Field(value = "alarm_person")
   private String alarmPerson;
   /** 性别
    * 
    * */
   private String sex;
   /** 联系电话
    * 
    * */
   private String phone;
   /** 联系地址
    * 
    * */
   private String address;
   /** 事发地址
    * 
    * */
   @Field(value = "incident_address")
   private String incidentAddress;
   /** 所属分局
    * 
    * */
   private String branches;
   /** 辖区单位
    * 
    * */
   @Field(value = "district_unit")
   private String districtUnit;
   /** 报警类别
    * 
    * */
   private String category;
   /** 报警类型
    * 
    * */
   private String type;
   /** 报警细类
    * 
    * */
   @Field(value = "fine_class")
   private String fineClass;
   /** 警情级别
    * 
    * */
   private String level;
   /** 报警内容
    * 
    * */
   private String content;
   /** 处警意见
    * 
    * */
   @Field(value = "police_opinion")
   private String policeOpinion;
   /** 反馈情况
    * 
    * */
   private String feedback;

}