package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/** 论坛
 * 
 * */
@Document(collection = "forum")
@Data
public class Forum {
   /** 论坛信息id
    * 
    * */
   @Id
   private String id;
   /** 地址
    * 
    * */
   private String address;
   /** 名称
    * 
    * */
   private String name;
   /** 手机号
    * 
    * */
   private String mobile;

}