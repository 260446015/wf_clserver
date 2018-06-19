package com.zkjl.wf_clserver.core.entity; /***********************************************************************
 * Module:  Stay.java
 * Author:  Administrator
 * Purpose: Defines the Class Stay
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/** 住宿
 * 
 */
@Document(collection = "stay")
@Data
public class Stay {
   /** 住宿信息id
    * 
    */
   @Id
   private String id;
   /** 人住人身份证号
    * 
    */
   @Field(value = "id_card")
   private String idCard;
   /** 入住时间
    * 
    */
   @Field(value = "check_in_time")
   private Date checkInTime;
   /** 离开时间
    * 
    */
   @Field(value = "leave_time")
   private Date leaveTime;
   /** 所属地
    * 
    */
   private String local;
   /** 宾馆名称
    * 
    */
   @Field(value = "hotel_name")
   private String hotelName;
   /** 房间号
    * 
    */
   @Field(value = "room_number")
   private String roomNumber;

}