package com.zkjl.wf_clserver.core.service.impl;

import com.zkjl.wf_clserver.core.util.JdbcUtil;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;

/**
 * 读取流,将数据转成Map,插入数据库
 */
public class ExcelToMap {
	public static HashMap<String, Integer> actorMap = new HashMap<String, Integer>();
	public static HashMap<String, Integer> directorMap = new HashMap<String, Integer>();
	public static HashMap<String, Integer> movieMap = new HashMap<String, Integer>();
	public static HashMap<String, Integer> commentsMap = new HashMap<String, Integer>();

	/** 将Excel数据转换为Map集合 */
	public static void init(Workbook wb) throws IOException, BiffException {
		int ortherId = 10000;
		// int sheet_size = wb.getNumberOfSheets();
		for (int index = 0; index < 1; index++) {
			// 每个页签创建一个Sheet对象
			Sheet sheet = wb.getSheet(index);
			// sheet.getRows()返回该页的总行数
			for (int i = 1; i < sheet.getRows(); i++) {
				for (int j = 0; j < sheet.getColumns(); j++) {
					// 问题列过滤特殊字符
					String cellinfo = sheet.getCell(j, i).getContents().replace("\t", " ").replace("\r", " ").replace("\n", " ")
							.replace("\\", "/").trim();
					// 其他列过滤特殊字符后过滤空格
					String cellinfo2 = cellinfo.replace(" ", "").replace("　", "");

					if (j == 0) {// 演员

						if (!"".equals(cellinfo2) && null != cellinfo2 && !"NA".equals(cellinfo2)) {
							if (actorMap.get(cellinfo2) == null) {
								actorMap.put(cellinfo2, ++ortherId);
							}
						} else {
							if (actorMap.get("空演员") == null) {
								actorMap.put("空演员", ++ortherId);
							}
						}
					}
					if (j == 1) {// 导演
						if (!"".equals(cellinfo2) && null != cellinfo2 && !"NA".equals(cellinfo2)) {
							if (directorMap.get(cellinfo2) == null) {
								directorMap.put(cellinfo2, ++ortherId);
							}
						} else {
							if (directorMap.get("空导演") == null) {
								directorMap.put("空导演", ++ortherId);
							}
						}
					}
					if (j == 2) {// 电影
						if (!"".equals(cellinfo2) && null != cellinfo2 && !"NA".equals(cellinfo2)) {
							if (movieMap.get(cellinfo) == null) {
								movieMap.put(cellinfo, ++ortherId);
							}
						} else {
							if (movieMap.get("空电影") == null) {
								movieMap.put("空电影", ++ortherId);
							}
						}
					}
					if (j == 3) {// 评论
						if (commentsMap.get(cellinfo) == null) {
							commentsMap.put(cellinfo, ++ortherId);
						}
					}
				}
			}
		}
	}

	/** 创建节点 */
	public static void writeNode() throws SQLException {
		String line = "";
		JdbcUtil jdbcUtil = new JdbcUtil();
		jdbcUtil.getConnection();
		// 演员
		for (Object obj : actorMap.keySet()) {
			line = "MERGE (:Actor {name:'" + obj.toString() + "'})";
			jdbcUtil.update(line);
		}

		// 导演
		for (Object obj : directorMap.keySet()) {
			line = "MERGE (:Director {name:'" + obj.toString() + "'})";
			jdbcUtil.update(line);
		}

		// 电影
		for (Object obj : movieMap.keySet()) {
			line = "MERGE (:Movie {name:'" + obj.toString() + "'})";
			jdbcUtil.update(line);
		}

		// 评论
		for (Object obj : commentsMap.keySet()) {
			line = "MERGE (:Comments {name:'" + obj.toString() + "'})";
			jdbcUtil.update(line);
		}
	}

	/** 创建关系 */
	public static void writeLine(Workbook wb) throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
		// int sheet_size = wb.getNumberOfSheets();
		for (int index = 0; index < 1; index++) {
			Sheet sheet = wb.getSheet(index);
			for (int i = 1; i < sheet.getRows(); i++) {
				String actor = "";
				String director = "";
				String movie = "";
				String comments = "";
				for (int j = 0; j < sheet.getColumns(); j++) {
					String cellinfo = sheet.getCell(j, i).getContents().replace("\t", " ").replace("\r", " ").replace("\n", " ")
							.replace("\\", "/").trim();
					String cellinfo2 = cellinfo.replace(" ", "").replace("　", "");
					if (j == 0) {// 演员
						if (!"".equals(cellinfo2) && null != cellinfo2 && !"NA".equals(cellinfo2)) {
							actor = cellinfo2;
						} else {
							actor = "空演员";
						}
					} else if (j == 1) {// 导演
						if (!"".equals(cellinfo2) && null != cellinfo2 && !"NA".equals(cellinfo2)) {
							director = cellinfo2;
						} else {
							director = "空导演";
						}
					} else if (j == 2) {// 电影
						if (!"".equals(cellinfo2) && null != cellinfo2 && !"NA".equals(cellinfo2)) {
							movie = cellinfo2;
						} else {
							movie = "空电影";
						}
					} else if (j == 3) {// 评论
						comments = cellinfo;
					}
				}

				// 评论—>演员
				map.put("MATCH (aa:Comments {name:'" + comments + "'}), (bb:Actor {name:'" + actor
						+ "'}) MERGE (aa) -[:COMMENTSACTOR{name:''}]-> (bb)", "");

				// 评论—>导演
				map.put("MATCH (aa:Comments {name:'" + comments + "'}), (bb:Director {name:'" + director
						+ "'}) MERGE (aa) -[:COMMENTSDIRECTOR{name:''}]-> (bb)", "");

				// 评论—>电影
				map.put("MATCH (aa:Comments {name:'" + comments + "'}), (bb:Movie {name:'" + movie
						+ "'}) MERGE (aa) -[:COMMENTSMOVIE{name:''}]-> (bb)", "");

				// --------------------------------------------------------------------------

				// 演员—导演
				map.put("MATCH (aa:Actor {name:'" + actor + "'}), (bb:Director {name:'" + director
						+ "'}) MERGE (aa) -[:ACTORDIRECTOR{name:''}]-> (bb)", "");

				// 演员—电影
				map.put("MATCH (aa:Actor {name:'" + actor + "'}), (bb:Movie {name:'" + movie
						+ "'}) MERGE (aa) -[:ACTORMOVIE{name:''}]-> (bb)", "");

				// --------------------------------------------------------------------------

				// 导演—电影
				map.put("MATCH (aa:Director {name:'" + director + "'}), (bb:Movie {name:'" + movie
						+ "'}) MERGE (aa) -[:DIRECTORMOVIE{name:''}]-> (bb)", "");
			}
		}
		JdbcUtil jdbcUtil = new JdbcUtil();
		jdbcUtil.getConnection();

		Set<String> set = map.keySet();
		for (String string : set) {
			try {
				jdbcUtil.update(string);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(new File("C:/Users/LZ/Desktop/关键词筛过的数据关联设备0504 - 副本.xls").getAbsolutePath());
			wb = Workbook.getWorkbook(is);
			init(wb);
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				wb.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
