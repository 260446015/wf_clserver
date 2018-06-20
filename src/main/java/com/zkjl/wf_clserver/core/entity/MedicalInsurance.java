package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 医保
 * 
 */
@Document(collection = "medical_insurance")
@Data
public class MedicalInsurance {
   /** 医保信息id
    * 
    */
   @Id
   private String id;
   /** 身份证号
    * 
    */
   @Field(value = "id_card")
   private String idCard;
   /** 姓名
    * 
    */
   private String name;
   /** 出生日期
    * 
    */
   @Field(value = "birth_date")
   private Date birthDate;
   /** 原单位编号
    * 
    */
   @Field(value = "former_number")
   private String formerNumber;
   /** 原单位名称
    * 
    */
   @Field(value = "former_name")
   private String formerName;
   /** 现单位编号
    * 
    */
   @Field(value = "now_number")
   private String nowNumber;
   /** 现单位名称
    * 
    */
   @Field(value = "now_name")
   private String nowName;

}