package com.zkjl.wf_clserver.core.util;

import com.zkjl.wf_clserver.core.exception.CustomerException;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
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
		//检查文件
//		checkFile(file);
		//获得Workbook工作薄对象
		Workbook workbook = getWorkBook(file);
		//根据每个sheet返回不同sheet的结合
        List<List<String[]>> bySheet = new ArrayList<>();

		if(workbook != null){
			for(int sheetNum = 0;sheetNum < workbook.getNumberOfSheets();sheetNum++){
                //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
                List<String[]> list = new ArrayList<>();
				//获得当前sheet工作表
				Sheet sheet = workbook.getSheetAt(sheetNum);
				if(sheet == null){
					continue;
				}
				//获得当前sheet的开始行
				int firstRowNum  = sheet.getFirstRowNum();
				//获得当前sheet的结束行
				int lastRowNum = sheet.getLastRowNum();
				//获取标题总列数
				int totalCell = 0;
				//循环除了第一行的所有行
				for(int rowNum = firstRowNum;rowNum <= lastRowNum;rowNum++){

					//获得当前行
					Row row = sheet.getRow(rowNum);
					if(row == null){
						continue;
					}
					if(rowNum == 0){
						totalCell = row.getPhysicalNumberOfCells();
					}
					if(totalCell == 0){
						throw new RuntimeException("第一行不为标题");
					}
					//获得当前行的开始列
					int firstCellNum = row.getFirstCellNum();
					//获得当前行的列数
//					int lastCellNum = row.getPhysicalNumberOfCells();
					String[] cells = new String[totalCell];
					//循环当前行
					for(int cellNum = firstCellNum; cellNum < totalCell;cellNum++){
						Cell cell = row.getCell(cellNum);
						cells[cellNum] = getCellValue(cell);
					}
					if(cells.length <= 1){
						throw new CustomerException("Excel导入应指定第一行为标题，从第二行开始为内容。请确定格式!!!");
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
				workbook = new XSSFWorkbook(is);
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

	public static List<String[]> readTxt(MultipartFile file,String split) {
		List<String[]> datas = new ArrayList<>();
		InputStream inputStream = null;
		BufferedReader reader = null;
		try {
			inputStream = file.getInputStream();
			reader = new BufferedReader(new InputStreamReader(inputStream,"gbk"));//传参
			String line = "";
			while ((line = reader.readLine())!= null){
                String data = line;
                String[] split1 = data.split(split);//传参
                if(split1.length <= 1){
                    continue;
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
}
