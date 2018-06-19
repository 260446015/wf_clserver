/***********************************************************************
 * Module:  job_placement_record.java
 * Author:  Administrator
 * Purpose: Defines the Class job_placement_record
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

/** 就业安置记录
 * 
 * @pdOid 9d41161f-7808-4ab6-981c-368d05d6ffa8 */
@Document(collection = "job_placement_record")
@Data
public class JobPlacementRecord {
   /** 就业安置记录id
    * 
    * @pdOid ea4f27b9-acc9-435a-9281-cb5565c240a0 */
   @Id
   private String id;
   /** 安置人证件号码
    * 
    * @pdOid 083e6283-f47d-4834-8d42-7a89d31a203b */
   @Field(value = "id_card")
   private String idCard;
   /** 安置类型
    * 
    * @pdOid 4f6e6417-4df4-447c-b685-ca55b2dd7096 */
   @Field(value = "placement_type")
   private String placementType;
   /** 就业安置地区
    * 
    * @pdOid 0cdc4dcb-5109-4e2d-9ce2-e83f1077485d */
   @Field(value = "job_area")
   private String jobArea;
   /** 从业状况
    * 
    * @pdOid 67c296e3-81ce-42c0-b5d7-fd5b5342711d */
   @Field(value = "job_situation")
   private String jobSituation;
   /** 是否纳入低保
    * 
    * @pdOid e618aba6-f643-48f3-8d99-df84791381ee */
   @Field(value = "if_low_insurance")
   private String ifLowInsurance;
   /** 安置单位名称
    * 
    * @pdOid a2e498f4-a847-4703-8388-5d21ed808237 */
   @Field(value = "unit_name")
   private String unitName;
   /** 安置时间
    * 
    * @pdOid be48d0ce-9528-45fb-b174-b960b61c72a5 */
   @Field(value = "placement_date")
   private java.util.Date placementDate;
   /** 安置结束原因
    * 
    * @pdOid 2718eb93-fec2-4137-9452-800d35912f01 */
   @Field(value = "end_reason")
   private String endReason;
   /** 安置结束时间
    * 
    * @pdOid fcceb1b4-7817-417f-9280-4fa4e6041c60 */
   @Field(value = "end_time")
   private java.util.Date endTime;
   /** 填表人
    * 
    * @pdOid 4bf551a2-3bd5-405e-bfee-2b9fdaa67698 */
   private String preparer;
   /** 填表单位
    * 
    * @pdOid 1cae756d-9167-4ea3-ae64-d6d102fbc055 */
   @Field(value = "filling_unit")
   private String fillingUnit;
   /** 填表人联系电话
    * 
    * @pdOid 3b1a8cf6-3b60-4cb9-9a78-5913bd1f8e24 */
   @Field(value = "preparer_tel")
   private String preparerTel;
   /** 填表审核人
    * 
    * @pdOid 7bed9dcc-e4fb-41ed-9a95-78c679eb186c */
   @Field(value = "filling_auditor")
   private String fillingAuditor;
   /** 录入单位
    * 
    * @pdOid cf5bad47-ff21-41c1-8877-f26e63c16741 */
   @Field(value = "entry_unit")
   private String entryUnit;
   /** 录入人
    * 
    * @pdOid eab29b4f-7650-4d0f-a84e-8ab0496400be */
   @Field(value = "input_person")
   private String inputPerson;
   /** 录入日期
    * 
    * @pdOid f35af1f4-5729-43e1-b98a-cb10f517b321 */
   @Field(value = "input_date")
   private java.util.Date inputDate;
   /** 管控单位
    * 
    * @pdOid 988af329-fe8a-4424-913d-b673ef4e2960 */
   @Field(value = "control_unit")
   private String controlUnit;
   /** 是否办理失业登记
    * 
    * @pdOid f92a47ad-944e-4cc7-869d-df91a47f49b6 */
   @Field(value = "if_handle")
   private String ifHandle;
   /** 是否参加职业技能培训
    * 
    * @pdOid 1d1d61b1-35ad-4188-82a3-775392fa5edc */
   @Field(value = "if_join")
   private String ifJoin;
   /** 职业资格
    * 
    * @pdOid d926e6c2-6eef-4480-95f6-8c3e73f488ac */
   private String qualification;
   /** 就业安置单位工商注册或民政登记号
    * 
    * @pdOid fc29363d-9051-4427-bf2b-b1e3cd4969e0 */
   private String number;
   /** 就业安置单位法人代表
    * 
    * @pdOid fb7dbd13-967a-4b40-a5ec-8cd3b1826712 */
   private String legal;
   /** 安置规模
    * 
    * @pdOid a03a5ead-ccf9-41a8-b41c-a2aa83dfe621 */
   private String scale;
   /** 参加社会保险类型
    * 
    * @pdOid 5adfa915-5ab0-4db7-8ff3-b6dc5bfd2965 */
   @Field(value = "insurance_type")
   private String insuranceType;
   /** 享受社会救助类型
    * 
    * @pdOid 9eacaaa9-69e7-4eca-8247-adc2a2f43390 */
   @Field(value = "assistance_type")
   private String assistanceType;
   /** 备注
    * 
    * @pdOid 8a2355f6-b518-470d-8a74-e3b0c3e97ac0 */
   private String remarks;

}