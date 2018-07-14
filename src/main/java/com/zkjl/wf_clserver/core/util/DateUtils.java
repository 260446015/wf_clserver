package com.zkjl.wf_clserver.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String getFormatString(Date date){
        return simpleDateFormat.format(date);
    }
}
