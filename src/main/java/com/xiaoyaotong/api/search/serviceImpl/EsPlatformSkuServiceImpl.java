package com.xiaoyaotong.api.search.serviceImpl;

import com.xiaoyaotong.api.search.dao.EsPlatformSkuDao;
import com.xiaoyaotong.api.search.entity.EsPlatformSku;
import com.xiaoyaotong.api.search.service.EsPlatformSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：billHe
 * @description：可以销售并搜索到的商品服务
 * @date ：2019/12/2 10:00 PM
 */
@Service
public class EsPlatformSkuServiceImpl implements EsPlatformSkuService {

    @Autowired
    EsPlatformSkuDao esPlatformSkuDAO;

    @Override
    public void addESPlatformSku(EsPlatformSku esPlatformSku) {
        esPlatformSkuDAO.save(esPlatformSku);
    }
}
