package com.xiaoyaotong.api.companyitem.dto;

import java.io.Serializable;

public class ProductPriceSyncDTO implements Serializable{

	private String enterpriseId;
	
	private String productCode;
	
	private String price;
 
	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

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
}
