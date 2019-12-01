package com.xiaoyaotong.api.companyitem.dto;

import java.io.Serializable;

public class ProductPriceSyncDTO implements Serializable{

	private String companyId;
	
	private String skuCode;
	
	private String price;
 
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
}
