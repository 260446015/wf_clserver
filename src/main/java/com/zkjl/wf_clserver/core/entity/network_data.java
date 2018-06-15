/***********************************************************************
 * Module:  network_data.java
 * Author:  Administrator
 * Purpose: Defines the Class network_data
 ***********************************************************************/

import java.util.*;

/** 网络数据统计
 * 
 * @pdOid f12a740c-fd04-4e42-aca2-396dbae96a81 */
public class network_data {
   /** 网络统计数据id
    * 
    * @pdOid 971a8100-ae87-4a73-acb5-b9e409028e1a */
   public String id;
   /** 网络数据类别名称
    * 
    * @pdOid e37573b3-0943-42fb-b1a5-f80266ac534e */
   public String name;
   /** 数据量
    * 
    * @pdOid a7e8e2e9-747c-4a16-baec-c3bc63676d0e */
   public int quantity;
   /** 统计维度
    * 
    * @pdOid b7246c64-4513-47bf-9d23-9057648edf09 */
   public String dimension;
   /** 年
    * 
    * @pdOid 79bb4e61-72d2-48b5-849d-c1ee4c797e51 */
   public int year;
   /** 月
    * 
    * @pdOid a9a727c2-48b0-4c91-849d-22f8af227a4b */
   public int month;
   /** 日
    * 
    * @pdOid 16a673d7-b89b-43b4-8976-c1393e66827b */
   public int day;

}