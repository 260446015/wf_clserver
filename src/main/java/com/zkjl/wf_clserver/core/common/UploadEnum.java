package com.zkjl.wf_clserver.core.common;

import com.zkjl.wf_clserver.core.entity.Qq;
import com.zkjl.wf_clserver.core.entity.Wechat;

/**
 * @author ydw
 * Created on 2018/6/27
 */
public enum  UploadEnum {
    /**
     * 微信请求
     */
    WECHAT("wechat", Wechat.class),
    /**
     * qq请求
     */
    QQ("qq", Qq.class);

    private String uploadType;
    private Class<?> clazz;
    UploadEnum(String uploadType,Class<?> clazz) {
        this.uploadType = uploadType;
        this.clazz = clazz;
    }

    public static  Class getSelectModel(String uploadType){
        UploadEnum[] uploadEnums = UploadEnum.values();
        for (int i = 0; i < uploadEnums.length; i++) {
            UploadEnum uploadEnum = uploadEnums[i];
            if(uploadEnum.uploadType.equalsIgnoreCase(uploadType)){
                    return uploadEnum.clazz;
            }
        }
        throw new RuntimeException("请求参数类型uploadType无对应值，操作失败");
    }
}
