package com.zkjl.wf_clserver.core.entity;
/***********************************************************************
 * Module:  bank_info.java
 * Author:  Administrator
 * Purpose: Defines the Class bank_info
 ***********************************************************************/


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** 银行信息
 * 
 * @pdOid c4679752-223c-46d7-ace5-44d4aac8e42d */
@Document(collection = "bank_info")
@Data
public class BankInfo {
   /** 银行信息id
    * 
    * @pdOid d1a324b5-2585-4244-b796-7dcb35d4f0e8 */
   @Id
   private String id;
   /** 身份证号
    * 
    * @pdOid 99a2600b-de5e-4dc6-ba89-c512b72f34f1 */
   @Field(value = "id_card")
   private String idCard;
   /** 所属银行
    * 
    * @pdOid a28267b7-c64f-48f4-bc2c-274045aef620 */
   private String bank;
   /** 银行账号
    * 
    * @pdOid 6f5e94f1-8f01-442a-a26c-4b89e3e588c1 */
   private String account;

}