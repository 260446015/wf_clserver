package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  fund.java
 * Author:  Administrator
 * Purpose: Defines the Class fund
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

/** 公积金
 * 
 * @pdOid a92bba35-11a9-4dca-b968-471304ac2ea2 */
@Document(collection = "fund")
@Data
public class Fund {
   /** 公积金信息id
    * 
    * @pdOid d1210bbe-2f77-40e2-b08f-939339927617 */
   @Id
   private String id;
   /** 身份证号
    * 
    * @pdOid 1ffd681f-5a1e-4c3a-8ca5-b48b9a806f39 */
   @Field(value = "id_card")
   private String idCard;
   /** 个人账号
    * 
    * @pdOid f59dc199-6e3d-4373-add6-e0441055edc8 */
   private String account;
   /** 个人登记号
    * 
    * @pdOid 61d89742-9bb7-4f27-afdd-5fa5a214910e */
   @Field(value = "regist_number")
   private String registNumber;
   /** 工作单位
    * 
    * @pdOid 0df57f5f-f0a9-490e-815a-6dda6acc608d */
   private String workplace;
   /** 所属管理部
    * 
    * @pdOid d65c8e16-fc9a-42f0-8c0a-5cc3ad325244 */
   private String department;
   /** 状态
    * 
    * @pdOid 975b7c40-96b4-4422-b46a-0daedbe5d933 */
   private String status;

}