/***********************************************************************
 * Module:  sys_user.java
 * Author:  Administrator
 * Purpose: Defines the Class sys_user
 ***********************************************************************/

import java.util.*;

/** 系统用户表
 * 
 * @pdOid 143cb8fc-1333-45b5-9869-e4206f1710b4 */
public class sys_user {
   /** 用户id
    * 
    * @pdOid 8ae8c64b-7257-4e7a-af85-1ac56de5ca5d */
   public String id;
   /** 姓名
    * 
    * @pdOid 5b9e95c9-70dc-418d-ad0c-568d2f120398 */
   public String name;
   /** 密码
    * 
    * @pdOid 0b5ab2b1-a62a-422f-9f10-8c55a2c3c100 */
   public String password;
   /** 头像
    * 
    * @pdOid 544deba1-31cd-4285-8ec3-085f5d1d3749 */
   public String photo;
   /** 警号
    * 
    * @pdOid 965923ec-660b-4638-b795-b3286c2cd5d0 */
   public String police_number;
   /** 职位
    * 
    * @pdOid 5544feff-efb8-43ec-a376-cb44345e73b4 */
   public String job;
   /** 所属部门
    * 
    * @pdOid ae2b6c0e-b4a2-4e51-90c4-8b461ab0dd87 */
   public String department;
   /** 电话
    * 
    * @pdOid 4c98d11a-54f5-4ddc-8927-0898801c5a7b */
   public String phone;
   /** 邮箱
    * 
    * @pdOid e5ebfaed-f406-45a4-b4a1-c8d29777d9f4 */
   public String email;
   /** QQ
    * 
    * @pdOid cdacbbcd-9f04-4846-b1e3-7a30b65a84b8 */
   public String qq;
   /** 创建时间
    * 
    * @pdOid 1a6b4e36-0f61-4d55-ab4d-95433b48df43 */
   public java.util.Date create_date;
   /** 更新时间
    * 
    * @pdOid 3cc08698-fbab-4209-9454-0289f9f71d65 */
   public java.util.Date update_date;
   /** 是否删除
    * 
    * @pdOid 6292d86e-644d-41dc-a5c6-2b1bdfb72ba3 */
   public String del_flag;

}