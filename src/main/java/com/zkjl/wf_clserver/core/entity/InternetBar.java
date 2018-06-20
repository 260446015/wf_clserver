package com.zkjl.wf_clserver.core.entity; 

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 网吧
 * 
 * */
@Data
@Document(collection = "internet_bar")
public class InternetBar {
   /** 网吧记录id
    * 
    * */
   @Id
   private String id;
   /** 身份证号
    * 
    * */
   @Field(value = "id_card")
   private String idCard;
   /** 上机时间
    * 
    * */
   @Field(value = "open_time")
   private Date openTime;
   /** 下机时间
    * 
    * */
   @Field(value = "close_time")
   private Date closeTime;
   /** 所属地
    * 
    * */
   private String local;
   /** 网吧名称
    * 
    * */
   private String name;
   /** 地址
    * 
    * */
   private String address;

}