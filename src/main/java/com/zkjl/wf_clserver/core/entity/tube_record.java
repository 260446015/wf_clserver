/***********************************************************************
 * Module:  tube_record.java
 * Author:  Administrator
 * Purpose: Defines the Class tube_record
 ***********************************************************************/

import java.util.*;

/** 列管记录
 * 
 * @pdOid d51f5f61-4aed-4bbc-b953-a2ecf7144b40 */
public class tube_record {
   /** 列管id
    * 
    * @pdOid a5734b1d-711a-45bd-9d0c-2b270a3c5e39 */
   public java.lang.String id;
   /** 证件号码
    * 
    * @pdOid 5c19efb0-5965-42c4-ab2b-0cfe6ea4adbc */
   public java.lang.String id_card;
   /** 列管状态
    * 
    * @pdOid 3bb0212d-0aa9-443a-9d5a-5ffa7d8550b0 */
   public java.lang.String tube_status;
   /** 开始日期
    * 
    * @pdOid 8100864e-034e-448d-a1a1-b004e57b476c */
   public java.util.Date begin_date;
   /** 更新时间
    * 
    * @pdOid c0902306-0316-4332-a3e7-ff4fa7eba421 */
   public java.util.Date update_date;
   /** 后续管控环节
    * 
    * @pdOid e94d1568-90f9-43bf-8489-33cf5ca8c117 */
   public java.lang.String follow_up_link;
   /** 后续接管单位
    * 
    * @pdOid 17a959a7-1f84-4d95-8a3f-f3516e5493f7 */
   public java.lang.String follow_up_unit;
   /** 列管单位
    * 
    * @pdOid eb82f39f-234a-49aa-bb72-551bef07c2c4 */
   public java.lang.String tube_unit;
   /** 列管单位详称
    * 
    * @pdOid 9768f813-f9b6-4818-b387-e17449331d5d */
   public java.lang.String tube_unit_name;
   /** 列管日期
    * 
    * @pdOid 94f36545-81db-4096-8799-101d428ce44a */
   public java.util.Date tube_date;
   /** 有效尿检开始时间
    * 
    * @pdOid a98c4da2-57dc-4498-a7a0-749cab6d2357 */
   public java.util.Date test_begin_date;
   /** 有效尿检期限月
    * 
    * @pdOid 3e28482a-966d-4abd-b0a4-3baaa2a904ef */
   public java.lang.String term;
   /** 第一年有效尿检次数
    * 
    * @pdOid cbdd5dc7-14b6-4a79-bd0f-56bac466855d */
   public int first_year_count;
   /** 第二年有效尿检次数
    * 
    * @pdOid 57f70d79-9598-40cf-af70-7533ac79855a */
   public int second_year_count;
   /** 第三年有效尿检次数
    * 
    * @pdOid d8f0ae9c-81ee-4d6e-b236-cd9abafe95a5 */
   public int third_year_count;
   /** 录入单位2
    * 
    * @pdOid 086f8183-5f88-4a8e-9338-634435d8d15d */
   public java.lang.String entry_unit;
   /** 录入人2
    * 
    * @pdOid 1344b1c1-881e-4a08-9481-744472cf67ab */
   public java.lang.String input_person;
   /** 录入日期2
    * 
    * @pdOid 61f59a5c-284d-486e-85ee-6da0891d3d77 */
   public java.util.Date input_date;

}