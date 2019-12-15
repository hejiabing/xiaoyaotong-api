package com.xiaoyaotong.api.platform.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CalculateStockToPlatformSkuJob {

	@Scheduled(cron = "0 */10 * * * ?")
	public void updatePlatformStock(){
		
	}
}
