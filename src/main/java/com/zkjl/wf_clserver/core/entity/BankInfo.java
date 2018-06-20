package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** 银行信息
 */
@Document(collection = "bank_info")
@Data
public class BankInfo {
   /** 银行信息id
    * 
    * */
   @Id
   private String id;
   /** 身份证号
    * 
    * */
   @Field(value = "id_card")
   private String idCard;
   /** 所属银行
    * 
    * */
   private String bank;
   /** 银行账号
    * 
    * */
   private String account;

}