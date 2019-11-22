package com.xiaoyaotong.api.companyitem.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 商品同步请求类
 * @author xulongfei
 *
 */
public class ProductInfoRequestDTO implements Serializable{

	/**
	 * 是否全量
	 */
	private int isAll = 0;
	
	private List<ProductInfoDTO> productDTOList;

	public int getIsAll() {
		return isAll;
	}

	public void setIsAll(int isAll) {
		this.isAll = isAll;
	}

	public List<ProductInfoDTO> getProductDTOList() {
		return productDTOList;
	}

	public void setProductDTOList(List<ProductInfoDTO> productDTOList) {
		this.productDTOList = productDTOList;
	}

	 
	 
}
