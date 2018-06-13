package com.zkjl.wf_clserver.core.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceUtil {

	// 配置文件
	private static ResourceBundle config = ResourceBundle.getBundle("conf", Locale.getDefault());

	public static String getString(String key) {
		return config.getString(key);
	}

}
