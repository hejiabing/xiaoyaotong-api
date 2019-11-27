package com.xiaoyaotong.api.companyitem.dto;

import java.io.Serializable;

public class ProductStockSyncDTO implements Serializable{

	private String enterpriseId;
	
	private String productCode;
	
	private String batchNo;
	
	private String deadLine;
	
	private String stock;
	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}
}
