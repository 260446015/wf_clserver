/***********************************************************************
 * Module:  detainees_infor.java
 * Author:  Administrator
 * Purpose: Defines the Class detainees_infor
 ***********************************************************************/

import java.util.*;

/** 拘留人员信息表
 * 
 * @pdOid ca53e3be-dc49-4ea3-922a-90af217c0f3d */
public class detainees_infor {
   /** 拘留人员信息id
    * 
    * @pdOid cb7c9235-08b3-4faa-abbc-36b7a2fb3852 */
   public java.lang.String id;
   /** 证件号
    * 
    * @pdOid 96f59ce2-1190-4c4b-892c-929c3770f717 */
   public java.lang.String id_card;
   /** 姓名
    * 
    * @pdOid e72789c0-79d5-440d-8a51-c0c843ca6268 */
   public java.lang.String name;
   /** 人员编号
    * 
    * @pdOid 48609e33-d4e2-4e12-bc88-72b1998b674d */
   public java.lang.String personnel_number;
   /** 別名
    * 
    * @pdOid a986cd0f-ad4a-4d70-b544-6d8210e7ac90 */
   public java.lang.String nickname;
   /** 性別
    * 
    * @pdOid bba9c90e-c670-472c-993d-8a8076f7e876 */
   public java.lang.String sex;
   /** 出生日期
    * 
    * @pdOid fed5e9ca-c9ed-425f-84cd-a95098a211b9 */
   public java.util.Date birth;
   /** 民族
    * 
    * @pdOid bc6cb60e-0004-45cf-8971-e59c203c12ed */
   public java.lang.String nation;
   /** 婚姻状况
    * 
    * @pdOid 9768dda6-f7d9-469a-9ba6-8fc2d7eaa63c */
   public java.lang.String marital_status;
   /** 籍贯
    * 
    * @pdOid 69f82089-606a-452a-8b87-89e2280ac7d7 */
   public java.lang.String native_place;
   /** 户籍地
    * 
    * @pdOid 0411ff26-3166-4acc-b56e-00c8d1e4cca6 */
   public java.lang.String domicile_place;
   /** 户籍地详址
    * 
    * @pdOid ce635be2-ec8a-442c-9eca-1cf33fe07eaa */
   public java.lang.String domicile_place_address;
   /** 现居地
    * 
    * @pdOid 600a4613-1eca-46ac-9b93-5abc6c0769dd */
   public java.lang.String living_place;
   /** 现居地详址
    * 
    * @pdOid 464f75b3-a598-4c7e-85d0-f55d694fc84a */
   public java.lang.String living_place_address;
   /** 国籍
    * 
    * @pdOid 0f052cc5-3cb8-41de-82ac-297a91c42b1f */
   public java.lang.String nationality;
   /** 文化程度
    * 
    * @pdOid 1d0ea24e-fe1a-4a7a-8b84-cef3e5249916 */
   public java.lang.String edu;
   /** 专长
    * 
    * @pdOid dbce945b-82f6-429d-bc7a-1f5443997301 */
   public java.lang.String specialty;
   /** 政治面貌
    * 
    * @pdOid 662aa49b-20f2-47e5-a09d-0fefa38a92d7 */
   public java.lang.String political_outlook;
   /** 身份
    * 
    * @pdOid e75832c3-ab3e-44a9-af66-8a0eb9a4889c */
   public java.lang.String identity;
   /** 特护身份
    * 
    * @pdOid e821c27c-db1b-4f0f-8bcc-c92ab4f5758d */
   public java.lang.String special_protection;
   /** 职业
    * 
    * @pdOid 3debc61d-d28b-4290-84b3-bc522e2360b0 */
   public java.lang.String job;
   /** 工作单位
    * 
    * @pdOid d019f4d4-51fa-4b4e-8918-d3dd02e3f24f */
   public java.lang.String workplace;
   /** 拘室号
    * 
    * @pdOid 95aa371f-a8b4-4546-80be-cc8228b89160 */
   public java.lang.String room_number;
   /** 收据凭证
    * 
    * @pdOid 115f6e4c-0e72-4514-aad1-5518d34938a9 */
   public java.lang.String receipt;
   /** 入所文书号
    * 
    * @pdOid f5c07d81-c6b5-41ed-b65f-5cbe48e97e9a */
   public java.lang.String text_number;
   /** 入所原因
    * 
    * @pdOid 95825417-2f92-408c-9290-0619f1cfc3c9 */
   public java.lang.String entry
                           _reason;
   /** 主要案由
    * 
    * @pdOid 7f0703c5-fbb1-4582-b4d5-9595bdad6fb0 */
   public java.lang.String main_cause;
   /** 成员类型
    * 
    * @pdOid 05040f46-0df2-4136-93cc-a51a321733fa */
   public java.lang.String member_type;
   /** 从案案由
    * 
    * @pdOid b9dd3b4d-d568-42f6-8dea-2aef08af4c51 */
   public java.lang.String case;
   /** 拘留决定机关
    * 
    * @pdOid 9a4ec100-eb03-4bef-9908-52f9cc370ade */
   public java.lang.String decision
                           _office;
   /** 入所日期
    * 
    * @pdOid 39e0842e-ccc2-4a02-98bf-fc35db31229e */
   public java.util.Date entry_date;
   /** 拘押日期
    * 
    * @pdOid 14fcf236-528f-4a1f-a812-f9a575d78194 */
   public java.util.Date detain
                         _date;
   /** 拘留天数
    * 
    * @pdOid 0ed49210-9d0f-4d89-a678-e952f234362a */
   public int detain_days;
   /** 办案单位
    * 
    * @pdOid f1dec166-9966-48cf-ba0b-b630d6068c15 */
   public java.lang.String handle_unit;
   /** 办案单位类型
    * 
    * @pdOid f6b0d847-2926-4f9c-9f8b-839e510fc8fa */
   public java.lang.String handle_unit_type;
   /** 办案人
    * 
    * @pdOid 0a4557ad-0d29-4d10-a412-41bd1ccaad46 */
   public java.lang.String operator;
   /** 办案人电话
    * 
    * @pdOid 38b5b413-42bb-4e3e-93de-3cbddcaf83e2 */
   public java.lang.String operator_tel;
   /** 裁决书号
    * 
    * @pdOid 56f800bb-2012-4f2c-951d-0d08a841dc5d */
   public java.lang.String rule_book_number;
   /** 口音特点
    * 
    * @pdOid 99c99f2c-2367-403a-b1fe-4c38fa1e1f03 */
   public java.lang.String accent_trait;
   /** 危险等级
    * 
    * @pdOid 7101c269-8d8e-42bd-bd0a-df0ebd0c936c */
   public java.lang.String danger_grade;
   /** 健康状况
    * 
    * @pdOid 5ed36765-9e4e-47e8-8ae6-dfe7d3f24f8b */
   public java.lang.String health;
   /** 犯罪经历
    * 
    * @pdOid e6dfe858-b342-429a-ab39-0cba97b03a54 */
   public java.lang.String criminal_live;
   /** 情况描述
    * 
    * @pdOid 23a971d1-26e1-4525-b603-79ab1dd9386f */
   public java.lang.String situation_describe;
   /** 出所日期
    * 
    * @pdOid ac8f0a58-f9c7-4746-94e4-f264a2fc4793 */
   public java.util.Date out_place_date;
   /** 出所原因
    * 
    * @pdOid 998c6906-2472-4c12-8571-5129e5a3ec1b */
   public java.lang.String out_place_cause;
   /** 出所去向
    * 
    * @pdOid dfe9d0bd-1b17-47c7-ba46-85889bcbdd6f */
   public java.lang.String out_place_where;
   /** 备注
    * 
    * @pdOid 99640be2-0360-44f3-85cf-fede8e0883b1 */
   public java.lang.String remarks;

}