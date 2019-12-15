package com.xiaoyaotong.api.platform.serviceImpl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xiaoyaotong.api.companyitem.entity.CompanySkuBatch;
import com.xiaoyaotong.api.companyitem.service.CompanySkuBatchService;
import com.xiaoyaotong.api.companyitem.service.CompanySkuPriceService;
import com.xiaoyaotong.api.platform.entity.PlatformSku;
import com.xiaoyaotong.api.platform.service.PlatformSkuService;
import com.xiaoyaotong.api.platform.service.SkuSyncDataUpdate;
import com.xiaoyaotong.api.util.DateUtil;
import com.xiaoyaotong.api.util.RedisUtilService;

@Service("skuSyncDataUpdate")
public class SkuSyncDataUpdateImpl implements SkuSyncDataUpdate {

	private static Logger log = LoggerFactory.getLogger(SkuSyncDataUpdateImpl.class);
			
	private final String STOCK_MSGQUEUE = "STOCKMSGQUEUE";
	private final String PRICE_MSGQUEUE = "PRICEMSGQUEUE";
	
	@Autowired
	private PlatformSkuService platformSkuService;
	@Autowired
	private CompanySkuBatchService companySkuBatchService;
	@Autowired
	private CompanySkuPriceService companySkuPriceService;
	@Autowired
	private RedisUtilService redisUtil;
	
	@Override
	public void stockProducer(String companySkuCode, Integer companyId) {
		long number = redisUtil.lpush(STOCK_MSGQUEUE, companyId+"_"+companySkuCode);		
		log.info("库存更新消息队列剩余消息条数："+number);
	}

	@Override
	public void stockConsumer() {
		while(true){
			String companyIdAndSku = redisUtil.rpop(STOCK_MSGQUEUE);
			if(StringUtils.isEmpty(companyIdAndSku)){
				return;
			}else{
				List<String> list = Arrays.asList(companyIdAndSku.split("_"));
				Integer companyId = Integer.valueOf(list.get(0));
				String companySkuCode = list.get(1);
				log.info("库存更新消费消息队列companyId:{},companySkuCode{}",companyId,companySkuCode);
				List<PlatformSku> platformSkuList =platformSkuService.getSkuByCompanyIdAndSkuCode(companyId, companySkuCode);
				List<CompanySkuBatch> comSkuCodeList = companySkuBatchService.getValidCompanySkuBatch(companyId, companySkuCode);
				
				if(platformSkuList.size() == 1){//未克隆，无近效期品，默认取12个月以上效期的
					Map<String,Object> validStockMap = new HashMap<String,Object>();
					for(CompanySkuBatch oneBatch : comSkuCodeList){
						Integer validMonth = DateUtil.getOffsetMonth(oneBatch.getDeadLine());;
						if(validMonth >= 12){
							if(validStockMap.get("stock") == null){
								validStockMap.put("stock", oneBatch.getStock().intValue());
								validStockMap.put("deadLines", oneBatch.getDeadLine());
								validStockMap.put("batchNos", oneBatch.getBatchNo());
							}else{
								validStockMap.put("stock", ((Integer)validStockMap.get("stock")).intValue() + oneBatch.getStock().intValue());
								validStockMap.put("deadLines", validStockMap.get("deadLines")+"/"+oneBatch.getDeadLine());
								validStockMap.put("batchNos", validStockMap.get("batchNos")+"/"+oneBatch.getBatchNo());
							}
						}
					}
					PlatformSku platformSku = platformSkuList.get(0);
					platformSku.setBatchNos(validStockMap.get("batchNos").toString());
					platformSku.setDeadlineNos(validStockMap.get("deadLines").toString());
					platformSku.setStocks((Integer)validStockMap.get("stock"));
					platformSku.setUpdateTime(new Date());
					platformSku.setUpdateUser("skuSyncDataJob");
					platformSkuService.updatePlatformSku(platformSku );
				}else{
					Map<Integer,Integer> validStockMap = new HashMap<Integer,Integer>();
					Map<Integer,String> validDeadLinesMap = new HashMap<Integer,String>();
					Map<Integer,String> validBatchNosMap = new HashMap<Integer,String>();
					for(PlatformSku platSku : platformSkuList){
						
					}
					for(CompanySkuBatch oneBatch : comSkuCodeList){
						Integer validMonth =  DateUtil.getOffsetMonth(oneBatch.getDeadLine());;
						if(validStockMap.get(validMonth) == null){
							validStockMap.put(validMonth, oneBatch.getStock().intValue());
							validDeadLinesMap.put(validMonth, oneBatch.getDeadLine());
							validBatchNosMap.put(validMonth, oneBatch.getBatchNo());
						}else{
							validStockMap.put(validMonth, validStockMap.get(validMonth) + oneBatch.getStock().intValue());
							validDeadLinesMap.put(validMonth, validDeadLinesMap.get(validMonth)+"/"+oneBatch.getDeadLine());
							validBatchNosMap.put(validMonth, validBatchNosMap.get(validMonth)+"/"+oneBatch.getBatchNo());
						}
					}
					
					
				}
				
			}
		}
	}

	@Override
	public void priceProducer(String companySkuCode, Integer companyId) {
		long number = redisUtil.lpush(PRICE_MSGQUEUE, companyId+"_"+companySkuCode);		
		log.info("价格更新消息队列剩余消息条数："+number);
	}

	@Override
	public void priceConsumer() {
		// TODO Auto-generated method stub
		
	}

}
