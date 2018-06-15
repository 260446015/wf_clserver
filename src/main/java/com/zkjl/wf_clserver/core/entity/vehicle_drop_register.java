/***********************************************************************
 * Module:  vehicle_drop_register.java
 * Author:  Administrator
 * Purpose: Defines the Class vehicle_drop_register
 ***********************************************************************/

import java.util.*;

/** 被盗抢骗机动车登记表
 * 
 * @pdOid 62fd0f57-9043-40eb-9cc7-fc062a7ed93a */
public class vehicle_drop_register {
   /** 被盗抢骗机动车登记id
    * 
    * @pdOid d4092c77-8c21-47f4-a71b-7c9b8ba7ee5b */
   public String id;
   /** 车辆所有人证件号
    * 
    * @pdOid 816ca4a9-60c5-4c7f-b345-b229441fd634 */
   public String id_card;
   /** 车辆所有人
    * 
    * @pdOid 2a52276a-780e-4268-a774-877f73effd75 */
   public String car_owner;
   /** 涉案物品编号
    * 
    * @pdOid 217c59b9-9a86-48be-87f8-0b0dbc87ebe4 */
   public String number;
   /** 车辆类型
    * 
    * @pdOid 3835d511-7d54-4e80-a5c2-9f8b06d501cf */
   public String car_type;
   /** 车身颜色
    * 
    * @pdOid b1be3605-85da-48dc-bfe8-04c00699b248 */
   public String color;
   /** 号牌种类
    * 
    * @pdOid df5ffb2a-eb8e-41dc-b9f6-6b0a7b143d55 */
   public String plate_type;
   /** 发动机号
    * 
    * @pdOid 4fbd4dae-02ab-4efc-a40c-be006113d820 */
   public String engine_number;
   /** 车辆品牌型号
    * 
    * @pdOid a1cf16ab-6d5c-4b20-8955-3757c556282d */
   public String brand_model;
   /** 初登日期
    * 
    * @pdOid 29e1e03e-04cf-4aaa-9c21-3d287f9ff6aa */
   public java.util.Date initial_date;
   /** 号牌号码
    * 
    * @pdOid 2a077682-ee9c-41d8-9161-8e4c48e2480d */
   public String plate_number;
   /** 车辆识别代码
    * 
    * @pdOid 28021ca8-e6e3-4369-8e0e-38b5353ecf8e */
   public String id_code;
   /** 是否参加被盗抢险
    * 
    * @pdOid 53049232-76c5-4f87-b499-fc5e4c85d9e6 */
   public String if_join_insurance;
   /** 报案人信息
    * 
    * @pdOid 72d0d7b8-0324-4b9c-a95b-a34c4efbf460 */
   public String information;
   /** 登记单位
    * 
    * @pdOid 47d8aebd-c14d-44b4-86b7-5066f42839a0 */
   public String register_unit;
   /** 登记人
    * 
    * @pdOid 0d721929-ff72-4783-bfce-de79bc0b1d89 */
   public String registrant;

}