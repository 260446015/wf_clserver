/***********************************************************************
 * Module:  floating_population_infor.java
 * Author:  Administrator
 * Purpose: Defines the Class floating_population_infor
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

/** 流动人口信息表
 * 
 * @pdOid 700c6326-9a63-430c-ba42-2be30d47fc4a */
@Document(collection = "floating_population_infor")
@Data
public class FloatingPopulationInfor {
   /** 流动人口信息id
    * 
    * @pdOid 228bc69c-42d0-4638-abb1-2745fa11ed0e */
   @Id
   private String id;
   /** 身份证号码
    * 
    * @pdOid c45696ae-8a1d-4153-821e-a30182b92902 */
   @Field(value = "id_card")
   private String idCard;
   /** 姓名
    * 
    * @pdOid d619bd24-b55b-4542-ac5a-046c9dba784f */
   private String name;
   /** 性別
    * 
    * @pdOid df108d93-c9b3-4160-8d3b-61d7c89238e7 */
   private String sex;
   /** 出生日期
    * 
    * @pdOid 52754593-6878-4b22-bce0-7834b19f094d */
   private java.util.Date birth;
   /** 联系方式
    * 
    * @pdOid 7c7c598a-c2e7-4089-b1a0-1da801e1dc5a */
   private String contact;
   /** 学历
    * 
    * @pdOid 93e27839-0e64-4cd4-9272-d061c313ef84 */
   private String edu;
   /** 政治面貌
    * 
    * @pdOid b1c9dc4c-8a7a-42f0-9f09-b342aea3a74e */
   @Field(value = "political_outlook")
   private String politicalOutlook;
   /** 婚姻状况
    * 
    * @pdOid 6b6c015f-1040-4f52-8ade-7578da181cae */
   @Field(value = "marital_status")
   private String maritalStatus;
   /** 常住户口所在地住址
    * 
    * @pdOid 27420484-3a5c-4c64-b630-3467194f8572 */
   @Field(value = "registered_location")
   private String registeredLocation;
   /** 户籍地行政区划
    * 
    * @pdOid 0d1f5df2-2f09-4fab-96b3-4a9df7fc104a */
   @Field(value = "domicile_area")
   private String domicileArea;
   /** （户籍民警）受理时间
    * 
    * @pdOid 79d7d662-23ab-4f5c-8306-5cde7c163350 */
   @Field(value = "processing_time")
   private java.util.Date processingTime;
   /** 户籍民警审核时间
    * 
    * @pdOid a40d1ab8-9de1-4562-80e1-dcb344e25fe1 */
   @Field(value = "audit_time")
   private java.util.Date auditTime;
   /** 住宿类别
    * 
    * @pdOid 0e77e1cd-71ad-4d7a-95aa-24e199cabbb7 */
   @Field(value = "lodging_category")
   private String lodgingCategory;
   /** 居住事由
    * 
    * @pdOid 00c35f5e-e57b-4cad-be0c-96042d6735ca */
   @Field(value = "live_cause")
   private String liveCause;
   /** 现居住地住址
    * 
    * @pdOid 78fa938a-4f33-4106-a214-c70adb414908 */
   @Field(value = "local_address")
   private String localAddress;
   /** 现住址详情
    * 
    * @pdOid 0c318108-2a6a-4ebd-a1ec-bf8493d835b4 */
   @Field(value = "local_address_detail")
   private String localAddressDetail;
   /** 现住地行政区划
    * 
    * @pdOid 997b645d-5888-46d6-968d-df2db7482ba0 */
   @Field(value = "address_area")
   private String addressArea;
   /** 是否申领居住证
    * 
    * @pdOid c7d7aba8-56c3-4fe6-bf70-930eb0881452 */
   @Field(value = "if_apply_paper")
   private String ifApplyPaper;
   /** 拟居住期限
    * 
    * @pdOid 1742601a-f5aa-445f-93d1-bca64af5a798 */
   @Field(value = "live_time")
   private String liveTime;
   /** 是否参加工作
    * 
    * @pdOid 341b9444-7070-40df-a99f-39e5862a58ee */
   @Field(value = "if_work")
   private String ifWork;
   /** 工作单位
    * 
    * @pdOid 1982de3d-717c-49af-97ff-4799e3434063 */
   private String workpalce;
   /** 单位负责人
    * 
    * @pdOid 06f56f11-a092-4374-963e-717253af250c */
   @Field(value = "firm_leader")
   private String firmLeader;
   /** 单位负责人联系电话
    * 
    * @pdOid 608b2fe8-fe07-4f35-8020-ebfef2663bcb */
   @Field(value = "firm_learder_phone")
   private String firmLearderPhone;
   /** 单位地址
    * 
    * @pdOid 24941a7a-8a82-435e-8096-e65c140425fe */
   @Field(value = "firm_address")
   private String firmAddress;
   /** 到达本地日期
    * 
    * @pdOid a47f18d7-4442-4653-80c6-78e04f4188ca */
   @Field(value = "ariv_date")
   private java.util.Date arivDate;
   /** 公安机关
    * 
    * @pdOid 7bb64990-f0cb-4acf-b099-2b12ac85eb3b */
   private String police;
   /** 审核单位
    * 
    * @pdOid 3a35d8ae-009d-4bb5-bc0f-6c6e6fe9358d */
   @Field(value = "auditing_depart")
   private String auditingDepart;
   /** 审核人
    * 
    * @pdOid 12aa1a9e-53d7-4326-a8e3-9027967e5546 */
   private String auditor;
   /** 验证时间
    * 
    * @pdOid 15651c7d-8f02-4f09-8554-6c41af95f44c */
   @Field(value = "vertification_time")
   private java.util.Date vertificationTime;
   /** 最后修改时间
    * 
    * @pdOid c9c70402-c090-4628-a443-f56d8f397ac5 */
   @Field(value = "last_edit_time")
   private java.util.Date lastEditTime;
   /** 入库时间
    * 
    * @pdOid 23cee574-556a-44ea-9b3c-f909afe947fd */
   @Field(value = "enter_time")
   private java.util.Date enterTime;
   /** 更新日期
    * 
    * @pdOid 341a5dc4-64d2-4bfd-8a07-a3cb307d32cf */
   @Field(value = "update_time")
   private java.util.Date updateTime;
   /** 是否采取节育措施
    * 
    * @pdOid 718c6689-349d-48c8-bea6-5e084e2bee09 */
   @Field(value = "if_birth_control")
   private String ifBirthControl;
   /** 是否生育
    * 
    * @pdOid 6a7e62b1-62c3-4fae-9b72-4ca79251d564 */
   @Field(value = "if_birth")
   private String ifBirth;
   /** 注销标志
    * 
    * @pdOid ede30f83-8e61-4089-a119-280e4f3ca86b */
   @Field(value = "deregistration_mark")
   private String deregistrationMark;
   /** 填报人姓名
    * 
    * @pdOid aa512048-b3b0-4b72-a1e4-e3ded31594d3 */
   private String applier;
   /** 制证标志
    * 
    * @pdOid d6439838-8e40-4629-93b9-3607078d4f2f */
   @Field(value = "sign_marking")
   private String signMarking;
   /** 数据有效性
    * 
    * @pdOid 089228f3-30dd-4448-bbe0-eab0250050b3 */
   @Field(value = "data_efficient")
   private String dataEfficient;
   /** 是否允许制证
    * 
    * @pdOid d12bd81b-79f5-4a7e-947e-c40eac5ea10d */
   @Field(value = "if_permit_certification")
   private String ifPermitCertification;
   /** 审批状态
    * 
    * @pdOid 790e2900-0e01-4827-8368-7461400ad4bd */
   @Field(value = "approval_state")
   private String approvalState;
   /** 自动生成的编码
    * 
    * @pdOid 39623229-6096-41ac-91ef-074370606954 */
   @Field(value = "auto_coding")
   private String autoCoding;
   /** 填报时间
    * 
    * @pdOid 7b955f03-6653-4a4a-bc2b-459d5c39934b */
   @Field(value = "apply_time")
   private java.util.Date applyTime;
   /** （社区民警）是否漏审
    * 
    * @pdOid d7f67523-42a0-4244-84b0-4e9b9228cc6d */
   @Field(value = "if_ignore")
   private String ifIgnore;

}