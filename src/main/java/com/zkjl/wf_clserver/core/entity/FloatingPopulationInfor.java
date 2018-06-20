package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** 流动人口信息表
 * 
 * */
@Document(collection = "floating_population_infor")
@Data
public class FloatingPopulationInfor {
   /** 流动人口信息id
    * 
    * */
   @Id
   private String id;
   /** 身份证号码
    * 
    * */
   @Field(value = "id_card")
   private String idCard;
   /** 姓名
    * 
    * */
   private String name;
   /** 性別
    * 
    * */
   private String sex;
   /** 出生日期
    * 
    * */
   private java.util.Date birth;
   /** 联系方式
    * 
    * */
   private String contact;
   /** 学历
    * 
    * */
   private String edu;
   /** 政治面貌
    * 
    * */
   @Field(value = "political_outlook")
   private String politicalOutlook;
   /** 婚姻状况
    * 
    * */
   @Field(value = "marital_status")
   private String maritalStatus;
   /** 常住户口所在地住址
    * 
    * */
   @Field(value = "registered_location")
   private String registeredLocation;
   /** 户籍地行政区划
    * 
    * */
   @Field(value = "domicile_area")
   private String domicileArea;
   /** （户籍民警）受理时间
    * 
    * */
   @Field(value = "processing_time")
   private java.util.Date processingTime;
   /** 户籍民警审核时间
    * 
    * */
   @Field(value = "audit_time")
   private java.util.Date auditTime;
   /** 住宿类别
    * 
    * */
   @Field(value = "lodging_category")
   private String lodgingCategory;
   /** 居住事由
    * 
    * */
   @Field(value = "live_cause")
   private String liveCause;
   /** 现居住地住址
    * 
    * */
   @Field(value = "local_address")
   private String localAddress;
   /** 现住址详情
    * 
    * */
   @Field(value = "local_address_detail")
   private String localAddressDetail;
   /** 现住地行政区划
    * 
    * */
   @Field(value = "address_area")
   private String addressArea;
   /** 是否申领居住证
    * 
    * */
   @Field(value = "if_apply_paper")
   private String ifApplyPaper;
   /** 拟居住期限
    * 
    * */
   @Field(value = "live_time")
   private String liveTime;
   /** 是否参加工作
    * 
    * */
   @Field(value = "if_work")
   private String ifWork;
   /** 工作单位
    * 
    * */
   private String workpalce;
   /** 单位负责人
    * 
    * */
   @Field(value = "firm_leader")
   private String firmLeader;
   /** 单位负责人联系电话
    * 
    * */
   @Field(value = "firm_learder_phone")
   private String firmLearderPhone;
   /** 单位地址
    * 
    * */
   @Field(value = "firm_address")
   private String firmAddress;
   /** 到达本地日期
    * 
    * */
   @Field(value = "ariv_date")
   private java.util.Date arivDate;
   /** 公安机关
    * 
    * */
   private String police;
   /** 审核单位
    * 
    * */
   @Field(value = "auditing_depart")
   private String auditingDepart;
   /** 审核人
    * 
    * */
   private String auditor;
   /** 验证时间
    * 
    * */
   @Field(value = "vertification_time")
   private java.util.Date vertificationTime;
   /** 最后修改时间
    * 
    * */
   @Field(value = "last_edit_time")
   private java.util.Date lastEditTime;
   /** 入库时间
    * 
    * */
   @Field(value = "enter_time")
   private java.util.Date enterTime;
   /** 更新日期
    * 
    * */
   @Field(value = "update_time")
   private java.util.Date updateTime;
   /** 是否采取节育措施
    * 
    * */
   @Field(value = "if_birth_control")
   private String ifBirthControl;
   /** 是否生育
    * 
    * */
   @Field(value = "if_birth")
   private String ifBirth;
   /** 注销标志
    * 
    * */
   @Field(value = "deregistration_mark")
   private String deregistrationMark;
   /** 填报人姓名
    * 
    * */
   private String applier;
   /** 制证标志
    * 
    * */
   @Field(value = "sign_marking")
   private String signMarking;
   /** 数据有效性
    * 
    * */
   @Field(value = "data_efficient")
   private String dataEfficient;
   /** 是否允许制证
    * 
    * */
   @Field(value = "if_permit_certification")
   private String ifPermitCertification;
   /** 审批状态
    * 
    * */
   @Field(value = "approval_state")
   private String approvalState;
   /** 自动生成的编码
    * 
    * */
   @Field(value = "auto_coding")
   private String autoCoding;
   /** 填报时间
    * 
    * */
   @Field(value = "apply_time")
   private java.util.Date applyTime;
   /** （社区民警）是否漏审
    * 
    * */
   @Field(value = "if_ignore")
   private String ifIgnore;

}