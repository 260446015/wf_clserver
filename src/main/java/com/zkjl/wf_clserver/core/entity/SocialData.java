package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/** 社会数据统计
 * 
 */
@Document(collection = "social_data")
@Data
public class SocialData {
   /** 社会数据统计id
    * 
    */
   @Id
   private String id;
   /** 社会数据类别名称
    * 
    */
   private String name;
   /** 数据量
    * 
    */
   private int quantity;
   /** 统计维度
    * 
    */
   private String dimension;
   /** 年
    * 
    */
   private int year;
   /** 月
    * 
    */
   private int month;
   /** 日
    * 
    */
   private int day;

}