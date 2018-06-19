package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  internet_bar.java
 * Author:  Administrator
 * Purpose: Defines the Class internet_bar
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

/** 网吧
 * 
 * @pdOid 44d374ac-de1c-4ed4-a0e9-0c40c0d5297e */
@Data
@Document(collection = "internet_bar")
public class InternetBar {
   /** 网吧记录id
    * 
    * @pdOid 7a38c0d8-e9a3-4ac6-92b1-8eaaac1d842f */
   @Id
   private String id;
   /** 身份证号
    * 
    * @pdOid 887f8da1-ca99-4a73-ba12-f02e064fdba8 */
   @Field(value = "id_card")
   private String idCard;
   /** 上机时间
    * 
    * @pdOid 6e51350c-9a66-4226-b86d-00cfca71ba90 */
   @Field(value = "open_time")
   private java.util.Date openTime;
   /** 下机时间
    * 
    * @pdOid ecf145e5-a1d1-4423-8aca-7ef536ec4c59 */
   @Field(value = "close_time")
   private java.util.Date closeTime;
   /** 所属地
    * 
    * @pdOid 780dc895-efec-49df-bfb0-27c11b5586fa */
   private String local;
   /** 网吧名称
    * 
    * @pdOid 348f7275-0de7-494c-94fc-a7844f543683 */
   private String name;
   /** 地址
    * 
    * @pdOid 25f18bd6-0128-4451-a5c4-dd9e2470722e */
   private String address;

}