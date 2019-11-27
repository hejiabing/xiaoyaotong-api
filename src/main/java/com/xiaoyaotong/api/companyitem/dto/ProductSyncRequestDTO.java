package com.xiaoyaotong.api.companyitem.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 商品同步请求类
 * @author xulongfei
 *
 */
public class ProductSyncRequestDTO<T> implements Serializable{

	/**
	 * 是否全量
	 */
	private int isAll = 0;
	
	private List<T> productDTOList;

	public int getIsAll() {
		return isAll;
	}

	public void setIsAll(int isAll) {
		this.isAll = isAll;
	}

	public List<T> getProductDTOList() {
		return productDTOList;
	}

	public void setProductDTOList(List<T> productDTOList) {
		this.productDTOList = productDTOList;
	}

	 
	 
}
