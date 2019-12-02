package com.xiaoyaotong.api.search.serviceImpl;

import com.xiaoyaotong.api.search.dao.ESPlatformSkuDAO;
import com.xiaoyaotong.api.search.entity.ESPlatformSku;
import com.xiaoyaotong.api.search.service.ESPlatformSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：billHe
 * @description：可以销售并搜索到的商品服务
 * @date ：2019/12/2 10:00 PM
 */
@Service
public class ESPlatformSkuServiceImpl implements ESPlatformSkuService {

    @Autowired
    ESPlatformSkuDAO esPlatformSkuDAO;

    @Override
    public void addESPlatformSku(ESPlatformSku esPlatformSku) {
        esPlatformSkuDAO.save(esPlatformSku);
    }
}
