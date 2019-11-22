package com.xiaoyaotong.api.heartbeat.dto;

import java.io.Serializable;

public class ErpClientSettings implements Serializable{

	private Integer enterpriseId;
	
	private String enterpriseName;
	
	private ErpDBsettings dbSettings;
	
	private ErpProductSetting productSettings;
	
	private ErpProductSetting productStockSettings;
	
	private ErpProductSetting productPriceSettings;
	
/*	private ErpCustomer customerSettings;

	private ErpOrderIssued orderIssued ;
	
	private ErpOrderDelivery orderDelivery;*/
	
	public Integer getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Integer enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public ErpDBsettings getDbSettings() {
		return dbSettings;
	}

	public void setDbSettings(ErpDBsettings dbSettings) {
		this.dbSettings = dbSettings;
	}

	public ErpProductSetting getProductSettings() {
		return productSettings;
	}

	public void setProductSettings(ErpProductSetting productSettings) {
		this.productSettings = productSettings;
	}

	public ErpProductSetting getProductStockSettings() {
		return productStockSettings;
	}

	public void setProductStockSettings(ErpProductSetting productStockSettings) {
		this.productStockSettings = productStockSettings;
	}

	public ErpProductSetting getProductPriceSettings() {
		return productPriceSettings;
	}

	public void setProductPriceSettings(ErpProductSetting productPriceSettings) {
		this.productPriceSettings = productPriceSettings;
	}

	 
/*
	public ErpCustomer getCustomerSettings() {
		return customerSettings;
	}

	public void setCustomerSettings(ErpCustomer customerSettings) {
		this.customerSettings = customerSettings;
	}

	public ErpOrderIssued getOrderIssued() {
		return orderIssued;
	}

	public void setOrderIssued(ErpOrderIssued orderIssued) {
		this.orderIssued = orderIssued;
	}

	public ErpOrderDelivery getOrderDelivery() {
		return orderDelivery;
	}

	public void setOrderDelivery(ErpOrderDelivery orderDelivery) {
		this.orderDelivery = orderDelivery;
	}

 */
}
