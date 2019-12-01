package com.xiaoyaotong.api.companyitem.dto;

import java.io.Serializable;

public class ProductPriceSyncDTO implements Serializable{

	private String enterpriseId;
	
	private String skuCode;
	
	private String price;
 
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
}
