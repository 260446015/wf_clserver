package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** 公积金
 * 
 * */
@Document(collection = "fund")
@Data
public class Fund {
   /** 公积金信息id
    * 
    * */
   @Id
   private String id;
   /** 身份证号
    * 
    * */
   @Field(value = "id_card")
   private String idCard;
   /** 个人账号
    * 
    * */
   private String account;
   /** 个人登记号
    * 
    * */
   @Field(value = "regist_number")
   private String registNumber;
   /** 工作单位
    * 
    * */
   private String workplace;
   /** 所属管理部
    * 
    * */
   private String department;
   /** 状态
    * 
    * */
   private String status;

}