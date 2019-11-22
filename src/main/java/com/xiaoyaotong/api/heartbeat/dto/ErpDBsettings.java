package com.xiaoyaotong.api.heartbeat.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 */
public class ErpDBsettings implements Serializable {

	private String dbType;// 数据库类型
	private String dbIP;// 数据库IP
	private String dbPort;// 数据库端口
	private String dbName;// 数据库名称
	private String dbLoginName;// 登录名
	private String dbLoginPW;// 密码
	private String oracleType; // Orace类型
	private String enterpriseId;// 批发商ID
	private String secret;// 签名秘钥

	public String getOracleType() {
		return oracleType;
	}

	public void setOracleType(String oracleType) {
		this.oracleType = oracleType;
	}

	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String getDbIP() {
		return dbIP;
	}

	public void setDbIP(String dbIP) {
		this.dbIP = dbIP;
	}

	public String getDbPort() {
		return dbPort;
	}

	public void setDbPort(String dbPort) {
		this.dbPort = dbPort;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDbLoginName() {
		return dbLoginName;
	}

	public void setDbLoginName(String dbLoginName) {
		this.dbLoginName = dbLoginName;
	}

	public String getDbLoginPW() {
		return dbLoginPW;
	}

	public void setDbLoginPW(String dbLoginPW) {
		this.dbLoginPW = dbLoginPW;
	}

}
