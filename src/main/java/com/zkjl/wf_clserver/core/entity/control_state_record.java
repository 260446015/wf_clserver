/***********************************************************************
 * Module:  control_state_record.java
 * Author:  Administrator
 * Purpose: Defines the Class control_state_record
 ***********************************************************************/

import java.util.*;

/** 管控状态记录
 * 
 * @pdOid c91db628-96fc-4a33-b46e-7de5bb7438a4 */
public class control_state_record {
   /** 管控状态记录id
    * 
    * @pdOid c86e9242-02e2-4b1c-a1d4-747137fa9d5d */
   public String id;
   /** 证件号码
    * 
    * @pdOid 84cfb071-9b42-4932-b08c-1c776391a118 */
   public String id_card;
   /** 管控状态
    * 
    * @pdOid 8ea567f8-943b-493a-bb8c-212b44efa568 */
   public String state;
   /** 管控记录
    * 
    * @pdOid cbd9e923-ed28-43ef-abf3-f71bd8ac4753 */
   public String record;
   /** 管控地区
    * 
    * @pdOid 99e3b1b3-0421-4229-84c1-fefe1999b4f6 */
   public String area;
   /** 管控单位详称
    * 
    * @pdOid dfb892a6-6270-490a-bf7b-08cdad77996a */
   public String unit_detail_name;
   /** 开始日期
    * 
    * @pdOid 6733297a-9379-4801-84d4-777ce7f25607 */
   public java.util.Date begin_date;
   /** 更新时间
    * 
    * @pdOid c709dd90-ec28-4e0c-8b8a-5bae762bb4eb */
   public java.util.Date update_date;
   /** 后续管控环节
    * 
    * @pdOid 810d4428-3638-46b2-ac44-3419e8680ed6 */
   public String follow_up_link;
   /** 后续接管单位
    * 
    * @pdOid fdb3ac21-c918-4018-b6e7-6fec2816a87f */
   public String follow_up_unit;

}