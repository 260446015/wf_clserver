package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  Link.java
 * Author:  Administrator
 * Purpose: Defines the Class Link
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 链接表
 * 
 */
@Document(collection = "link")
@Data
public class Link {
   /** 链接主键id
    * 
    */
   @Id
   public String id;
   /** 链接名称
    * 
    */
   public String name;
   /** 链接类型
    * 
    */
   public String category;
   /** 链接地址
    * 
    */
   public String url;
   /** 发布时间
    * 
    */
   @Field(value = "publish_date")
   public Date publishDate;
   /** 是否启用
    * 
    */
   @Field(value = "if_open")
   public String ifOpen;
   /** logo图标
    * 
    */
   public String logo;
   /** 备注
    * 
    */
   public String remark;
   /** 创建时间
    * 
    */
   @Field(value = "create_date")
   public Date createDate;
   /** 更新时间
    * 
    */
   @Field(value = "update_date")
   public Date updateDate;
   /** 是否删除
    * 
    */
   @Field(value = "del_flag")
   public String delFlag;

}