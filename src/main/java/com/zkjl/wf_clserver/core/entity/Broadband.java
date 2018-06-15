package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  broadband.java
 * Author:  Administrator
 * Purpose: Defines the Class broadband
 ***********************************************************************/


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** 宽带信息
 * 
 * @pdOid 0c8c3542-7a99-43b0-80b7-a6f74c76a86c */
@Document(collection = "broadband")
@Data
public class Broadband {
   /** 宽带信息id
    * 
    * @pdOid d8c999ed-6dc2-4ce6-a1f4-ae991174ae54 */
   @Id
   private String id;
   /** 身份证号
    * 
    * @pdOid 4005e4cc-24ff-4476-956f-7d2310ee251a */
   @Field(value = "id_card")
   private String idCard;
   /** 姓名
    * 
    * @pdOid d1ab58f0-287c-4737-ba0e-3d9cfebd0108 */
   private String name;
   /** 联系电话
    * 
    * @pdOid fd28fd75-9e9f-4e27-a044-7bff12068c11 */
   @Field(value = "contact_phone")
   private String contact_phone;
   /** 地址
    * 
    * @pdOid f794654e-3da2-420a-9b83-046dc31c32b8 */
   private String address;
   /** 账号
    * 
    * @pdOid a2188c4e-41c1-4fe5-938e-6107ca2612b4 */
   private String account;

}