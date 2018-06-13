package com.zkjl.wf_clserver.core.service.impl;

import com.zkjl.wf_clserver.core.service.BatchImportService;
import jxl.Workbook;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service("BatchImportService")
public class BatchImportServiceImpl implements BatchImportService {

	/** 根据文件名时间，删除半年前历史数据 */
	@Override
	public void deleteFile(String path) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, -6);

		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdir();
		} else {
			File[] files = folder.listFiles();
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				if (!file.isDirectory()) {
					try {
						// 匹配文件名删除半年前的数据
						if (dateFormat.parse(file.getName().substring(0, 8)).before(calendar.getTime())) {
							file.delete();
						}
					} catch (Exception e) {
						// 移动异常文件到新文件夹
						File folder2 = new File(path + "/异常文件/");
						if (!folder2.exists()) {
							folder2.mkdir();
						}
						copy(file, new File(path + "/异常文件/" + file.getName()));
						file.delete();
						e.printStackTrace();
					}
				}
			}
		}
	}

	/** 写出导入日志文件 */
	@Override
	public void uploadLog(String path, String fileName, String type) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lineSeparator = System.getProperty("line.separator", "/n");
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("导入时间：");
		stringBuffer.append(dateFormat.format(new Date()));
		stringBuffer.append("\t文件名：");
		stringBuffer.append(fileName);
		stringBuffer.append("\t导入类型：");
		stringBuffer.append("1".equals(type) ? "批量导入" : "增量导入");
		stringBuffer.append(lineSeparator);
		// 判断文件夹是否存在
		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdir();
		}

		// 判断文件是否存在
		File folder2 = new File(path + "/导入日志.txt");
		if (!folder2.exists()) {
			try {
				folder2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 追加写入记录
		try {
			FileWriter writer = new FileWriter(folder2, true);
			writer.write(stringBuffer.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** 导入数据 */
	@Override
	public Integer importExcel(InputStream in, String type) {
		int ret = 0;
		Workbook wb = null;
		try {
			wb = Workbook.getWorkbook(in);
			// 批量导入 删除数据
			if ("1".equals(type)) {
				// 删除所有数据，保留User数据
				//deleteAll();
				// 创建所有和admin用户
				//createIndex();
			}
			// 初始化
			ExcelToMap.init(wb);
			// 创建节点
			ExcelToMap.writeNode();
			// 创建节点和关系
			ExcelToMap.writeLine(wb);
			ret = 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (wb != null) {
					wb.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	/** 文件拷贝方法 */
	public void copy(File from, File to) {
		try {
			InputStream in = new FileInputStream(from);
			OutputStream out = new FileOutputStream(to);
			byte[] buff = new byte[1024];
			int len = 0;
			while ((len = in.read(buff)) != -1) {
				out.write(buff, 0, len);
			}
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
