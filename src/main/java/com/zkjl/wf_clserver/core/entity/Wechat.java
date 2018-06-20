package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** 微信
 * 
 */
@Document(collection="wechat")
@Data
public class Wechat {
   /** 微信信息id
    * 
    */
   @Id
   private String id;
   /** 手机号
    * 
    */
   @Field(value = "mobile")
   private String mobile;
   /** 微信号
    * 
    */
   @Field(value = "wechat_number")
   private String wechatNumber;

}