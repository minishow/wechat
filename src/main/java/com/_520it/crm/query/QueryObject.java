package com._520it.crm.query;


public class QueryObject {
	/**
	 * 给page和rows添加默认值
	 */
	private Integer page=1;//当前页
	private Integer rows=10;//每页条数
	public Integer getStart(){
		return (this.page-1)*this.rows;
	}
}
