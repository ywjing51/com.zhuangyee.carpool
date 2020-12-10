package com.zhuangyee.parse.ddl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
    *   通过POI解析Excel文件
 * @author zhuangyee jinfengYang
 *
 */
public class ParseExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Excel文件路径
		 */
		String fileName = "D://社区顺风车-表结构设计_v0.6.xlsx";

		// 返回值列
		List<TableBooks> resultList = new ArrayList<TableBooks>();
		TableObject tableObjectTemp = new TableObject();
		/**
		 * Excel解析
		 */
		tableObjectTemp = parseExcel(fileName);
		/**
		 * 生成DDL
		 */
		String sql = generateDDL();	
	}

	/**
	 * 
	 * @deprecated 获取Excel文件
	 * @param fileName 
	 * @return bookList 
	 * @throws
	 */
//	private static List<TableBooks> parseExcel(String fileName) {
//		Workbook workbook = null;
//		InputStream in = null;
//		// 获取Excel文档
//		try {
//			// 获取Excel文件
//			in = new FileInputStream(fileName);
//			// 获取Excel工作簿
//			workbook = new XSSFWorkbook(in);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		// 解析工作薄
//		List<TableBooks> bookList = new ArrayList<TableBooks>();
//		bookList = parseSheet(workbook);
//		return bookList;
//	}
	private static TableObject parseExcel(String fileName) {
		Workbook workbook = null;
		InputStream in = null;
		// 获取Excel文档
		try {
			// 获取Excel文件
			in = new FileInputStream(fileName);
			// 获取Excel工作簿
			workbook = new XSSFWorkbook(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 解析工作薄
		List<TableBooks> bookList = new ArrayList<TableBooks>();
		TableObject tableObjectTemp =new TableObject();
		bookList = parseSheet(workbook);
		tableObjectTemp.setTablebookList(bookList);
		return tableObjectTemp;
	}
	/**
	 * 
	 * @deprecated 解析Excel文件的所有sheet页
	 * @param workbook 
	 * @return booklistTemp 
	 * @throws
	 */
//	private static List<TableBooks> parseSheet(Workbook workbook) {
//		TableBooks tableBooksTemp = new TableBooks();
//		List<TableBooks> bookList = new ArrayList<TableBooks>();
//		Sheet sheet = null;
//		Row row = null;
//
//		// sheet页页数
//		int sheetNum = workbook.getNumberOfSheets();
//
//		// 从Excel文档的第三页表数据页开始遍历
//		for (int s = 2; s <= sheetNum - 2; s++) {
//
//			// 当前sheet页
//			sheet = workbook.getSheetAt(s);
//
//			String tableName = "";
//
//			// 当前sheet页的行数
//			int rowNum = sheet.getPhysicalNumberOfRows();
//			// 当前sheet页第二行
//			Row row2 = sheet.getRow(1);
//			// 当前sheet页第二行第二列
//			Cell cell2 = row2.getCell(3);
//			tableName = cell2.getRichStringCellValue().getString();
//			tableBooksTemp.setTableName(tableName);
//			// 从第四行开始遍历
//			for (int r = 3; r <= rowNum - 1; r++) {
//
//				// 当前行数
//				row = sheet.getRow(r);
//				List<TableCols> tableCoLsList = new ArrayList<TableCols>();
//				// 当前行的所有单元格解析
//				tableCoLsList = parseCell(row);
////				//debug
////				TableCols tColsTemp1 = new TableCols();
////				tColsTemp1=tableCoLsList.get(r-3);
////				System.out.print(tColsTemp1.getCol_name_en());
//				// 将当前sheet页的当前行放入TableBooks的表字段对象中
//				tableBooksTemp.setTableColsList(tableCoLsList);
//			}
////			// 将当前sheet页的当前行放入TableBooks的表字段对象中
////			tableBooksTemp.setTableColsList(tableCoLsList);
//			// 将当前sheet页中的表名和表字段放入TableObjects的属性中
//			bookList.add(tableBooksTemp);
//		}
//
//		return bookList;
//	}

	/**
	 * 
	 * @deprecated 解析Excel文件的所有sheet页
	 * @param workbook 
	 * @return booklistTemp 
	 * @throws
	 */
	private static List<TableBooks> parseSheet(Workbook workbook) {
		//定义变量
		List<TableBooks> bookList = new ArrayList<TableBooks>();
		List<TableCols> tableCoLsList = new ArrayList<TableCols>();	
		Sheet sheet = null;
		Row row = null;
try {
	
		// sheet页页数
		int sheetNum = workbook.getNumberOfSheets();

		// 从Excel文档的第三页表数据页开始遍历
		for (int s = 2; s <= sheetNum - 2; s++) {			
			//实例化对象
			TableBooks tableBooksTemp = new TableBooks();
			// 当前sheet页
			sheet = workbook.getSheetAt(s);

			String tableName = "";

			// 当前sheet页的行数
			int rowNum = sheet.getPhysicalNumberOfRows();
			// 当前sheet页第二行
			Row row2 = sheet.getRow(1);
			// 当前sheet页第二行第二列
			Cell cell2 = row2.getCell(3);
			tableName = cell2.getRichStringCellValue().getString();
			tableBooksTemp.setTableName(tableName);
			// 从第四行开始遍历
			for (int r = 3; r <= rowNum - 1; r++) {				
				//实例化对象
				TableCols tableColsTemp = new TableCols();
//				Map<String, List> rowMap = new HashMap<String,List>();
				
				// 当前行数
				row = sheet.getRow(r);
										
				// 当前行的所有单元格解析
				tableColsTemp = parseCell(row);
				tableCoLsList.add(tableColsTemp);
//				//debug
//				TableCols tColsTemp1 = new TableCols();
//				tColsTemp1=tableCoLsList.get(r-3);
//				System.out.print(tColsTemp1.getCol_name_en());				
			}
			// 将当前sheet页的当前行放入TableBooks的表字段对象中
			tableBooksTemp.setTableColsList(tableCoLsList);
//			// 将当前sheet页中的表名和表字段放入TableObjects的属性中
			bookList.add(tableBooksTemp);
		}
} catch (Exception e) {
	e.printStackTrace();
}
		return bookList;
	}

 
	/**
	 * 
	 *@deprecated 解析sheet页每行的单元格
	 *@param row 
	 *@return tableCoLsListTemp 
	 *@throws
	 */
//	private static List<TableCols> parseCell(Row row) {
//		TableCols tColsTemp = new TableCols();
//		List<TableCols> tableColsListTemp = new ArrayList<TableCols>();
//		// 当前行的列数
//		int colNum = row.getPhysicalNumberOfCells();
//		// 循环遍历每列，将每列的数值放入对象中
//		for (int j = 2; j <= colNum - 1; j++) {
//			Cell cell = null;
//			cell = row.getCell(j);
//			switch (j) {
//			// 第三列 中文名
//			case 2:
//				String col_name_zh = cell.getRichStringCellValue().getString();
//				tColsTemp.setCol_name_zh(col_name_zh);
//				break;
//			// 第四列 英文名
//			case 3:
//				String col_name_en = cell.getRichStringCellValue().getString();
//				tColsTemp.setCol_name_en(col_name_en);
//				break;
//			// 第五列 类型
//			case 4:
//				String col_type = cell.getRichStringCellValue().getString();
//				tColsTemp.setCol_type(col_type);
//				break;
//			// 第六列 长度
//			case 5:
//				int col_len = (int) cell.getNumericCellValue();
//      			tColsTemp.setCol_len(col_len);
//				break;
//			// 第七列 主键
//			case 6:
//				String col_pri_key = cell.getRichStringCellValue().getString();
//				tColsTemp.setCol_pri_key(col_pri_key);
//				break;
//			// 第八列 非空
//			case 7:
//				String col_null = cell.getRichStringCellValue().getString();
//				tColsTemp.setCol_null(col_null);
//				break;
//			// 第九列 默认值
//			case 8:
//				String col_def = cell.getRichStringCellValue().getString();
//				tColsTemp.setCol_def(col_def);
//				break;
//			// 第十列 备注
//			case 9:
//				String col_comment = cell.getRichStringCellValue().getString();
//				tColsTemp.setCol_comment(col_comment);
//				break;
//			}
//		}
//		// 将当前行的所有列放入TableBooks的tableColsList中
//		tableColsListTemp.add(tColsTemp);		
//		return tableColsListTemp;
//
////		String arrs[] = new String[7];
//
////		//循环获取每个单元格的值
////		int colNum = row.getPhysicalNumberOfCells();
////		for(int j =1; j<=colNum-1; j++) {
////			cell = row.getCell(j);
////			arrs[j] = cell.getRichStringCellValue().getString();
////			tableColsList.add(arrs[j]);		
////		}
//	}
	 
	private static TableCols parseCell(Row row) {
		TableCols tColsTemp = new TableCols();
		List<TableCols> tableColsListTemp = new ArrayList<TableCols>();
		// 当前行的列数
		int colNum = row.getPhysicalNumberOfCells();
		// 循环遍历每列，将每列的数值放入对象中
		for (int j = 2; j <= colNum - 1; j++) {
		
			Cell cell = null;
			cell = row.getCell(j);
			switch (j) {
			// 第三列 中文名
			case 2:
				String col_name_zh = cell.getRichStringCellValue().getString();
				tColsTemp.setCol_name_zh(col_name_zh);
				break;
			// 第四列 英文名
			case 3:
				String col_name_en = cell.getRichStringCellValue().getString();
				tColsTemp.setCol_name_en(col_name_en);
				break;
			// 第五列 类型
			case 4:
				String col_type = cell.getRichStringCellValue().getString();
				tColsTemp.setCol_type(col_type);
				break;
			// 第六列 长度
			case 5:
				int col_len = (int) cell.getNumericCellValue();
      			tColsTemp.setCol_len(col_len);
				break;
			// 第七列 主键
			case 6:
				String col_pri_key = cell.getRichStringCellValue().getString();
				tColsTemp.setCol_pri_key(col_pri_key);
				break;
			// 第八列 非空
			case 7:
				String col_null = cell.getRichStringCellValue().getString();
				tColsTemp.setCol_null(col_null);
				break;
			// 第九列 默认值
			case 8:
				String col_def = cell.getRichStringCellValue().getString();
				tColsTemp.setCol_def(col_def);
				break;
			// 第十列 备注
			case 9:
				String col_comment = cell.getRichStringCellValue().getString();
				tColsTemp.setCol_comment(col_comment);
				break;
			}
		}
		// 将当前行的所有列放入TableBooks的tableColsList中
//		tableColsListTemp.add(tColsTemp);		
		return tColsTemp;

//		String arrs[] = new String[7];

//		//循环获取每个单元格的值
//		int colNum = row.getPhysicalNumberOfCells();
//		for(int j =1; j<=colNum-1; j++) {
//			cell = row.getCell(j);
//			arrs[j] = cell.getRichStringCellValue().getString();
//			tableColsList.add(arrs[j]);		
//		}
	}
	/**
	 * 生成DDL
	 * @return
	 */
	private static String generateDDL() {
		StringBuffer sql = new StringBuffer("");
		sql.append("CREATE TABLE ");
		TableObject tableObject = new TableObject();
		List<TableBooks> tBooks = new ArrayList<TableBooks>();
		tBooks = tableObject.getTablebookList();
		//工作薄共有sheet页数
		int bookListNum = tBooks.size();
		//循环遍历sheet页，生成sql语句
		for(int i = 0 ;i<= bookListNum-1;i++ ) {
		//tableObject= (TableObject) tBooks.get(i);		
		TableBooks tablebookstemp = new TableBooks();
		//当前sheet页
		tablebookstemp= tBooks.get(i);
		//取得当前sheet页的表名
		String tableName = tablebookstemp.getTableName();
		sql.append(tableName + " ( ");
		//取得当前sheet页表字段
		List<TableCols> tCols = new ArrayList<TableCols>();
		tCols = tablebookstemp.getTableColsList();
		//获取当前sheet页表字段的行数
		int tColsNum = tCols.size();
		for (int j = 0; j <= tColsNum-1;j++) {
			TableCols tableColTempCols = new TableCols();
			tableColTempCols = tCols.get(j);
			//建表语句拼接
			sql.append(tableColTempCols.getCol_name_en()+" ");
			sql.append(tableColTempCols.getCol_type()+"(");
			sql.append(tableColTempCols.getCol_len()+") ");
			String primary_key = tableColTempCols.getCol_pri_key();
			String not_null =tableColTempCols.getCol_null();
			String def = tableColTempCols.getCol_def();
			String comment = tableColTempCols.getCol_name_zh();
			if(primary_key.equals("是")) {
			sql.append(primary_key+" ");
			}
			if(not_null.equals("否")) {
			sql.append("NOT NULL ");			
			}
			if(def != null || !def.equals("")) {
			sql.append(def+" ");
			}
			sql.append("COMMENT "+tableColTempCols.getCol_name_zh()+" ");
			if(comment != null || !comment.equals("")) {
				sql.append(comment+" ");
			}
			if(j != tColsNum) {
				sql.append(",");
			}else {
				sql.append(")");
			}						
		}
		String s =sql.toString();
//		SaveDataToFile save = new SaveDataToFile();
		System.out.print(s);
//		save.appendFile(tableName, s);
		}
		return null;
		
	}

}
