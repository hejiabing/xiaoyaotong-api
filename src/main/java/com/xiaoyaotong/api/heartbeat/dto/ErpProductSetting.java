package com.xiaoyaotong.api.heartbeat.dto;

import java.io.Serializable;

/**
 * ERP基础类
 */
public class ErpProductSetting implements Serializable {
	 
	private String openDock;// 1：开启对接 ；0：关闭对接
	
	private String enterpriseId;// 企业Id
	
	private String sqlContext;// 查询的sql语句
	
	public String getOpenDock() {
		return openDock;
	}

	public void setOpenDock(String openDock) {
		this.openDock = openDock;
	}

	public String getSqlContext() {
		return sqlContext;
	}

	public void setSqlContext(String sqlContext) {
		this.sqlContext = sqlContext;
	}

	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

}
