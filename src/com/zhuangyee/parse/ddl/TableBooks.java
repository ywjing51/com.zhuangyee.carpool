package com.zhuangyee.parse.ddl;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author zhuangyee jinfengYang
 *
 */
public class TableBooks implements Serializable {

	/**
	 * version id
	 */
	private static final long serialVersionUID = -7000940152357752646L;

	/**
	 * ±íÃû 
	 */
	private String tableName;

	/**
	 * ±í×Ö¶Î
	 */
	private List<TableCols> tableColsList;

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the tableColsList
	 */
	public List<TableCols> getTableColsList() {
		return tableColsList;
	}

	/**
	 * @param tableColsList the tableColsList to set
	 */
	public void setTableColsList(List<TableCols> tableColsList) {
		this.tableColsList = tableColsList;
	}

	
	
	

	
}
