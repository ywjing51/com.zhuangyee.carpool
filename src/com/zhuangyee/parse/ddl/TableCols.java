package com.zhuangyee.parse.ddl;

import java.io.Serializable;
/**
 * 
 * @author zhuangyee jinfengYang
 *
 */

public class TableCols implements Serializable {

	/**
	 * version id
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 中文名 
	 */
	private String col_name_zh;
	
	/**
	 * 英文名
	 */
	private String col_name_en;
	
	/**
	 * 类型
	 */
	private String col_type;
	
	/**
	 * 长度
	 */
	private int col_len;
	
	/**
	 * 主键
	 */
    private String col_pri_key;
    
    /**
            * 可空
     */
    private String col_null;
    
    /**
            * 默认值
     */
    private String col_def;
    
   /**
         * 备注
    */
   private String col_comment;

	/**
	 * @return the col_name_zh
	 */
	public String getCol_name_zh() {
		return col_name_zh;
	}

	/**
	 * @param col_name_zh the col_name_zh to set
	 */
	public void setCol_name_zh(String col_name_zh) {
		this.col_name_zh = col_name_zh;
	}

	/**
	 * @return the col_name_en
	 */
	public String getCol_name_en() {
		return col_name_en;
	}

	/**
	 * @param col_name_en the col_name_en to set
	 */
	public void setCol_name_en(String col_name_en) {
		this.col_name_en = col_name_en;
	}

	/**
	 * @return the col_type
	 */
	public String getCol_type() {
		return col_type;
	}

	/**
	 * @param col_type the col_type to set
	 */
	public void setCol_type(String col_type) {
		this.col_type = col_type;
	}

	/**
	 * @return the col_len
	 */
	public int getCol_len() {
		return col_len;
	}

	/**
	 * @param col_len the col_len to set
	 */
	public void setCol_len(int col_len) {
		this.col_len = col_len;
	}

	/**
	 * @return the col_pri_key
	 */
	public String getCol_pri_key() {
		return col_pri_key;
	}

	/**
	 * @param col_pri_key the col_pri_key to set
	 */
	public void setCol_pri_key(String col_pri_key) {
		this.col_pri_key = col_pri_key;
	}

	/**
	 * @return the col_null
	 */
	public String getCol_null() {
		return col_null;
	}

	/**
	 * @param col_null the col_null to set
	 */
	public void setCol_null(String col_null) {
		this.col_null = col_null;
	}

	/**
	 * @return the col_def
	 */
	public String getCol_def() {
		return col_def;
	}

	/**
	 * @param col_def the col_def to set
	 */
	public void setCol_def(String col_def) {
		this.col_def = col_def;
	}

	/**
	 * @return the col_comment
	 */
	public String getCol_comment() {
		return col_comment;
	}

	/**
	 * @param col_comment the col_comment to set
	 */
	public void setCol_comment(String col_comment) {
		this.col_comment = col_comment;
	}
   
   
    
}
