package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** QQ
 * 
 */
@Document(collection = "qq")
@Data
public class Qq {
   /** qq信息id
    * 
    */
   private String id;
   /** 手机号码
    * 
    */
   private String mobile;
   /** qq号码
    * 
    */
   @Field(value = "qq_number")
   private String qqNumber;

}