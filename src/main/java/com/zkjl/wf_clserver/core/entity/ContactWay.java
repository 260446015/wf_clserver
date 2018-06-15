package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  contact_way.java
 * Author:  Administrator
 * Purpose: Defines the Class contact_way
 ***********************************************************************/


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** 联系方式
 * 
 * @pdOid d3f52a99-92af-475c-90f1-d195844a53ea */
@Document(collection = "contact_way")
@Data
public class ContactWay {
   /** 联系方式信息id
    * 
    * @pdOid 432e792f-4fa8-45c9-8f8a-570ab1644a6e */
   @Id
   private String id;
   /** 证件号
    * 
    * @pdOid dbf0ae86-8747-43a9-ba7d-b1ee928d19a2 */
   @Field(value = "id_card")
   private String idCard;
   /** 联系电话
    * 
    * @pdOid 74635624-7ab2-44ae-9521-897314f533fb */
   private String phone;
   /** 来源
    * 
    * @pdOid 19fee930-8d3d-4d47-9229-40e1a1747576 */
   private String source;

}