package com.zkjl.wf_clserver.core.entity;

import com.alibaba.fastjson.JSONObject;
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
   /** 用户名
    *
    */
   private String username;
   /** 密码
    * 
    */
   private String password;

   /** 密码
    *
    */
   private String repassword;
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
   /**
    * 是否删除
    */
   @Field(value = "del_flag")
   private String delFlag;

   /**
    * 是否启用
    */
   @Field(value = "if_enable")
   private Boolean ifEnable;

   /**
    *是否系统管理员
    */
   @Field(value = "if_admin")
   private Boolean ifAdmin;

   /**
    *用户角色
    * 1:表示一般用户，2：表示负责上传角色
    */
   @Field(value = "role")
   private String role;

   @Override
   public String toString() {
      return JSONObject.toJSONString(this);
   }
}