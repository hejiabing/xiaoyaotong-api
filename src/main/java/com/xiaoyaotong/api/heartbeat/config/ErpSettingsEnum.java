package com.xiaoyaotong.api.heartbeat.config;

/**
 * ERP数据同步配置类型枚举
 * @author xulongfei
 *
 */
public enum ErpSettingsEnum {

	db(1, "数据库配置"),
	product(2, "商品数据同步配置"),
	price(3, "价格同步配置"),
	stock(4, "库存同步配置");
	
	private Integer settingType;
	private String settingName;
	
	ErpSettingsEnum(Integer settingType, String settingName){
		this.settingType = settingType;
		this.settingName = settingName;
	}
	
	public Integer getSettingType() {
		return settingType;
	}
	
	public String getSettingName() {
		return settingName;
	}
}
