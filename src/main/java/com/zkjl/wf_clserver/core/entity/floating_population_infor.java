/***********************************************************************
 * Module:  floating_population_infor.java
 * Author:  Administrator
 * Purpose: Defines the Class floating_population_infor
 ***********************************************************************/

import java.util.*;

/** 流动人口信息表
 * 
 * @pdOid 700c6326-9a63-430c-ba42-2be30d47fc4a */
public class floating_population_infor {
   /** 流动人口信息id
    * 
    * @pdOid 228bc69c-42d0-4638-abb1-2745fa11ed0e */
   public java.lang.String id;
   /** 身份证号码
    * 
    * @pdOid c45696ae-8a1d-4153-821e-a30182b92902 */
   public java.lang.String id_card;
   /** 姓名
    * 
    * @pdOid d619bd24-b55b-4542-ac5a-046c9dba784f */
   public java.lang.String name;
   /** 性別
    * 
    * @pdOid df108d93-c9b3-4160-8d3b-61d7c89238e7 */
   public java.lang.String sex;
   /** 出生日期
    * 
    * @pdOid 52754593-6878-4b22-bce0-7834b19f094d */
   public java.util.Date birth;
   /** 联系方式
    * 
    * @pdOid 7c7c598a-c2e7-4089-b1a0-1da801e1dc5a */
   public java.lang.String contact;
   /** 学历
    * 
    * @pdOid 93e27839-0e64-4cd4-9272-d061c313ef84 */
   public java.lang.String edu;
   /** 政治面貌
    * 
    * @pdOid b1c9dc4c-8a7a-42f0-9f09-b342aea3a74e */
   public java.lang.String political_outlook;
   /** 婚姻状况
    * 
    * @pdOid 6b6c015f-1040-4f52-8ade-7578da181cae */
   public java.lang.String marital_status;
   /** 常住户口所在地住址
    * 
    * @pdOid 27420484-3a5c-4c64-b630-3467194f8572 */
   public java.lang.String registered_location;
   /** 户籍地行政区划
    * 
    * @pdOid 0d1f5df2-2f09-4fab-96b3-4a9df7fc104a */
   public java.lang.String domicile_area;
   /** （户籍民警）受理时间
    * 
    * @pdOid 79d7d662-23ab-4f5c-8306-5cde7c163350 */
   public java.util.Date processing_time;
   /** 户籍民警审核时间
    * 
    * @pdOid a40d1ab8-9de1-4562-80e1-dcb344e25fe1 */
   public java.util.Date audit_time;
   /** 住宿类别
    * 
    * @pdOid 0e77e1cd-71ad-4d7a-95aa-24e199cabbb7 */
   public java.lang.String lodging_category;
   /** 居住事由
    * 
    * @pdOid 00c35f5e-e57b-4cad-be0c-96042d6735ca */
   public java.lang.String live_cause;
   /** 现居住地住址
    * 
    * @pdOid 78fa938a-4f33-4106-a214-c70adb414908 */
   public java.lang.String local_address;
   /** 现住址详情
    * 
    * @pdOid 0c318108-2a6a-4ebd-a1ec-bf8493d835b4 */
   public java.lang.String local_address_detail;
   /** 现住地行政区划
    * 
    * @pdOid 997b645d-5888-46d6-968d-df2db7482ba0 */
   public java.lang.String address_area;
   /** 是否申领居住证
    * 
    * @pdOid c7d7aba8-56c3-4fe6-bf70-930eb0881452 */
   public java.lang.String if_apply_paper;
   /** 拟居住期限
    * 
    * @pdOid 1742601a-f5aa-445f-93d1-bca64af5a798 */
   public java.lang.String live_time;
   /** 是否参加工作
    * 
    * @pdOid 341b9444-7070-40df-a99f-39e5862a58ee */
   public java.lang.String if_work;
   /** 工作单位
    * 
    * @pdOid 1982de3d-717c-49af-97ff-4799e3434063 */
   public java.lang.String workpalce;
   /** 单位负责人
    * 
    * @pdOid 06f56f11-a092-4374-963e-717253af250c */
   public java.lang.String firm_leader;
   /** 单位负责人联系电话
    * 
    * @pdOid 608b2fe8-fe07-4f35-8020-ebfef2663bcb */
   public java.lang.String firm_learder_phone;
   /** 单位地址
    * 
    * @pdOid 24941a7a-8a82-435e-8096-e65c140425fe */
   public java.lang.String firm_address;
   /** 到达本地日期
    * 
    * @pdOid a47f18d7-4442-4653-80c6-78e04f4188ca */
   public java.util.Date ariv_date;
   /** 公安机关
    * 
    * @pdOid 7bb64990-f0cb-4acf-b099-2b12ac85eb3b */
   public java.lang.String police;
   /** 审核单位
    * 
    * @pdOid 3a35d8ae-009d-4bb5-bc0f-6c6e6fe9358d */
   public java.lang.String auditing_depart;
   /** 审核人
    * 
    * @pdOid 12aa1a9e-53d7-4326-a8e3-9027967e5546 */
   public java.lang.String auditor;
   /** 验证时间
    * 
    * @pdOid 15651c7d-8f02-4f09-8554-6c41af95f44c */
   public java.util.Date vertification_time;
   /** 最后修改时间
    * 
    * @pdOid c9c70402-c090-4628-a443-f56d8f397ac5 */
   public java.util.Date last_edit_time;
   /** 入库时间
    * 
    * @pdOid 23cee574-556a-44ea-9b3c-f909afe947fd */
   public java.util.Date enter_time;
   /** 更新日期
    * 
    * @pdOid 341a5dc4-64d2-4bfd-8a07-a3cb307d32cf */
   public java.util.Date update_time;
   /** 是否采取节育措施
    * 
    * @pdOid 718c6689-349d-48c8-bea6-5e084e2bee09 */
   public java.lang.String if_birth_control;
   /** 是否生育
    * 
    * @pdOid 6a7e62b1-62c3-4fae-9b72-4ca79251d564 */
   public java.lang.String if_birth;
   /** 注销标志
    * 
    * @pdOid ede30f83-8e61-4089-a119-280e4f3ca86b */
   public java.lang.String deregistration_mark;
   /** 填报人姓名
    * 
    * @pdOid aa512048-b3b0-4b72-a1e4-e3ded31594d3 */
   public java.lang.String applier;
   /** 制证标志
    * 
    * @pdOid d6439838-8e40-4629-93b9-3607078d4f2f */
   public java.lang.String sign_marking;
   /** 数据有效性
    * 
    * @pdOid 089228f3-30dd-4448-bbe0-eab0250050b3 */
   public java.lang.String data_efficient;
   /** 是否允许制证
    * 
    * @pdOid d12bd81b-79f5-4a7e-947e-c40eac5ea10d */
   public java.lang.String if_permit_certification;
   /** 审批状态
    * 
    * @pdOid 790e2900-0e01-4827-8368-7461400ad4bd */
   public java.lang.String approval_state;
   /** 自动生成的编码
    * 
    * @pdOid 39623229-6096-41ac-91ef-074370606954 */
   public java.lang.String auto_coding;
   /** 填报时间
    * 
    * @pdOid 7b955f03-6653-4a4a-bc2b-459d5c39934b */
   public java.util.Date apply_time;
   /** （社区民警）是否漏审
    * 
    * @pdOid d7f67523-42a0-4244-84b0-4e9b9228cc6d */
   public java.lang.String if_ignore;

}