package com._520it.crm.query;

import org.apache.commons.lang.StringUtils;

import lombok.Setter;
@Setter
public class BrandQueryObject extends QueryObject {
	private String keyword;
	/**
	 * keyword关键字查询,根据品牌信息查询
	 * @return
	 */
	public String getKeyword(){
		return StringUtils.isNotBlank(keyword)?keyword:null;
	}
}
