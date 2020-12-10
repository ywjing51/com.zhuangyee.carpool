package com.zhuangyee.parse.ddl;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author zhuangyee jinfengYang
 *
 */
public class TableObject implements Serializable {

	/**
     * verdion id
     */
	private static final long SerialVersionUId = 1L;
	
	/**
	 * ±í
	 */
	private List<TableBooks> tablebookList;

	/**
	 * @return the tablebookList
	 */
	public List<TableBooks> getTablebookList() {
		return tablebookList;
	}

	/**
	 * @param tablebookList the tablebookList to set
	 */
	public void setTablebookList(List<TableBooks> tablebookList) {
		this.tablebookList = tablebookList;
	}
	
	
}
