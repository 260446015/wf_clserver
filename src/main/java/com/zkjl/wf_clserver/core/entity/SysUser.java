package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 系统用户表
 * 
 */
@Data
@Document(collection="sys_user")
public class SysUser {
   /** 用户id
    * 
    */
   @Id
   private String id;
   /** 姓名
    * 
    */
   private String name;
   /** 密码
    * 
    */
   private String password;
   /** 头像
    * 
    */
   private String photo;
   /** 警号
    * 
    */
   @Field(value = "police_number")
   private String policeNumber;
   /** 职位
    * 
    */
   private String job;
   /** 所属部门
    * 
    */
   private String department;
   /** 电话
    * 
    */
   private String phone;
   /** 邮箱
    * 
    */
   private String email;
   /** QQ
    * 
    */
   private String qq;
   /** 创建时间
    * 
    */
   @Field(value = "create_date")
   private Date createDate;
   /** 更新时间
    * 
    */
   @Field(value = "update_date")
   private Date updateDate;
   /** 是否删除
    * 
    */
   @Field(value = "del_flag")
   private String delFlag;

}