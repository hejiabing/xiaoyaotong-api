package com.xiaoyaotong.api.heartbeat.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyaotong.api.heartbeat.entity.ErpSettings;
import com.xiaoyaotong.api.heartbeat.mapper.ErpSettingsMapper;
import com.xiaoyaotong.api.heartbeat.service.ErpSettingsService;

@Service("erpSettingsService")
public class ErpSettingsServiceImpl implements ErpSettingsService{

	@Autowired
	private ErpSettingsMapper erpSettingsMapper;
	@Override
	public int insertErpSettings(ErpSettings erpSettings) {
		return erpSettingsMapper.insertSelective(erpSettings);
	}

	@Override
	public int updateErpSettings(ErpSettings erpSettings) {
		return erpSettingsMapper.updateByPrimaryKeySelective(erpSettings);
	}

	@Override
	public int insetOrUpdateSettings(List<ErpSettings> settingList) {
		return erpSettingsMapper.insetOrUpdateSettings(settingList);
	}

}
