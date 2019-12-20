package com.xiaoyaotong.api.platform.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import com.xiaoyaotong.api.platform.service.SkuSyncDataUpdate;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class CalculateStockToPlatformSkuJob {

	@Autowired
	private SkuSyncDataUpdate skuSyncDataUpdate;
	
	@Scheduled(cron = "0 */3 * * * ?")
	public void updatePlatformStock(){
		skuSyncDataUpdate.stockConsumer();
	}
	
	@Scheduled(cron = "0 */3 * * * ?")
	public void updatePlatformPrice(){
		skuSyncDataUpdate.priceConsumer();
	}
}
