package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** 宽带信息
 * 
 * */
@Document(collection = "broadband")
@Data
public class Broadband {
   /** 宽带信息id
    * 
    * */
   @Id
   private String id;
   /** 身份证号
    * 
    * */
   @Field(value = "id_card")
   private String idCard;
   /** 姓名
    * 
    * */
   private String name;
   /** 联系电话
    * 
    * */
   @Field(value = "contact_phone")
   private String contactPhone;
   /** 地址
    * 
    * */
   private String address;
   /** 账号
    * 
    * */
   private String account;

}