package com._520it.crm.query;

import org.apache.commons.lang.StringUtils;

import lombok.Getter;
import lombok.Setter;
@Setter@Getter
public class ProductInfoQueryObject extends QueryObject {
	/*private String keyword;*/
	private String productName;
	private String productPartName;
	private Long productTypeId;
	private Long brandId;
	/**
	 * keyword关键字查询,根据品牌信息查询
	 * @return
	 */
	/*public String getKeyword(){
		return StringUtils.isNotBlank(keyword)?keyword:null;
	}*/
	public String getProductName(){
		return StringUtils.isNotBlank(productName)?productName:null;
	}
	public String getProductPartName(){
		return StringUtils.isNotBlank(productPartName)?productPartName:null;
	}
}
