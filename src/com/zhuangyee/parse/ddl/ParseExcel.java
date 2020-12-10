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
    *   ͨ��POI����Excel�ļ�
 * @author zhuangyee jinfengYang
 *
 */
public class ParseExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Excel�ļ�·��
		 */
		String fileName = "D://����˳�糵-��ṹ���_v0.6.xlsx";

		// ����ֵ��
		List<TableBooks> resultList = new ArrayList<TableBooks>();
		TableObject tableObjectTemp = new TableObject();
		/**
		 * Excel����
		 */
		tableObjectTemp = parseExcel(fileName);
		/**
		 * ����DDL
		 */
		String sql = generateDDL();	
	}

	/**
	 * 
	 * @deprecated ��ȡExcel�ļ�
	 * @param fileName 
	 * @return bookList 
	 * @throws
	 */
//	private static List<TableBooks> parseExcel(String fileName) {
//		Workbook workbook = null;
//		InputStream in = null;
//		// ��ȡExcel�ĵ�
//		try {
//			// ��ȡExcel�ļ�
//			in = new FileInputStream(fileName);
//			// ��ȡExcel������
//			workbook = new XSSFWorkbook(in);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		// ����������
//		List<TableBooks> bookList = new ArrayList<TableBooks>();
//		bookList = parseSheet(workbook);
//		return bookList;
//	}
	private static TableObject parseExcel(String fileName) {
		Workbook workbook = null;
		InputStream in = null;
		// ��ȡExcel�ĵ�
		try {
			// ��ȡExcel�ļ�
			in = new FileInputStream(fileName);
			// ��ȡExcel������
			workbook = new XSSFWorkbook(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ����������
		List<TableBooks> bookList = new ArrayList<TableBooks>();
		TableObject tableObjectTemp =new TableObject();
		bookList = parseSheet(workbook);
		tableObjectTemp.setTablebookList(bookList);
		return tableObjectTemp;
	}
	/**
	 * 
	 * @deprecated ����Excel�ļ�������sheetҳ
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
//		// sheetҳҳ��
//		int sheetNum = workbook.getNumberOfSheets();
//
//		// ��Excel�ĵ��ĵ���ҳ������ҳ��ʼ����
//		for (int s = 2; s <= sheetNum - 2; s++) {
//
//			// ��ǰsheetҳ
//			sheet = workbook.getSheetAt(s);
//
//			String tableName = "";
//
//			// ��ǰsheetҳ������
//			int rowNum = sheet.getPhysicalNumberOfRows();
//			// ��ǰsheetҳ�ڶ���
//			Row row2 = sheet.getRow(1);
//			// ��ǰsheetҳ�ڶ��еڶ���
//			Cell cell2 = row2.getCell(3);
//			tableName = cell2.getRichStringCellValue().getString();
//			tableBooksTemp.setTableName(tableName);
//			// �ӵ����п�ʼ����
//			for (int r = 3; r <= rowNum - 1; r++) {
//
//				// ��ǰ����
//				row = sheet.getRow(r);
//				List<TableCols> tableCoLsList = new ArrayList<TableCols>();
//				// ��ǰ�е����е�Ԫ�����
//				tableCoLsList = parseCell(row);
////				//debug
////				TableCols tColsTemp1 = new TableCols();
////				tColsTemp1=tableCoLsList.get(r-3);
////				System.out.print(tColsTemp1.getCol_name_en());
//				// ����ǰsheetҳ�ĵ�ǰ�з���TableBooks�ı��ֶζ�����
//				tableBooksTemp.setTableColsList(tableCoLsList);
//			}
////			// ����ǰsheetҳ�ĵ�ǰ�з���TableBooks�ı��ֶζ�����
////			tableBooksTemp.setTableColsList(tableCoLsList);
//			// ����ǰsheetҳ�еı����ͱ��ֶη���TableObjects��������
//			bookList.add(tableBooksTemp);
//		}
//
//		return bookList;
//	}

	/**
	 * 
	 * @deprecated ����Excel�ļ�������sheetҳ
	 * @param workbook 
	 * @return booklistTemp 
	 * @throws
	 */
	private static List<TableBooks> parseSheet(Workbook workbook) {
		//�������
		List<TableBooks> bookList = new ArrayList<TableBooks>();
		List<TableCols> tableCoLsList = new ArrayList<TableCols>();	
		Sheet sheet = null;
		Row row = null;
try {
	
		// sheetҳҳ��
		int sheetNum = workbook.getNumberOfSheets();

		// ��Excel�ĵ��ĵ���ҳ������ҳ��ʼ����
		for (int s = 2; s <= sheetNum - 2; s++) {			
			//ʵ��������
			TableBooks tableBooksTemp = new TableBooks();
			// ��ǰsheetҳ
			sheet = workbook.getSheetAt(s);

			String tableName = "";

			// ��ǰsheetҳ������
			int rowNum = sheet.getPhysicalNumberOfRows();
			// ��ǰsheetҳ�ڶ���
			Row row2 = sheet.getRow(1);
			// ��ǰsheetҳ�ڶ��еڶ���
			Cell cell2 = row2.getCell(3);
			tableName = cell2.getRichStringCellValue().getString();
			tableBooksTemp.setTableName(tableName);
			// �ӵ����п�ʼ����
			for (int r = 3; r <= rowNum - 1; r++) {				
				//ʵ��������
				TableCols tableColsTemp = new TableCols();
//				Map<String, List> rowMap = new HashMap<String,List>();
				
				// ��ǰ����
				row = sheet.getRow(r);
										
				// ��ǰ�е����е�Ԫ�����
				tableColsTemp = parseCell(row);
				tableCoLsList.add(tableColsTemp);
//				//debug
//				TableCols tColsTemp1 = new TableCols();
//				tColsTemp1=tableCoLsList.get(r-3);
//				System.out.print(tColsTemp1.getCol_name_en());				
			}
			// ����ǰsheetҳ�ĵ�ǰ�з���TableBooks�ı��ֶζ�����
			tableBooksTemp.setTableColsList(tableCoLsList);
//			// ����ǰsheetҳ�еı����ͱ��ֶη���TableObjects��������
			bookList.add(tableBooksTemp);
		}
} catch (Exception e) {
	e.printStackTrace();
}
		return bookList;
	}

 
	/**
	 * 
	 *@deprecated ����sheetҳÿ�еĵ�Ԫ��
	 *@param row 
	 *@return tableCoLsListTemp 
	 *@throws
	 */
//	private static List<TableCols> parseCell(Row row) {
//		TableCols tColsTemp = new TableCols();
//		List<TableCols> tableColsListTemp = new ArrayList<TableCols>();
//		// ��ǰ�е�����
//		int colNum = row.getPhysicalNumberOfCells();
//		// ѭ������ÿ�У���ÿ�е���ֵ���������
//		for (int j = 2; j <= colNum - 1; j++) {
//			Cell cell = null;
//			cell = row.getCell(j);
//			switch (j) {
//			// ������ ������
//			case 2:
//				String col_name_zh = cell.getRichStringCellValue().getString();
//				tColsTemp.setCol_name_zh(col_name_zh);
//				break;
//			// ������ Ӣ����
//			case 3:
//				String col_name_en = cell.getRichStringCellValue().getString();
//				tColsTemp.setCol_name_en(col_name_en);
//				break;
//			// ������ ����
//			case 4:
//				String col_type = cell.getRichStringCellValue().getString();
//				tColsTemp.setCol_type(col_type);
//				break;
//			// ������ ����
//			case 5:
//				int col_len = (int) cell.getNumericCellValue();
//      			tColsTemp.setCol_len(col_len);
//				break;
//			// ������ ����
//			case 6:
//				String col_pri_key = cell.getRichStringCellValue().getString();
//				tColsTemp.setCol_pri_key(col_pri_key);
//				break;
//			// �ڰ��� �ǿ�
//			case 7:
//				String col_null = cell.getRichStringCellValue().getString();
//				tColsTemp.setCol_null(col_null);
//				break;
//			// �ھ��� Ĭ��ֵ
//			case 8:
//				String col_def = cell.getRichStringCellValue().getString();
//				tColsTemp.setCol_def(col_def);
//				break;
//			// ��ʮ�� ��ע
//			case 9:
//				String col_comment = cell.getRichStringCellValue().getString();
//				tColsTemp.setCol_comment(col_comment);
//				break;
//			}
//		}
//		// ����ǰ�е������з���TableBooks��tableColsList��
//		tableColsListTemp.add(tColsTemp);		
//		return tableColsListTemp;
//
////		String arrs[] = new String[7];
//
////		//ѭ����ȡÿ����Ԫ���ֵ
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
		// ��ǰ�е�����
		int colNum = row.getPhysicalNumberOfCells();
		// ѭ������ÿ�У���ÿ�е���ֵ���������
		for (int j = 2; j <= colNum - 1; j++) {
		
			Cell cell = null;
			cell = row.getCell(j);
			switch (j) {
			// ������ ������
			case 2:
				String col_name_zh = cell.getRichStringCellValue().getString();
				tColsTemp.setCol_name_zh(col_name_zh);
				break;
			// ������ Ӣ����
			case 3:
				String col_name_en = cell.getRichStringCellValue().getString();
				tColsTemp.setCol_name_en(col_name_en);
				break;
			// ������ ����
			case 4:
				String col_type = cell.getRichStringCellValue().getString();
				tColsTemp.setCol_type(col_type);
				break;
			// ������ ����
			case 5:
				int col_len = (int) cell.getNumericCellValue();
      			tColsTemp.setCol_len(col_len);
				break;
			// ������ ����
			case 6:
				String col_pri_key = cell.getRichStringCellValue().getString();
				tColsTemp.setCol_pri_key(col_pri_key);
				break;
			// �ڰ��� �ǿ�
			case 7:
				String col_null = cell.getRichStringCellValue().getString();
				tColsTemp.setCol_null(col_null);
				break;
			// �ھ��� Ĭ��ֵ
			case 8:
				String col_def = cell.getRichStringCellValue().getString();
				tColsTemp.setCol_def(col_def);
				break;
			// ��ʮ�� ��ע
			case 9:
				String col_comment = cell.getRichStringCellValue().getString();
				tColsTemp.setCol_comment(col_comment);
				break;
			}
		}
		// ����ǰ�е������з���TableBooks��tableColsList��
//		tableColsListTemp.add(tColsTemp);		
		return tColsTemp;

//		String arrs[] = new String[7];

//		//ѭ����ȡÿ����Ԫ���ֵ
//		int colNum = row.getPhysicalNumberOfCells();
//		for(int j =1; j<=colNum-1; j++) {
//			cell = row.getCell(j);
//			arrs[j] = cell.getRichStringCellValue().getString();
//			tableColsList.add(arrs[j]);		
//		}
	}
	/**
	 * ����DDL
	 * @return
	 */
	private static String generateDDL() {
		StringBuffer sql = new StringBuffer("");
		sql.append("CREATE TABLE ");
		TableObject tableObject = new TableObject();
		List<TableBooks> tBooks = new ArrayList<TableBooks>();
		tBooks = tableObject.getTablebookList();
		//����������sheetҳ��
		int bookListNum = tBooks.size();
		//ѭ������sheetҳ������sql���
		for(int i = 0 ;i<= bookListNum-1;i++ ) {
		//tableObject= (TableObject) tBooks.get(i);		
		TableBooks tablebookstemp = new TableBooks();
		//��ǰsheetҳ
		tablebookstemp= tBooks.get(i);
		//ȡ�õ�ǰsheetҳ�ı���
		String tableName = tablebookstemp.getTableName();
		sql.append(tableName + " ( ");
		//ȡ�õ�ǰsheetҳ���ֶ�
		List<TableCols> tCols = new ArrayList<TableCols>();
		tCols = tablebookstemp.getTableColsList();
		//��ȡ��ǰsheetҳ���ֶε�����
		int tColsNum = tCols.size();
		for (int j = 0; j <= tColsNum-1;j++) {
			TableCols tableColTempCols = new TableCols();
			tableColTempCols = tCols.get(j);
			//�������ƴ��
			sql.append(tableColTempCols.getCol_name_en()+" ");
			sql.append(tableColTempCols.getCol_type()+"(");
			sql.append(tableColTempCols.getCol_len()+") ");
			String primary_key = tableColTempCols.getCol_pri_key();
			String not_null =tableColTempCols.getCol_null();
			String def = tableColTempCols.getCol_def();
			String comment = tableColTempCols.getCol_name_zh();
			if(primary_key.equals("��")) {
			sql.append(primary_key+" ");
			}
			if(not_null.equals("��")) {
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
