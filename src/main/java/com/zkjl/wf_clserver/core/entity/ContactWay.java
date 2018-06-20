package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** 联系方式
 * 
 * */
@Document(collection = "contact_way")
@Data
public class ContactWay {
   /** 联系方式信息id
    * 
    * */
   @Id
   private String id;
   /** 证件号
    * 
    * */
   @Field(value = "id_card")
   private String idCard;
   /** 联系电话
    * 
    * */
   private String phone;
   /** 来源
    * 
    * */
   private String source;

}