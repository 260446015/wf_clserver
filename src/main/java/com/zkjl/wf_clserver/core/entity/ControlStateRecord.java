package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  control_state_record.java
 * Author:  Administrator
 * Purpose: Defines the Class control_state_record
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

/** 管控状态记录
 * 
 * @pdOid c91db628-96fc-4a33-b46e-7de5bb7438a4 */
@Document(collection = "control_state_record")
@Data
public class ControlStateRecord {
   /** 管控状态记录id
    * 
    * @pdOid c86e9242-02e2-4b1c-a1d4-747137fa9d5d */
   @Id
   private String id;
   /** 证件号码
    * 
    * @pdOid 84cfb071-9b42-4932-b08c-1c776391a118 */
   @Field(value = "id_card")
   private String idCard;
   /** 管控状态
    * 
    * @pdOid 8ea567f8-943b-493a-bb8c-212b44efa568 */
   private String state;
   /** 管控记录
    * 
    * @pdOid cbd9e923-ed28-43ef-abf3-f71bd8ac4753 */
   private String record;
   /** 管控地区
    * 
    * @pdOid 99e3b1b3-0421-4229-84c1-fefe1999b4f6 */
   private String area;
   /** 管控单位详称
    * 
    * @pdOid dfb892a6-6270-490a-bf7b-08cdad77996a */
   @Field(value = "unit_detail_name")
   private String unitDetailName;
   /** 开始日期
    * 
    * @pdOid 6733297a-9379-4801-84d4-777ce7f25607 */
   @Field(value = "begin_date")
   private Date beginDate;
   /** 更新时间
    * 
    * @pdOid c709dd90-ec28-4e0c-8b8a-5bae762bb4eb */
   @Field(value = "update_date")
   private Date updateDate;
   /** 后续管控环节
    * 
    * @pdOid 810d4428-3638-46b2-ac44-3419e8680ed6 */
   @Field(value = "follow_up_link")
   private String followUpLink;
   /** 后续接管单位
    * 
    * @pdOid fdb3ac21-c918-4018-b6e7-6fec2816a87f */
   @Field(value = "follow_up_unit")
   private String follow_up_unit;

}