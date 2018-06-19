package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  forum.java
 * Author:  Administrator
 * Purpose: Defines the Class forum
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/** 论坛
 * 
 * @pdOid 70521700-8cc3-4400-bf68-3ce4ea329138 */
@Document(collection = "forum")
@Data
public class Forum {
   /** 论坛信息id
    * 
    * @pdOid b902b1ed-621d-4e62-9f1f-76e44d06df4a */
   @Id
   private String id;
   /** 地址
    * 
    * @pdOid 61574823-bd01-419b-abf6-03f6ab9484a5 */
   private String address;
   /** 名称
    * 
    * @pdOid 18de1d5a-f6fc-4092-8741-7734695d3e7d */
   private String name;
   /** 手机号
    * 
    * @pdOid 73394e8d-5435-43ca-b2e0-efbdc2e317e8 */
   private String mobile;

}