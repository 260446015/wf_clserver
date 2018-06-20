package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 最新证件信息
 * 
 */
@Document(collection = "new_paper_info")
@Data
public class NewPaperInfo {
   /** 最新证件信息id
    * 
    */
   @Id
   private String id;
   /** 居民身份证受理号
    * 
    */
   @Field(value = "identity_card_number")
   private String identityCardNumber;
   /** 公民身份号码
    * 
    */
   @Field(value = "id_card")
   private String idCard;
   /** 姓名
    * 
    */
   private String name;
   /** 头像
    * 
    */
   private String avatar;
   /** 性别
    * 
    */
   private String sex;
   /** 民族
    * 
    */
   private String nation;
   /** 出生日期
    * 
    */
   private Date birth;
   /** 签发机关
    * 
    */
   private String organization;
   /** 所属省市县
    * 
    */
   private String area;
   /** 户籍地址
    * 
    */
   private String address;
   /** 有效期限起始日期
    * 
    */
   @Field(value = "begin_date")
   private Date beginDate;
   /** 申领原因
    * 
    */
   private String reason;
   /** 有效期截止时间
    * 
    */
   @Field(value = "end_date")
   private Date endDate;
   /** 制证类型
    * 
    */
   private String type;
   /** 领证方式
    * 
    */
   private String mode;
   /** 制证数据类型
    * 
    */
   @Field(value = "data_type")
   private String dataType;
   /** 联系电话
    * 
    */
   private String phone;
   /** 收件人姓名
    * 
    */
   @Field(value = "recipient_name")
   private String recipientName;
   /** 收件人联系电话
    * 
    */
   @Field(value = "recipient_phone")
   private String recipientPhone;
   /** 收件人邮政编码
    * 
    */
   @Field(value = "recipient_zipcode")
   private String recipientZipcode;
   /** 收件人通讯地址
    * 
    */
   @Field(value = "recipient_postal_address")
   private String recipientPostalAddress;
   /** 单位代码
    * 
    */
   @Field(value = "unit_code")
   private String unitCode;
   /** 受理单位公安机关代码
    * 
    */
   @Field(value = "police_code")
   private String policeCode;
   /** 受理单位公安机关名称
    * 
    */
   @Field(value = "police_name")
   private String policeName;
   /** 受理人姓名
    * 
    */
   private String acceptancer;
   /** 受理时间
    * 
    */
   @Field(value = "admissibility_time")
   private Date admissibilityTime;
   /** 数据归属单位代码
    * 
    */
   @Field(value = "home_unit_code")
   private String homeUnitCode;
   /** 数据归属单位名称
    * 
    */
   @Field(value = "home_unit_name")
   private String homeUnitName;

}