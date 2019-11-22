package com.xiaoyaotong.api.heartbeat.service;

import java.util.List;

import com.xiaoyaotong.api.heartbeat.entity.ErpSettings;

public interface ErpSettingsService {

	public int insertErpSettings(ErpSettings erpSettings);
	
	public int updateErpSettings(ErpSettings erpSettings);
	
	public int insetOrUpdateSettings(List<ErpSettings> settingList);
}
