package com.zkjl.wf_clserver.core.common;

import com.zkjl.wf_clserver.core.service.upload.impl.ExcelUpload;
import com.zkjl.wf_clserver.core.service.upload.impl.TxtUpload;

/**
 * @author ydw
 * Created on 2018/7/2
 */
public enum FileUploadEnum {
    TXT("txt", TxtUpload.class),EXCEL("excel", ExcelUpload.class);

    private String type;
    private Class<?> clazz;

    FileUploadEnum(String type,Class<?> clazz) {
        this.type = type;
        this.clazz = clazz;
    }

    public static Class<?> getTargetService(String type){
        FileUploadEnum[] values = FileUploadEnum.values();
        for (int i = 0; i < values.length; i++) {
            FileUploadEnum value = values[i];
            if(value.type.equalsIgnoreCase(type)){
                return value.clazz;
            }
        }
        return null;
    }
}
