package com.xiaoyaotong.api.heartbeat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.xiaoyaotong.api.heartbeat.config.ErpSettingsEnum;
import com.xiaoyaotong.api.heartbeat.dto.ErpClientSettings;
import com.xiaoyaotong.api.heartbeat.entity.ErpSettings;
import com.xiaoyaotong.api.heartbeat.service.ErpSettingsService;
import com.xiaoyaotong.api.login.annotation.Authorization;
import com.xiaoyaotong.api.login.config.Constants;

@RestController
@RequestMapping("/erpsettings")
public class ErpSettingsController {

	@Autowired
	private ErpSettingsService erpSettingsService;
	
	@ResponseBody
	@RequestMapping("/save")
	@Authorization(way = Constants.SIGN)
	public ResponseEntity<HashMap> saveERPsettings(@RequestBody ErpClientSettings clientSettings){
		List<ErpSettings> settingList = new ArrayList<ErpSettings>();
		
		if(clientSettings.getProductSettings() != null){
			ErpSettings erpSettings = new ErpSettings();
			erpSettings.setCompanyId(clientSettings.getEnterpriseId());
			erpSettings.setCompanyName(clientSettings.getEnterpriseName());
			erpSettings.setPanelType(ErpSettingsEnum.product.getSettingType());	
			erpSettings.setPanelContent(JSON.toJSONString(clientSettings.getProductSettings()));
			settingList.add(erpSettings);
		}
		if(clientSettings.getProductPriceSettings() != null){
			ErpSettings erpSettings = new ErpSettings();
			erpSettings.setCompanyId(clientSettings.getEnterpriseId());
			erpSettings.setCompanyName(clientSettings.getEnterpriseName());
			erpSettings.setPanelType(ErpSettingsEnum.price.getSettingType());	
			erpSettings.setPanelContent(JSON.toJSONString(clientSettings.getProductPriceSettings()));
			settingList.add(erpSettings);
		}
		if(clientSettings.getProductStockSettings() != null){
			ErpSettings erpSettings = new ErpSettings();
			erpSettings.setCompanyId(clientSettings.getEnterpriseId());
			erpSettings.setCompanyName(clientSettings.getEnterpriseName());
			erpSettings.setPanelType(ErpSettingsEnum.stock.getSettingType());	
			erpSettings.setPanelContent(JSON.toJSONString(clientSettings.getProductStockSettings()));
			settingList.add(erpSettings);
		}
		if(clientSettings.getDbSettings() != null){
			ErpSettings erpSettings = new ErpSettings();
			erpSettings.setCompanyId(clientSettings.getEnterpriseId());
			erpSettings.setCompanyName(clientSettings.getEnterpriseName());
			erpSettings.setPanelType(ErpSettingsEnum.db.getSettingType());	
			erpSettings.setPanelContent(JSON.toJSONString(clientSettings.getDbSettings()));
			settingList.add(erpSettings);
		}
		erpSettingsService.insetOrUpdateSettings(settingList);
		HashMap map = new HashMap();
        map.put("all",1);
        map.put("success",1);
        return new ResponseEntity<HashMap>(map, HttpStatus.OK);
	}
}
