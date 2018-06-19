package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  NetworkData.java
 * Author:  Administrator
 * Purpose: Defines the Class NetworkData
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/** 网络数据统计
 * 
 */
@Document(collection = "network_data")
@Data
public class NetworkData {
   /** 网络统计数据id
    * 
    */
   private String id;
   /** 网络数据类别名称
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