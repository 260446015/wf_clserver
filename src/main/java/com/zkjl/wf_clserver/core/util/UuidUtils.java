package com.zkjl.wf_clserver.core.util;

import java.util.UUID;

public class UuidUtils {
	public static String creatUUID(){
        return String.valueOf(UUID.randomUUID()).replace("-","");
    }
}
