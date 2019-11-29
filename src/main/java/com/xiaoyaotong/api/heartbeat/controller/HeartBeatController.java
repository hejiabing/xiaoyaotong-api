package com.xiaoyaotong.api.heartbeat.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xiaoyaotong.api.company.service.CompanyService;
import com.xiaoyaotong.api.login.annotation.Authorization;
import com.xiaoyaotong.api.login.config.Constants;

@RestController
@RequestMapping("/heartbeat")
public class HeartBeatController {

	@Autowired
	private	CompanyService companyService;
	@ResponseBody
	@RequestMapping("/updateHearBeat")
	@Authorization(way = Constants.SIGN)
	public ResponseEntity<HashMap> updateHearBeat(@RequestBody Integer companyId){
		HashMap map = new HashMap();
        map.put("all",companyService.updateHeartBeat(companyId));
        map.put("success",1);
		return new ResponseEntity<HashMap>(map, HttpStatus.OK);
	}
}
