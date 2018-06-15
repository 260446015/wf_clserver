package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  Twitter.java
 * Author:  Administrator
 * Purpose: Defines the Class Twitter
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/** 微博
 * 
 */
@Document(collection="twitter")
@Data
public class Twitter {
   /** 微博信息id
    * 
    */
   @Id
   private String id;
   /** 手机号码
    * 
    */
   private String mobile;
   /** 微博账号
    * 
    */
   private String account;
   /** 姓名
    * 
    */
   private String name;

}