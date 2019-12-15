package com.xiaoyaotong.api.platform.service;

public interface SkuSyncDataUpdate {

	public void stockProducer(String companySkuCode,Integer companyId);
	
	public void stockConsumer();
	
	public void priceProducer(String companySkuCode,Integer companyId);
	
	public void priceConsumer();
}
