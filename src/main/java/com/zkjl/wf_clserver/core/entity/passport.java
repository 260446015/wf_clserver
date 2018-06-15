/***********************************************************************
 * Module:  passport.java
 * Author:  Administrator
 * Purpose: Defines the Class passport
 ***********************************************************************/

import java.util.*;

/** 护照信息
 * 
 * @pdOid 28c4fa9c-7e9a-4170-a892-04c73bdc429d */
public class passport {
   /** 护照信息id
    * 
    * @pdOid 38dacd69-972a-4f9a-b964-84ff63588cee */
   public String id;
   /** 护照类型
    * 
    * @pdOid bc9db8a4-696a-48d3-a894-5c67e68c4984 */
   public String type;
   /** 国家码
    * 
    * @pdOid 060628ad-6bd1-4905-bc9a-8969d38ccffb */
   public String country_code;
   /** 护照号码
    * 
    * @pdOid 3ecdaa1b-9249-4b25-b987-8eef124e0853 */
   public String number;
   /** 姓名
    * 
    * @pdOid c4d05c73-3b7d-4476-b7a9-77a3ea4afc5d */
   public String name;
   /** 性别
    * 
    * @pdOid 1a856c2f-2da5-4f3e-b2fb-d6416eaa6071 */
   public String sex;
   /** 国籍
    * 
    * @pdOid fa27d585-b129-4712-a41a-826da57aff9c */
   public String nationality;
   /** 出生日期
    * 
    * @pdOid f3b73389-a61f-498b-a1b0-a32385348ffd */
   public java.util.Date birthDate;
   /** 出生地点
    * 
    * @pdOid 7c274373-3742-4e7d-bc79-4b97c42718a6 */
   public String birthPlace;
   /** 签发日期
    * 
    * @pdOid b4ab3385-3f6e-449f-81ae-365bc14717dd */
   public java.util.Date issueDate;
   /** 签发地点
    * 
    * @pdOid 11be0356-9226-4e0c-a162-517ca6c82ce7 */
   public String issuePlace;
   /** 有效期至
    * 
    * @pdOid a8b590c2-9a8b-4e5f-88c4-4d99521548fd */
   public java.util.Date expiryDate;
   /** 签发机关
    * 
    * @pdOid eb5bb894-fc79-4557-8d7a-cbdbb766778e */
   public String authority;

}