package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

/** 列管记录
 * 
 */
@Data
@Document(collection="tube_record")
public class TubeRecord {
   /** 列管id
    * 
    */
   @Id
   private String id;
   /** 证件号码
    * 
    */
   @Field(value = "id_card")
   private String idCard;
   /** 列管状态
    * 
    */
   @Field(value = "tube_status")
   private String tubeStatus;
   /** 开始日期
    * 
    */
   @Field(value = "begin_date")
   private Date beginDate;
   /** 更新时间
    * 
    */
   @Field(value = "update_date")
   private Date updateDate;
   /** 后续管控环节
    * 
    */
   @Field(value = "follow_up_link")
   private String followUpLink;
   /** 后续接管单位
    * 
    */
   @Field(value = "follow_up_unit")
   private String followUpUnit;
   /** 列管单位
    * 
    */
   @Field(value = "tube_unit")
   private String tubeUnit;
   /** 列管单位详称
    * 
    */
   @Field(value = "tube_unit_name")
   private String tubeUnitName;
   /** 列管日期
    * 
    */
   @Field(value = "tube_date")
   private Date tubeDate;
   /** 有效尿检开始时间
    * 
    */
   @Field(value = "test_begin_date")
   private Date testBeginDate;
   /** 有效尿检期限月
    * 
    */
   private String term;
   /** 第一年有效尿检次数
    * 
    */
   @Field(value = "first_year_counts")
   private int firstYearCount;
   /** 第二年有效尿检次数
    * 
    */
   @Field(value = "second_year_count")
   private int secondYearCount;
   /** 第三年有效尿检次数
    * 
    */
   @Field(value = "third_year_count")
   private int thirdYearCount;
   /** 录入单位2
    * 
    */
   @Field(value = "entry_unit")
   private String entryUnit;
   /** 录入人2
    * 
    */
   @Field(value = "input_person")
   private String inputPerson;
   /** 录入日期2
    * 
    */
   @Field(value = "input_date")
   private Date inputDate;

}