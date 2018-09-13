package com.zkjl.wf_clserver.core.entity;

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
   private String id;
   /** 链接名称
    * 
    */
   private String name;
   /** 链接类型
    * 
    */
   private String category;
   /** 链接地址
    * 
    */
   private String url;
   /**
    * 类型
    */
   @Field(value = "path_type")
   private String pathType;
   /** 发布时间
    *
    */
   @Field(value = "publish_date")
   private String publishDate;
   /** 是否启用
    *  1代表启用，-1代表禁用
    */
   @Field(value = "if_open")
   private int ifOpen;
   /** logo图标
    * 
    */
   private String logo;
   /** 备注
    * 
    */
   private String remark;
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
   /**
    * 点击量
    */
   @Field(value = "hot_count")
   private int hotCount;
   /**
    * 上传人
    */
   private String creator;
   /**
    * 平台分类
    */
   private String linkType;

}