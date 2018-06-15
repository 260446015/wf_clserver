/***********************************************************************
 * Module:  sys_log.java
 * Author:  Administrator
 * Purpose: Defines the Class sys_log
 ***********************************************************************/

import java.util.*;

/** 操作日志表
 * 
 * @pdOid 1e1d41f2-d19b-43f8-8875-a9d26b8189ce */
public class sys_log {
   /** 日志id
    * 
    * @pdOid 2fb46bd1-591f-4887-a4bc-e8753bf6882c */
   public String id;
   /** 操作人
    * 
    * @pdOid 90fc2911-f95a-4a95-832b-c9a99fd226b7 */
   public String sys_user_id;
   /** 操作类型
    * 
    * @pdOid 0f22531d-ebe9-40fc-8e72-52e2c85688ca */
   public String category;
   /** 操作描述
    * 
    * @pdOid ea77e5e8-dfac-4ac8-9e44-fbd0c99f83f7 */
   public String description;
   /** 操作ip
    * 
    * @pdOid f88a2805-760b-49e8-a776-a80b6a695b3c */
   public String ip;
   /** 操作人姓名
    * 
    * @pdOid 3296e3d5-ffc1-4698-9b32-505667322e28 */
   public String username;
   /** 创建时间
    * 
    * @pdOid 1b8c7be1-a850-4f92-b69d-109e2fad904b */
   public java.util.Date create_date;
   /** 是否删除
    * 
    * @pdOid 50e65a99-7ffa-4aeb-8c99-3015a49cad9d */
   public String del_flag;

}