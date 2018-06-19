/***********************************************************************
 * Module:  job_placement_record.java
 * Author:  Administrator
 * Purpose: Defines the Class job_placement_record
 ***********************************************************************/

import java.util.*;

/** 就业安置记录
 * 
 * @pdOid 9d41161f-7808-4ab6-981c-368d05d6ffa8 */
public class job_placement_record {
   /** 就业安置记录id
    * 
    * @pdOid ea4f27b9-acc9-435a-9281-cb5565c240a0 */
   public String id;
   /** 安置人证件号码
    * 
    * @pdOid 083e6283-f47d-4834-8d42-7a89d31a203b */
   public String id_card;
   /** 安置类型
    * 
    * @pdOid 4f6e6417-4df4-447c-b685-ca55b2dd7096 */
   public String placement_type;
   /** 就业安置地区
    * 
    * @pdOid 0cdc4dcb-5109-4e2d-9ce2-e83f1077485d */
   public String job_area;
   /** 从业状况
    * 
    * @pdOid 67c296e3-81ce-42c0-b5d7-fd5b5342711d */
   public String job_situation;
   /** 是否纳入低保
    * 
    * @pdOid e618aba6-f643-48f3-8d99-df84791381ee */
   public String if_low_insurance;
   /** 安置单位名称
    * 
    * @pdOid a2e498f4-a847-4703-8388-5d21ed808237 */
   public String unit_name;
   /** 安置时间
    * 
    * @pdOid be48d0ce-9528-45fb-b174-b960b61c72a5 */
   public java.util.Date placement_date;
   /** 安置结束原因
    * 
    * @pdOid 2718eb93-fec2-4137-9452-800d35912f01 */
   public String end_reason;
   /** 安置结束时间
    * 
    * @pdOid fcceb1b4-7817-417f-9280-4fa4e6041c60 */
   public java.util.Date end_time;
   /** 填表人
    * 
    * @pdOid 4bf551a2-3bd5-405e-bfee-2b9fdaa67698 */
   public String preparer;
   /** 填表单位
    * 
    * @pdOid 1cae756d-9167-4ea3-ae64-d6d102fbc055 */
   public String filling_unit;
   /** 填表人联系电话
    * 
    * @pdOid 3b1a8cf6-3b60-4cb9-9a78-5913bd1f8e24 */
   public String preparer_tel;
   /** 填表审核人
    * 
    * @pdOid 7bed9dcc-e4fb-41ed-9a95-78c679eb186c */
   public String filling_auditor;
   /** 录入单位
    * 
    * @pdOid cf5bad47-ff21-41c1-8877-f26e63c16741 */
   public String entry_unit;
   /** 录入人
    * 
    * @pdOid eab29b4f-7650-4d0f-a84e-8ab0496400be */
   public String input_person;
   /** 录入日期
    * 
    * @pdOid f35af1f4-5729-43e1-b98a-cb10f517b321 */
   public java.util.Date input_date;
   /** 管控单位
    * 
    * @pdOid 988af329-fe8a-4424-913d-b673ef4e2960 */
   public String control_unit;
   /** 是否办理失业登记
    * 
    * @pdOid f92a47ad-944e-4cc7-869d-df91a47f49b6 */
   public String if_handle;
   /** 是否参加职业技能培训
    * 
    * @pdOid 1d1d61b1-35ad-4188-82a3-775392fa5edc */
   public String if_join;
   /** 职业资格
    * 
    * @pdOid d926e6c2-6eef-4480-95f6-8c3e73f488ac */
   public String qualification;
   /** 就业安置单位工商注册或民政登记号
    * 
    * @pdOid fc29363d-9051-4427-bf2b-b1e3cd4969e0 */
   public String number;
   /** 就业安置单位法人代表
    * 
    * @pdOid fb7dbd13-967a-4b40-a5ec-8cd3b1826712 */
   public String legal;
   /** 安置规模
    * 
    * @pdOid a03a5ead-ccf9-41a8-b41c-a2aa83dfe621 */
   public String scale;
   /** 参加社会保险类型
    * 
    * @pdOid 5adfa915-5ab0-4db7-8ff3-b6dc5bfd2965 */
   public String insurance_type;
   /** 享受社会救助类型
    * 
    * @pdOid 9eacaaa9-69e7-4eca-8247-adc2a2f43390 */
   public String assistanceType;
   /** 备注
    * 
    * @pdOid 8a2355f6-b518-470d-8a74-e3b0c3e97ac0 */
   public String remarks;

}