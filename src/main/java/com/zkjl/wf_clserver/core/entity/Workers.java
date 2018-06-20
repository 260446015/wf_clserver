package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 职工表
 */
@Document(collection="workers")
@Data
public class Workers {
   /**
    * 职工信息id
    */
   @Id
   private String id;
   /** 身份证号
    * 
    */
   @Field(value = "id_card")
   private String idCard;
   /**
    * 工作单位
    */
   @Field(value = "workplace")
   private String workplace;
   /** 职位
    *
    */
   @Field(value = "job")
   private String job;

}