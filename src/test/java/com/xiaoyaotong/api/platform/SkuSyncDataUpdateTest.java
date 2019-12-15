package com.xiaoyaotong.api.platform;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xiaoyaotong.api.platform.service.SkuSyncDataUpdate;
import com.xiaoyaotong.api.util.RedisUtilService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkuSyncDataUpdateTest {

	@Autowired
	private RedisUtilService redisUtil;
	@Autowired
	private SkuSyncDataUpdate skuSyncDataUpdate;
	
	@Test
	public void stockConsumerTest(){
		skuSyncDataUpdate.stockProducer("69027161", 1212);
		skuSyncDataUpdate.stockProducer("81364361686", 1212);
		skuSyncDataUpdate.stockConsumer();
	}
}
