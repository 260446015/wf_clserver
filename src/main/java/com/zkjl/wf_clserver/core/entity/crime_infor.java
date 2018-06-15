/***********************************************************************
 * Module:  crime_infor.java
 * Author:  Administrator
 * Purpose: Defines the Class crime_infor
 ***********************************************************************/

import java.util.*;

/** 违法犯罪人员信息表
 * 
 * @pdOid 686fa7d5-0d6c-4c10-b551-3b29b2e25f5b */
public class crime_infor {
   /** 违法犯罪人员id
    * 
    * @pdOid d382bd10-2142-4a37-ae5e-389cf310dd91 */
   public String id;
   /** 姓名
    * 
    * @pdOid 2aa11318-a1dd-4e7e-aa18-f580c6b2872a */
   public String name;
   /** 头像
    * 
    * @pdOid ae01c245-313a-4875-a75e-b5d7271a2adf */
   public String image;
   /** 性別
    * 
    * @pdOid eac913e8-04e1-49ca-b2bf-e76de3a25440 */
   public String sex;
   /** 別名
    * 
    * @pdOid 7f29b71b-0286-4d08-b981-db5938f1e54e */
   public String nickname;
   /** 民族
    * 
    * @pdOid 7b96bffe-717d-4d51-a054-f4ef927e9776 */
   public String race;
   /** 出生日期
    * 
    * @pdOid fd8af858-fc79-4331-81a4-fc8c6d092d84 */
   public java.util.Date birth;
   /** 身份证号
    * 
    * @pdOid 9bdf3241-da37-4b6f-b021-2e4be1328b37 */
   public String id_card;
   /** 身高
    * 
    * @pdOid bd31f516-8820-4f9b-9d2b-bb4b3e63ae94 */
   public int height;
   /** 足长
    * 
    * @pdOid 4718970d-8388-45e0-9856-aee4e225c13c */
   public int foot_length;
   /** 专长
    * 
    * @pdOid ef6d07ac-c124-4a85-b231-0197fa42fbe1 */
   public String expertise;
   /** 体表标记
    * 
    * @pdOid 9d9dc0e9-bc15-4195-be0d-2bf905cb7c2d */
   public String body_marker;
   /** 人员编号
    * 
    * @pdOid b3316b6d-3230-4af9-a821-30e36293bb71 */
   public String personnel_numb;
   /** 教育程度
    * 
    * @pdOid de094c34-e970-4bee-aaf7-93235e11a055 */
   public String edu;
   /** 身份
    * 
    * @pdOid 6ab209fd-76a6-4e1d-b1aa-39abdf901661 */
   public String identity;
   /** 户籍地
    * 
    * @pdOid 0e931e7b-d361-4628-a08f-0990389a6dda */
   public String domicile_place;
   /** 户籍地详址
    * 
    * @pdOid 94cf8535-ceed-4d31-b20f-b4011d65dc47 */
   public String domicile_address;
   /** 居住地
    * 
    * @pdOid 91b0a760-4ff3-4a99-be75-7aa71e520866 */
   public String live_place;
   /** 居住地详址
    * 
    * @pdOid c99becef-b81b-4958-9ec0-00957a14f96b */
   public String live_address;
   /** 入所日期
    * 
    * @pdOid 80fd87f9-088a-4d34-be29-6db9338faaf6 */
   public java.util.Date entry
                         _date;
   /** 案件类别
    * 
    * @pdOid 40fd068d-444a-4756-b233-b9e59a14d4d9 */
   public String case_category;
   /** 入所原因
    * 
    * @pdOid fe13f161-b35a-4202-9179-8918a3e002f1 */
   public String entry_cause;
   /** 办案单位
    * 
    * @pdOid 780b81cd-aa9b-4612-af63-660d87e31aab */
   public String case_handling_unit;
   /** 刑期
    * 
    * @pdOid 60a78f0f-0600-47b7-81d7-19aa1f0ed9d8 */
   public String prison_term;
   /** 司法处理结果
    * 
    * @pdOid 8a4d2d42-a0b5-414c-9f46-5b8b2252da4a */
   public String handle
                           _result;
   /** 法律文书号
    * 
    * @pdOid fb75b281-3e60-4a7a-ae90-1fc37b97c6c1 */
   public String legal_number;
   /** 出所原因
    * 
    * @pdOid 7d02ffa9-9e03-4bef-b907-5a140f7d1632 */
   public String out_place_cause;
   /** 出所日期
    * 
    * @pdOid 9187112d-5ba9-4425-b667-621f63e66937 */
   public java.util.Date out_place_date;
   /** 出所去向
    * 
    * @pdOid 886fb914-3519-424c-83f3-ce4e8cda954e */
   public String out_place_where;
   /** 简要案情
    * 
    * @pdOid f1c759d6-a612-40e5-bdca-6ef36e91ec2b */
   public String brief_case;

}