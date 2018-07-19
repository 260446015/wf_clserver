package com.zkjl.wf_clserver.core.util;

import com.monitorjbl.xlsx.StreamingReader;
import com.zkjl.wf_clserver.core.exception.CustomerException;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;


@Component
public class POIUtils {

	private static Logger logger  = LoggerFactory.getLogger(POIUtils.class);
	private final static String xls = "xls";
	private final static String xlsx = "xlsx";
	private final static String txt = "txt";

	/**
	 * 读入excel文件，解析后返回
	 * @param file
	 * @throws IOException
	 */
	public static List<List<String[]>> readExcel(MultipartFile file) throws IOException, CustomerException {
		//获得Workbook工作薄对象
		Workbook workbook = getWorkBook(file);
		//根据每个sheet返回不同sheet的结合
        List<List<String[]>> bySheet = new ArrayList<>();
		String reg = "^.*\\d{6}.*$";
		if(workbook != null){
			for(int sheetNum = 0;sheetNum < workbook.getNumberOfSheets();sheetNum++){
				List<String[]> list = new ArrayList<>();
				Sheet sheet = workbook.getSheetAt(sheetNum);
				Boolean flag = null;
                for (Row row : sheet){
					String[] cells ;
					try {
						cells = new String[row.getLastCellNum()];
					} catch (Exception e) {
						continue;
					}

					for (int i = 0; i < row.getLastCellNum(); i++) {
						Cell cell = row.getCell(i);
						try {
							cell.setCellType(CellType.STRING);
						} catch (Exception e) {
						}
						cells[i] = (cell == null?" ":cell.getStringCellValue());
					}
					if(flag == null){
						flag = Arrays.toString(cells).matches(reg);
					}
					if (flag){
						throw new CustomerException("导入数据中第一行必须为标题栏，而不是正文!");
					}
					if(cells.length <= 1){
						continue;
					}
					list.add(cells);
				}
				bySheet.add(list);
			}
			workbook.close();
		}
		return bySheet;
	}

	public static Workbook getWorkBook(MultipartFile file) {
		//获得文件名
		String fileName = file.getOriginalFilename();
		//创建Workbook工作薄对象，表示整个excel
		Workbook workbook = null;
		try {
			//获取excel文件的io流
			InputStream is = file.getInputStream();
			//根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
			if(fileName.endsWith(xls)){
				//2003
				workbook = new HSSFWorkbook(is);
			}else if(fileName.endsWith(xlsx)){
				//2007
//				workbook = new XSSFWorkbook(is);
				workbook = StreamingReader.builder().rowCacheSize(100).bufferSize(4096).open(is);
			}
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
		return workbook;
	}
	public static String getCellValue(Cell cell){
		String cellValue = "";
		if(cell == null){
			return cellValue;
		}
		//把数字当成String来读，避免出现1读成1.0的情况
		if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
			cell.setCellType(Cell.CELL_TYPE_STRING);
		}
		//判断数据的类型
		switch (cell.getCellType()){
			case Cell.CELL_TYPE_NUMERIC: //数字
				cellValue = String.valueOf(cell.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_STRING: //字符串
				cellValue = String.valueOf(cell.getStringCellValue());
				break;
			case Cell.CELL_TYPE_BOOLEAN: //Boolean
				cellValue = String.valueOf(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_FORMULA: //公式
				cellValue = String.valueOf(cell.getCellFormula());
				break;
			case Cell.CELL_TYPE_BLANK: //空值
				cellValue = "";
				break;
			case Cell.CELL_TYPE_ERROR: //故障
				cellValue = "非法字符";
				break;
			default:
				cellValue = "未知类型";
				break;
		}
		return cellValue;
	}

	public static List<String[]> readTxt(MultipartFile file,String split) throws CustomerException {
		List<String[]> datas = new ArrayList<>();
		InputStream inputStream = null;
		BufferedReader reader = null;
		try {
			inputStream = file.getInputStream();
			reader = new BufferedReader(new InputStreamReader(inputStream,"gbk"));//传参
			String line = "";
			String reg = "^.*\\d{6}.*$";
			Boolean flag = null;
			while ((line = reader.readLine())!= null){
                String data = line;
                if(flag == null){
                	flag = data.matches(reg);
				}
                if(flag){
                	throw new CustomerException("导入数据中第一行必须为标题栏，而不是正文!");
				}
                String[] split1 = data.split(split,-1);//传参
				for (int i = 0; i < split1.length; i++) {
					if(StringUtils.isNotBlank(split1[i])){
						if(" ".equals(split1[i])){
							continue;
						}
						split1[i] = split1[i].trim();
					}
				}
                if(split1.length <= 1){
                    throw new CustomerException("导入数据解析分隔符错误,请核查分隔符是否正确!");
                }
                datas.add(split1);
            }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(inputStream != null){
                    inputStream.close();
                }
				if (reader != null){
                    reader.close();
                }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return datas;
	}

	/**
	 * 读取word
	 */
	public static List<String[]> readWord(MultipartFile file) throws CustomerException {
		List<String[]> datas = new ArrayList<>();
		try {
			WordExtractor extractor = new WordExtractor(file.getInputStream());
			//输出word文档所有的文本
			System.out.println(extractor.getText());
			System.out.println(extractor.getTextFromPieces());
			String[] rowText = extractor.getText().split("\n");
			for (int i = 0; i < rowText.length; i++) {
				String[] rowSplit = rowText[i].split("\t");
				if(rowSplit.length <= 1){
					continue;
				}
				datas.add(rowSplit);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return datas;
	}
}
